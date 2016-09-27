/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.core;


import com.entities.Campaignbatch;
import com.entities.Campaigns;
import com.entities.Merchantprofile;
import com.entities.Profile;
import com.entities.Transactions;
import java.util.List;
import javax.persistence.EntityManager;

/**
 *
 * @author Ahmed
 */

public class AdminRepositoryImpl extends RepositoryBase implements AdminRepository 
{
    
    public AdminRepositoryImpl() {
    }
    
    @Override
    public List<Transactions> getTransactions() {
         if(session!=null&&session.isActive())
        {
        List<Transactions> tranxs = manager.createNamedQuery("Transactions.findAllDesc", Transactions.class).getResultList();
        return tranxs.isEmpty() ? null : tranxs;            
        }
        else
        {
        EntityManager manager = RepositoryManager.getManager();
        List<Transactions> tranxs = manager.createNamedQuery("Transactions.findAllDesc", Transactions.class).getResultList();        
        manager.close();
        return tranxs.isEmpty() ? null : tranxs;   
        }
    }

    @Override
    public List<Profile> getProfiles() {
          if(session!=null&&session.isActive())
        {
        List<Profile> profiles = manager.createNamedQuery("Profile.findAll", Profile.class).getResultList();
        return profiles.isEmpty() ? null : profiles;            
        }
        else
        {
        EntityManager manager = RepositoryManager.getManager();
        List<Profile> profiles = manager.createNamedQuery("Profile.findAll", Profile.class).getResultList();
        manager.close();
        return profiles.isEmpty() ? null : profiles;   
        }
    }

    @Override
    public Profile getProfile(String criteria) {
        if(session!=null&&session.isActive())
        {
        List<Profile> profiles = manager.createNamedQuery("Profile.findByUserName", Profile.class).setParameter("userName", criteria).getResultList();
        return profiles.isEmpty() ? null : profiles.get(0); 
        }
        else
        {
        EntityManager manager = RepositoryManager.getManager();
        List<Profile> profiles = manager.createNamedQuery("Profile.findByUserName", Profile.class).setParameter("userName", criteria).getResultList();
        manager.close();
        return profiles.isEmpty() ? null : profiles.get(0); 
        } 
    }

    @Override
    public List<Profile> getProfilesByDate() {
           if(session!=null&&session.isActive())
        {
        List<Profile> profiles = manager.createNamedQuery("Profile.findAllByDate", Profile.class).getResultList();
        return profiles.isEmpty() ? null : profiles;            
        }
        else
        {
        EntityManager manager = RepositoryManager.getManager();
        List<Profile> profiles = manager.createNamedQuery("Profile.findAllByDate", Profile.class).getResultList();
        manager.close();
        return profiles.isEmpty() ? null : profiles;   
        }
    }

    @Override
    public Merchantprofile getMerchantProfile(String username) {
           if(session!=null&&session.isActive())
        {
        List<Merchantprofile> profile = manager.createNamedQuery("Merchantprofile.findByUserName", Merchantprofile.class).setParameter("userName", username).getResultList();
        return profile.isEmpty() ? null : profile.get(0); 
        }
        else
        {
        EntityManager manager = RepositoryManager.getManager();
        List<Merchantprofile> profile = manager.createNamedQuery("Merchantprofile.findByUserName", Merchantprofile.class).setParameter("userName", username).getResultList();
        manager.close();
        return profile.isEmpty() ? null : profile.get(0); 
        } 
    }

    @Override
    public Merchantprofile validate(String userid, String password) {
                     
        EntityManager manager = RepositoryManager.getManager();
        String query="SELECT m FROM Merchantprofile m WHERE m.userName = :userName and m.password = :password";
        List<Merchantprofile> adminUser =    manager.createQuery(query,Merchantprofile.class).setParameter("userName", userid).setParameter("password", password).getResultList();
        return adminUser.isEmpty() ? null : adminUser.get(0);
    }

    @Override
    public void addCampaignBatch(Campaignbatch campaignBatch) {        
         if(session!=null&&session.isActive())
        {
         manager.persist(campaignBatch);
        }
        else
        {
        EntityManager manager = RepositoryManager.getManager();
        manager.getTransaction().begin();
        manager.persist(campaignBatch);
        manager.getTransaction().commit();
    }
    }   

    @Override
    public List<Transactions> getCampaigners(Double mindeposit) {
        if(session!=null&&session.isActive())
        {
        List<Transactions> tranxs = manager.createNamedQuery("Transactions.findByAmountGreater", Transactions.class).setParameter("amount", mindeposit).getResultList();
        return tranxs.isEmpty() ? null : tranxs;            
        }
        else
        {
        EntityManager manager = RepositoryManager.getManager();
        List<Transactions> tranxs = manager.createNamedQuery("Transactions.findByAmountGreater", Transactions.class).setParameter("amount", mindeposit).getResultList();        
        manager.close();
        return tranxs.isEmpty() ? null : tranxs;   
        }
    }

    @Override
    public void addCampaign(Campaigns campaign) {
        if(session!=null&&session.isActive())
        {
         manager.persist(campaign);
        }
        else
        {
        EntityManager manager = RepositoryManager.getManager();
        manager.getTransaction().begin();
        manager.persist(campaign);
        manager.getTransaction().commit();
    }  
    }

    @Override
    public List<Campaignbatch> getMyCampaigns(Merchantprofile mprofile) {
         if(session!=null&&session.isActive())
        {
        List<Campaignbatch> campaigns = manager.createNamedQuery("Campaignbatch.findByProfile", Campaignbatch.class).setParameter("profile", mprofile).getResultList();
        return campaigns.isEmpty() ? null : campaigns; 
        }
        else
        {
        EntityManager manager = RepositoryManager.getManager();
        List<Campaignbatch> campaigns = manager.createNamedQuery("Campaignbatch.findByProfile", Campaignbatch.class).setParameter("profile", mprofile).getResultList();
        manager.close();
        return campaigns.isEmpty() ? null : campaigns; 
        } 
    }

    @Override
    public List<Campaigns> getCampaigners(Campaignbatch cb) {
         if(session!=null&&session.isActive())
        {
        List<Campaigns> campaigners = manager.createNamedQuery("Campaigns.findByCampaignBatch", Campaigns.class).setParameter("campaignbatch", cb).getResultList();
        return campaigners.isEmpty() ? null : campaigners;            
        }
        else
        {
        EntityManager manager = RepositoryManager.getManager();
        List<Campaigns> campaigners = manager.createNamedQuery("Campaigns.findByCampaignBatch", Campaigns.class).setParameter("campaignbatch", cb).getResultList();
        manager.close();
        return campaigners.isEmpty() ? null : campaigners;                 
        }
    }
   
}
