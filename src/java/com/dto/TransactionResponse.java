/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.dto;

import com.entities.Transactions;
import java.util.List;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Ahmed
 */

@XmlRootElement
public class TransactionResponse {

    List<Transactions> transactions;

    
    public TransactionResponse() {
    }               

    public List<Transactions> getTransactions() {
        return transactions;
    }

    public void setTransactions(List<Transactions> transactions) {
        this.transactions = transactions;
    }
    
}
