/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.beans;

import com.core.AdminRepositoryImpl;
import com.core.AppManager;
import com.dto.CampaignDetails;
import com.entities.Campaignbatch;
import com.entities.Campaigns;
import com.entities.Merchantprofile;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.primefaces.event.SelectEvent;
import org.primefaces.model.UploadedFile;
import org.primefaces.model.chart.PieChartModel;

/**
 *
 * @author Ahmed
 */
@ManagedBean
@ViewScoped
public class MyCampaignMBean {
    
    
    private UploadedFile file;
    private Date opendate;
    private Date closedate;
    private String campaigntype,frequency,campaignname,subject,content,mindeposit,username;
    private Merchantprofile mprofile;
    private List<Campaignbatch> mycampaigns;    
    private List<Campaigns> campaigners;
    private List<Campaignbatch> fileredCampaigns;
    private Campaignbatch selectedCampaign;
    private List<CampaignDetails> campaignDetails=new ArrayList();
    private List<CampaignDetails> fileredCampaignDetails;
    private CampaignDetails selectedCampaignDetails=new CampaignDetails();    
    
    private PieChartModel pieModel1;
 
    
    AppManager manager=new AppManager(new AdminRepositoryImpl());
    /**
     * Creates a new instance of MyCampaignMBean
     */
    public MyCampaignMBean() {
    }

    
    @PostConstruct
    public void init() 
    {
        
        FacesContext context = FacesContext.getCurrentInstance();  
        HttpServletRequest request = (HttpServletRequest)context.getExternalContext().getRequest();  
        HttpSession httpSession = request.getSession(false);          
        username=(String) httpSession.getAttribute("username");  
        mprofile=manager.getMerchantprofile(username);
        mycampaigns = manager.getMyCampaigns(mprofile);
        for(Campaignbatch cb:mycampaigns){
        CampaignDetails campaignD=new CampaignDetails();
        campaignD.setBatch(cb);
        List<Campaigns> c =manager.getCampaigners(cb);
        if(c!=null){
        campaignD.setCampaigners(campaigners);
        campaignD.setTotal(c.size());
        for(Campaigns cc:c){
            campaignD.setReadStatus(cc.getReadstatus()+campaignD.getReadStatus());
            campaignD.setSentStatus(cc.getSentstatus()+campaignD.getSentStatus());            
            campaignD.setRedeemStatus(cc.getRedeemstatus()+campaignD.getRedeemStatus());            
        }
        }       
        campaignDetails.add(campaignD);
        }
                      
    }
    
    
    public UploadedFile getFile() {
        return file;
    }

    public void setFile(UploadedFile file) {
        this.file = file;
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

    public String getMindeposit() {
        return mindeposit;
    }

    public void setMindeposit(String mindeposit) {
        this.mindeposit = mindeposit;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Merchantprofile getMprofile() {
        return mprofile;
    }

    public void setMprofile(Merchantprofile mprofile) {
        this.mprofile = mprofile;
    }
   

    public List<Campaignbatch> getMycampaigns() {
        return mycampaigns;
    }

    public void setMycampaigns(List<Campaignbatch> mycampaigns) {
        this.mycampaigns = mycampaigns;
    }

    public List<Campaigns> getCampaigners() {
        return campaigners;
    }

    public void setCampaigners(List<Campaigns> campaigners) {
        this.campaigners = campaigners;
    }

    public List<Campaignbatch> getFileredCampaigns() {
        return fileredCampaigns;
    }

    public void setFileredCampaigns(List<Campaignbatch> fileredCampaigns) {
        this.fileredCampaigns = fileredCampaigns;
    }

    public Campaignbatch getSelectedCampaign() {
        return selectedCampaign;
    }

    public void setSelectedCampaign(Campaignbatch selectedCampaign) {
        this.selectedCampaign = selectedCampaign;
    }

    public List<CampaignDetails> getCampaignDetails() {
        return campaignDetails;
    }

    public void setCampaignDetails(List<CampaignDetails> campaignDetails) {
        this.campaignDetails = campaignDetails;
    }

    public CampaignDetails getSelectedCampaignDetails() {
        return selectedCampaignDetails;
    }

    public void setSelectedCampaignDetails(CampaignDetails selectedCampaignDetails) {
        this.selectedCampaignDetails = selectedCampaignDetails;
    }

    public List<CampaignDetails> getFileredCampaignDetails() {
        return fileredCampaignDetails;
    }

    public void setFileredCampaignDetails(List<CampaignDetails> fileredCampaignDetails) {
        this.fileredCampaignDetails = fileredCampaignDetails;
    }
   
    
    
                    
     public void onRowSelect(SelectEvent event)
    {
        try {
            
            createPieModel((CampaignDetails) event.getObject());
            FacesContext.getCurrentInstance().getExternalContext().getFlash().put("pieModel1", pieModel1);
            FacesContext.getCurrentInstance().getExternalContext().getFlash().put("selectedCampaignDetails", event.getObject());
            FacesContext.getCurrentInstance().getExternalContext().redirect("campaigndetails");
        } catch (IOException ex) {
            Logger.getLogger(MyCampaignMBean.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
     
     
     private void createPieModel(CampaignDetails selectedCampaignDetails) {
        pieModel1 = new PieChartModel();                          
        pieModel1.set("Sent", selectedCampaignDetails.getSentStatus());        
        pieModel1.set("Read", selectedCampaignDetails.getReadStatus());
        pieModel1.set("Redeem", selectedCampaignDetails.getRedeemStatus());                 
        pieModel1.setTitle("Campaign Chart");
        pieModel1.setLegendPosition("w");
    }
     
     
     
     
     
    }