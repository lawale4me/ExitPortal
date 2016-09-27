/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.services;

import com.core.AdminRepositoryImpl;
import com.core.AppManager;
import com.dto.TransactionResponse;
import com.entities.Transactions;
import java.util.List;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 *
 * @author Ahmed
 */
@Path("/getTransactions")
public class GetTransactions {
    @GET    
    @Produces(MediaType.APPLICATION_JSON)
    public List<Transactions> logTranx() {        
        AppManager appManager = new AppManager(new AdminRepositoryImpl());        
        List<Transactions> tranxs=appManager.getTransactions();        
        return tranxs;
    }
}
