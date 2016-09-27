/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.core;


import com.dto.Loyalities;
import com.dto.Response;
import com.dto.Util;
import com.entities.Campaignbatch;
import com.entities.Campaigns;
import com.entities.Merchantprofile;
import com.entities.Profile;
import com.entities.Transactions;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.ocpsoft.prettytime.PrettyTime;


/**
 *
 * @author Ahmed
 */
public class AppManager 
{
    
    private final AdminRepository adminrepo;


    public AppManager(AdminRepositoryImpl adminRepositoryImpl) {
        this.adminrepo = adminRepositoryImpl;
    }

     
    

    public List<Transactions> getTransactions() {
        UnitOfWorkSession ses = adminrepo.begin(); 
         List<Transactions> tranxs=adminrepo.getTransactions();
        ses.commit();
        return tranxs;
    }


     public List<Profile> getProfiles() {
        UnitOfWorkSession ses = adminrepo.begin(); 
         List<Profile> tranxs=adminrepo.getProfiles();
        ses.commit();
        return tranxs;
    }
    
     
     public Profile getProfile(String criteria) {
        UnitOfWorkSession ses = adminrepo.begin(); 
        Profile profile=adminrepo.getProfile(criteria);
        ses.commit();
        return profile;
    }
     
     public List<Profile> getProfilesByDate() {
        UnitOfWorkSession ses = adminrepo.begin(); 
        List<Profile> profile=adminrepo.getProfilesByDate();
        ses.commit();
        return profile;
    }
    
    public List<Loyalities> getLoyalities() {
        List<Loyalities> loyals=new ArrayList();
        List<Profile> profiles=getProfilesByDate();
        Double totalSpend=(double) 0;
        
        Date FirstVisit =null;
        Date LastVisit =null;
        PrettyTime FV = new PrettyTime();
        PrettyTime LV = new PrettyTime();
        String FV1 = null,LV1 = null;
		//System.out.println(p.format(new Date()));        
        List<Transactions> averageSpend=new ArrayList();
        for(Profile p:profiles){
            
            Iterator<Transactions> tranxx=p.getTransactionsCollection().iterator();
            while(tranxx.hasNext()){                
               Transactions tran= tranxx.next();
               if(FirstVisit==null)
               {
                  FV1= FV.format(tran.getTrxnDate());
                  LV1= LV.format(tran.getTrxnDate());                   
                   FirstVisit=tran.getTrxnDate();
                   LastVisit=tran.getTrxnDate();
               }
               if(LastVisit.before(tran.getTrxnDate())){LastVisit=tran.getTrxnDate();LV1=LV.format(LastVisit);}
               averageSpend.add(tran);
               if(tran.getAmount()!=null){               
                totalSpend+=tran.getAmount();
               }
            }
//            Double average = averageSpend                        
//            .stream()
//            .filter(t -> t.getAmount()!=null)                    
//            .mapToDouble(Transactions::getAmount)
//            .average()
//            .getAsDouble();
             Double average = totalSpend/p.getTransactionsCollection().size();                                        
            loyals.add(new Loyalities(String.valueOf(p.getId()), p.getFullName(),FirstVisit!=null?FirstVisit.toString():"Never",LastVisit!=null?LastVisit.toString():"Never", average.toString(),totalSpend.toString(), String.valueOf(p.getTransactionsCollection().size()),FV1,LV1, p));
            totalSpend=new Double(0);   
            FirstVisit =null; LastVisit =null;FV1=null;LV1=null;
          }
          
        return loyals;
    }
     
 
       public Merchantprofile getMerchantprofile(String username) {
         UnitOfWorkSession ses = adminrepo.begin(); 
         Merchantprofile mprofile=adminrepo.getMerchantProfile(username);
         ses.commit();
        return mprofile;
       }

    public Response login(String userid, String password) throws Exception {
      Log.l.infoLog.info("Attempt to logon to the application "+userid);
      Response authres=new Response();
        UnitOfWorkSession ses = adminrepo.begin();
        try {
            password = Util.hash(password);
        } catch (Exception ex) {            
            Log.l.errorLog.error(ex.getMessage());
            Log.l.infoLog.info("Password hashing issue "+userid);
            throw new Exception("Password hashing issue");
        }
        
        
        
        Merchantprofile adminUser = adminrepo.validate(userid, password);
        if(adminUser!=null)
        {            
            if(true){
            if(adminUser.getStatus())
            {
            authres.setStatus(true);
            authres.setStatuscode(ResponseCodes.SUCCESSFUL);
            authres.setDescription("User exists");
            }
            else
            {
            authres.setStatuscode(ResponseCodes.USER_DISABLED);
            authres.setDescription("User is disabled");
            }
            }
            else{
                authres.setStatuscode(ResponseCodes.USER_EXPIRED);
                authres.setDescription("User password has expired");
            }
        } 
        else
        {             
             authres.setStatuscode(ResponseCodes.USER_NOT_FOUND);            
             authres.setDescription("Invalid username or password");     
        }                
        
        ses.commit();
        return authres;  
    }

    public void addCampaign(Campaignbatch campaignBatch) {
        UnitOfWorkSession ses = adminrepo.begin(); 
         adminrepo.addCampaignBatch(campaignBatch);
         ses.commit();
    }
    
    public void addCampaign(Campaigns campaign) {
        UnitOfWorkSession ses = adminrepo.begin(); 
         adminrepo.addCampaign(campaign);
         ses.commit();
    }

    public HashSet<Profile> getCampaigners(String mindeposit) {
        UnitOfWorkSession ses = adminrepo.begin(); 
        List<Transactions> campaigns=adminrepo.getCampaigners(Double.parseDouble(mindeposit.replaceAll("NGN", "").replaceAll(" ", "")));
        HashSet<Profile> profiles=new HashSet();
        for(Transactions tranx:campaigns){
            profiles.add(tranx.getUserName());
        }
        ses.commit();
        return profiles;        
    }

    public HashSet<Profile> getCampaigners(String mindeposit, Date opendate, Date closedate) {
         UnitOfWorkSession ses = adminrepo.begin(); 
        List<Transactions> campaigns=adminrepo.getCampaigners(Double.parseDouble(mindeposit.replaceAll("NGN", "").replaceAll(" ", "")));
        HashSet<Profile> profiles=new HashSet();        
        if(campaigns!=null){        
        for(Transactions tranx:campaigns){
            if(tranx.getTrxnDate().after(opendate)&&tranx.getTrxnDate().before(closedate)){
            profiles.add(tranx.getUserName());
            }
        }
        }
        ses.commit();
        return profiles; 
    }

    public List<Campaignbatch> getMyCampaigns(Merchantprofile mprofile) {
        UnitOfWorkSession ses = adminrepo.begin(); 
        List<Campaignbatch> campaigns=adminrepo.getMyCampaigns(mprofile);
        ses.commit();
        return campaigns;
    }

    public List<Campaigns> getCampaigners(Campaignbatch cb) {
        UnitOfWorkSession ses = adminrepo.begin(); 
        List<Campaigns> campaigns=adminrepo.getCampaigners(cb);              
        ses.commit();
        return campaigns; 
    }

  
    
     
}
