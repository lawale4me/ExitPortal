/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.dto;

import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Ahmed
 */

@XmlRootElement
public class NameResponse {
   boolean status;
   String ACCOUNTNAME;
   int statuscode;

    public NameResponse(boolean status, String ACCOUNTNAME, int statuscode) {
        this.status = status;
        this.ACCOUNTNAME = ACCOUNTNAME;
        this.statuscode = statuscode;
    }
      
    public NameResponse() {
        
    }
   
   
    public int getStatuscode() {
        return statuscode;
    }

    public void setStatuscode(int statuscode) {
        this.statuscode = statuscode;
    }      
   
    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public String getACCOUNTNAME() {
        return ACCOUNTNAME;
    }

    public void setACCOUNTNAME(String ACCOUNTNAME) {
        this.ACCOUNTNAME = ACCOUNTNAME;
    }

    
    
}
