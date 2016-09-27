/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.beans;

import com.core.AdminRepositoryImpl;
import com.core.AppManager;
import com.dto.CampaignType;
import com.dto.Frequency;
import com.entities.Branch;
import com.entities.Campaignbatch;
import com.entities.Campaigns;
import com.entities.Merchantprofile;
import com.entities.Profile;
import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.primefaces.event.FlowEvent;
import org.primefaces.event.FileUploadEvent;
import org.primefaces.model.UploadedFile;

/**
 *
 * @author Ahmed
 */
@ManagedBean
@ViewScoped
public class CampaignMBean implements Serializable {
    
    private UploadedFile file;
    private Date opendate;
    private Date closedate;
    private String campaigntype,frequency,campaignname,subject,content,mindeposit,username;     
    private List<Branch> branches;
    private List<Branch> selectedItems;
    
    private Branch branch;
    private Merchantprofile mprofile;
    AppManager manager=new AppManager(new AdminRepositoryImpl());     
    
    //FOR WIZARD
    
    private boolean skip;
    
    /**
     * Creates a new instance of CampaignMBean
     */
    public CampaignMBean() {
        
    }
    
    
    @PostConstruct
    public void init() {        
        
        FacesContext context = FacesContext.getCurrentInstance();  
        HttpServletRequest request = (HttpServletRequest)context.getExternalContext().getRequest();  
        HttpSession httpSession = request.getSession(false);          
        username=(String) httpSession.getAttribute("username");  
        mprofile=manager.getMerchantprofile(username);
        System.out.println("Username:"+username);            
        branches = (List<Branch>) mprofile.getBranch().getGlobalMerchantID().getBranchCollection();                
    }
 
    public UploadedFile getFile() {
        return file;
    }
 
    public void setFile(UploadedFile file) {        
        this.file = file;
    }

    /**
     *
     * @return 
     */
    public void upload() 
    {
                
        System.out.println("file:"+file);  
        if(file == null) {                                    
            String str; 
            try 
            {                        
                
           // str = file.getInputstream().toString();            
           // byte[] foto = str.getBytes();
            
            Campaignbatch campaignBatch=new Campaignbatch();
            campaignBatch.setCampaignimage(content.getBytes());//(foto);
            campaignBatch.setMessage(content);
            campaignBatch.setOpendate(opendate);
            campaignBatch.setClosedate(closedate);
            campaignBatch.setFrequency(Frequency.valueOf(frequency).ordinal());
            campaignBatch.setCampaigndetails(subject);
            campaignBatch.setBatchdate(new Date());
            campaignBatch.setCampaignname(campaignname);
            campaignBatch.setMerchantid(mprofile.getBranch().getGlobalMerchantID());
            campaignBatch.setAdminuser(mprofile);
            campaignBatch.setCampaigntype(CampaignType.valueOf(campaigntype).ordinal());
            
            manager.addCampaign(campaignBatch);
            
            if(CampaignType.TargetAudience.ordinal()==campaignBatch.getCampaigntype().intValue()){
              HashSet<Profile> campaigners= manager.getCampaigners(mindeposit,opendate,closedate);
              for(Profile profile:campaigners){
                  manager.addCampaign(new Campaigns(profile,campaignBatch));
              }
            }
            
            
            
//            HttpServletRequest hs = (HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext().getRequest();
//            FacesContext fconx = FacesContext.getCurrentInstance();            
//            ExternalContext ec = fconx.getExternalContext();
//            ec.redirect(hs.getContextPath()+"/home");
            
            campaignname="";
            campaigntype="";frequency="";campaignname="";subject="";content="";mindeposit="";
            closedate=null;opendate=null;
             
            FacesMessage message = new FacesMessage("Succesful", campaignname+" Campaign Has been Created.");
            FacesContext.getCurrentInstance().addMessage(null, message);
            
            
            } catch (Exception ex) {
                FacesMessage message = new FacesMessage("FAILED", ex.getMessage());
                FacesContext.getCurrentInstance().addMessage(null, message);
                Logger.getLogger(CampaignMBean.class.getName()).log(Level.SEVERE, null, ex);                
            }
        }
        
        else{                
                FacesMessage message = new FacesMessage("FAILED", "File is null");
                FacesContext.getCurrentInstance().addMessage(null, message);
                Logger.getLogger(CampaignMBean.class.getName()).log(Level.SEVERE, null, "File is null");               
        }
        
    }

    public Date getOpendate() {
        return opendate;
    }

    public void setOpendate(Date opendate) {
        this.opendate = opendate;
    }

    public Date getClosedate() {
        return closedate;
    }

    public void setClosedate(Date closedate) {
        this.closedate = closedate;
    }

    public String getCampaigntype() {
        return campaigntype;
    }

    public void setCampaigntype(String campaigntype) {
        this.campaigntype = campaigntype;
    }

    public String getFrequency() {
        return frequency;
    }

    public void setFrequency(String frequency) {
        this.frequency = frequency;
    }

    public String getCampaignname() {
        return campaignname;
    }

    public void setCampaignname(String campaignname) {
        this.campaignname = campaignname;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
                        
    public boolean isSkip() {
        return skip;
    }
 
    public void setSkip(boolean skip) {
        this.skip = skip;
    }
     
    public String onFlowProcess(FlowEvent event) {        
        if(skip) {
            skip = false;   //reset in case user goes back
            return "confirm";
        }
        else {
            return event.getNewStep();
        }
    }

    public List<Branch> getBranches() {
        return branches;
    }    
  
    public void setBranches(List<Branch> branches) {
        this.branches = branches;
    }
    
    public Branch getBranch() {
        return branch;
    }

    public void setBranch(Branch branch) {
        this.branch = branch;
    }            

    public String getMindeposit() {
        return mindeposit;
    }

    public void setMindeposit(String mindeposit) {
        this.mindeposit = mindeposit;
    }         

    public List<Branch> getSelectedItems() {
        return selectedItems;
    }

    public void setSelectedItems(List<Branch> selectedItems) {
        this.selectedItems = selectedItems;
    }
 
    
    public void handleFileUpload(FileUploadEvent event) {
        file=event.getFile();
        System.out.println("File File:"+file); 
        FacesMessage msg = new FacesMessage("Succesful", event.getFile().getFileName() + " is uploaded.");
        FacesContext.getCurrentInstance().addMessage(null, msg);
    }

    
    
    
}
