/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.dto;

import com.entities.Campaignbatch;
import com.entities.Campaigns;
import java.awt.event.ActionEvent;
import java.util.List;
import javax.annotation.PostConstruct;
import org.primefaces.model.chart.PieChartModel;

/**
 *
 * @author Ahmed
 */
public class CampaignDetails {
    
    private Campaignbatch batch;
    private List<Campaigns> campaigners;
    private int readStatus,sentStatus,redeemStatus,total;
    private PieChartModel pieModel=new PieChartModel();
    
     @PostConstruct
    public void init() {  
        createPieModel();
    }

    public Campaignbatch getBatch() {
        return batch;
    }

    public void setBatch(Campaignbatch batch) {
        this.batch = batch;
    }       
    
    
    public List<Campaigns> getCampaigners() {
        return campaigners;
    }

    public void setCampaigners(List<Campaigns> campaigners) {
        this.campaigners = campaigners;
    }

    public int getReadStatus() {
        return readStatus;
    }

    public void setReadStatus(int readStatus) {
        this.readStatus = readStatus;
    }

    public int getSentStatus() {
        return sentStatus;
    }

    public void setSentStatus(int sentStatus) {
        this.sentStatus = sentStatus;
    }

    public int getRedeemStatus() {
        return redeemStatus;
    }

    public void setRedeemStatus(int redeemStatus) {
        this.redeemStatus = redeemStatus;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }
    
    
     public PieChartModel getPieModel() {
        return pieModel;
    }
    public void setPieModel(PieChartModel pieModel) {
        this.pieModel = pieModel;
    }

     
    private void createPieModel() {
        pieModel = new PieChartModel();         
        pieModel.set("Sent", getSentStatus());        
        pieModel.set("Read", getReadStatus());
        pieModel.set("Redeem", getRedeemStatus());                 
        pieModel.setTitle("Campaign Chart");
        pieModel.setLegendPosition("w");
    }
           
    
    
    
    
    
}
