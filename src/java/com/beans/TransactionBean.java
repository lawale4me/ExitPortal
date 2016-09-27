/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.beans;

import com.core.AdminRepositoryImpl;
import com.core.AppManager;
import com.entities.Transactions;
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
public class TransactionBean {

    private List<Transactions> tranxs;
    private Transactions selectedTranx,filteredTranx;

    /**
     * Creates a new instance of TransactionBean
     */
    public TransactionBean() {

    }

    @PostConstruct
    public void init() {
        AppManager appManager = new AppManager(new AdminRepositoryImpl());
        tranxs = appManager.getTransactions();
    }

    public Transactions getSelectedTranx() {
        return selectedTranx;
    }

    public void setSelectedTranx(Transactions selectedTranx) {
        this.selectedTranx = selectedTranx;
    }

    public List<Transactions> getTranxs() {
        return tranxs;
    }

    public void setTranxs(List<Transactions> tranxs) {
        this.tranxs = tranxs;
    }

    public Transactions getFilteredTranx() {
        return filteredTranx;
    }

    public void setFilteredTranx(Transactions filteredTranx) {
        this.filteredTranx = filteredTranx;
    }
    
    

}
