/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.beans;

import com.core.AdminRepositoryImpl;
import com.core.AppManager;
import com.dto.Loyalities;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

/**
 *
 * @author Ahmed
 */
@ManagedBean
@RequestScoped
public class CustomersMBean {

     private List<Loyalities> loyalities;
     private Loyalities selectedLoyality;
     private List<Loyalities> filteredLoyals;

    /**
     * Creates a new instance of TransactionBean
     */
    public CustomersMBean() {

    }

    @PostConstruct
    public void init() {
        AppManager appManager = new AppManager(new AdminRepositoryImpl());
        loyalities = appManager.getLoyalities();        
    }

    public List<Loyalities> getLoyalities() {
        return loyalities;
    }

    public void setLoyalities(List<Loyalities> loyalities) {
        this.loyalities = loyalities;
    }

    public Loyalities getSelectedLoyality() {
        return selectedLoyality;
    }

    public void setSelectedLoyality(Loyalities selectedLoyality) {
        this.selectedLoyality = selectedLoyality;
    }

    public List<Loyalities> getFilteredLoyals() {
        return filteredLoyals;
    }

    public void setFilteredLoyals(List<Loyalities> filteredLoyals) {
        this.filteredLoyals = filteredLoyals;
    }


    
    
    
    
    
    
}
