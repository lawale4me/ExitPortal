/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dto;

/**
 *
 * @author Ahmed
 */
public class AuthenticationResponse
{
    private boolean authenticated;
    private String reason;

    public AuthenticationResponse(boolean authenticated, String reason)
    {
        this.authenticated = authenticated;
        this.reason = reason;
    }
    
    

    public boolean isAuthenticated()
    {
        return authenticated;
    }

    public void setAuthenticated(boolean authenticated)
    {
        this.authenticated = authenticated;
    }

    public String getReason()
    {
        return reason;
    }

    public void setReason(String reason)
    {
        this.reason = reason;
    }
}
