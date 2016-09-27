/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.dto;

import com.entities.Profile;
import org.ocpsoft.prettytime.PrettyTime;

/**
 *
 * @author Ahmed
 */
public class Loyalities {
    
    private String ID;
    private String FullName;
    private String FirstVisits;
    private String LastVisits;
    private String AverageSpend;
    private String TotalSpend;
    private String NoOfVisits;
    String FV,LV;

    public Loyalities(String ID, String FullName, String FirstVisits, String LastVisits, String AverageSpend, String TotalSpend, String NoOfVisits, String FV, String LV, Profile profile) {
        this.ID = ID;
        this.FullName = FullName;
        this.FirstVisits = FirstVisits;
        this.LastVisits = LastVisits;
        this.AverageSpend = AverageSpend;
        this.TotalSpend = TotalSpend;
        this.NoOfVisits = NoOfVisits;
        this.FV = FV;
        this.LV = LV;
        this.profile = profile;
    }
    
    private Profile profile;

    public Loyalities(String ID, String FullName, String FirstVisits, String LastVisits, String AverageSpend, String TotalSpend, String NoOfVisits, Profile profile) {
        this.ID = ID;
        this.FullName = FullName;
        this.FirstVisits = FirstVisits;
        this.LastVisits = LastVisits;
        this.AverageSpend = AverageSpend;
        this.TotalSpend = TotalSpend;
        this.NoOfVisits = NoOfVisits;
        this.profile = profile;
    }            
    
    public String getFullName() {
        return FullName;
    }

    public void setFullName(String FullName) {
        this.FullName = FullName;
    }

    public String getFV() {
        return FV;
    }

    public void setFV(String FV) {
        this.FV = FV;
    }

    public String getLV() {
        return LV;
    }

    public void setLV(String LV) {
        this.LV = LV;
    }

    public String getFirstVisits() {
        return FirstVisits;
    }

    public void setFirstVisits(String FirstVisits) {
        this.FirstVisits = FirstVisits;
    }

    public String getLastVisits() {
        return LastVisits;
    }

    public void setLastVisits(String LastVisits) {
        this.LastVisits = LastVisits;
    }

    public String getAverageSpend() {
        return AverageSpend;
    }

    public void setAverageSpend(String AverageSpend) {
        this.AverageSpend = AverageSpend;
    }

    public String getTotalSpend() {
        return TotalSpend;
    }

    public void setTotalSpend(String TotalSpend) {
        this.TotalSpend = TotalSpend;
    }

    public String getNoOfVisits() {
        return NoOfVisits;
    }

    public void setNoOfVisits(String NoOfVisits) {
        this.NoOfVisits = NoOfVisits;
    }

    public Profile getProfile() {
        return profile;
    }

    public void setProfile(Profile profile) {
        this.profile = profile;
    }

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }
    
    
    
    
}
