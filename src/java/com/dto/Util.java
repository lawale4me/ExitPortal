/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.dto;

/**
 *
 * @author Ahmed
 */
import com.core.Log;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
 
 
public class Util {
 
      public static HttpSession getSession() {
        return (HttpSession)
          FacesContext.
          getCurrentInstance().
          getExternalContext().
          getSession(false);
      }
       
      public static HttpServletRequest getRequest() {
       return (HttpServletRequest) FacesContext.
          getCurrentInstance().
          getExternalContext().getRequest();
      }
 
      public static String getUserName()
      {
        HttpSession session = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(false);
        return  session.getAttribute("username").toString();
      }
       
      public static String getUserId()
      {
        HttpSession session = getSession();
        if ( session != null )
            return (String) session.getAttribute("userid");
        else
            return null;
      }
      
      
       public static String hash(String password) throws Exception {
        try {
            MessageDigest sha512 = MessageDigest.getInstance("SHA-512");
            byte[] passwordBytes = password.getBytes();
            byte[] digest = sha512.digest(passwordBytes);
            StringBuilder stringBuilder = new StringBuilder();
            String s;
            for (byte b : digest) {
                s = Integer.toHexString((int) b & 0xff).toUpperCase();
                if (s.length() == 1) {
                    stringBuilder.append('0');
                }
                stringBuilder.append(s);
            }
            return stringBuilder.toString();
        } catch (NoSuchAlgorithmException ex) {
            
            Log.l.errorLog.error(ex.getMessage());
            throw new Exception("NoSuchAlgorithmException");
        }
    }
      
}
