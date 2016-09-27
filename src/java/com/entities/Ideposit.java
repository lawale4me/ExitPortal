/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.entities;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Ahmed
 */
@Entity
@Table(name = "ideposit")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Ideposit.findAll", query = "SELECT i FROM Ideposit i"),
    @NamedQuery(name = "Ideposit.findByIdepositID", query = "SELECT i FROM Ideposit i WHERE i.idepositID = :idepositID"),
    @NamedQuery(name = "Ideposit.findByAccountnumber", query = "SELECT i FROM Ideposit i WHERE i.accountnumber = :accountnumber"),
    @NamedQuery(name = "Ideposit.findByUuid", query = "SELECT i FROM Ideposit i WHERE i.uuid = :uuid"),
    @NamedQuery(name = "Ideposit.findByAmount", query = "SELECT i FROM Ideposit i WHERE i.amount = :amount"),
    @NamedQuery(name = "Ideposit.findByDepsitor", query = "SELECT i FROM Ideposit i WHERE i.depsitor = :depsitor"),
    @NamedQuery(name = "Ideposit.findByComment", query = "SELECT i FROM Ideposit i WHERE i.comment = :comment")})
public class Ideposit implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idepositID")
    private Integer idepositID;
    @Column(name = "accountnumber")
    private String accountnumber;
    @Column(name = "accountname")
    private String accountname;
    @Column(name = "uuid")
    private String uuid;
    @Column(name = "amount")
    private String amount;
    @Column(name = "depsitor")
    private String depsitor;
    @Column(name = "comment")
    private String comment;

    public Ideposit() {
    }

    public Ideposit(Integer idepositID) {
        this.idepositID = idepositID;
    }

    public String getAccountname() {
        return accountname;
    }

    public void setAccountname(String accountname) {
        this.accountname = accountname;
    }        
    
    
    public Integer getIdepositID() {
        return idepositID;
    }

    public void setIdepositID(Integer idepositID) {
        this.idepositID = idepositID;
    }

    public String getAccountnumber() {
        return accountnumber;
    }

    public void setAccountnumber(String accountnumber) {
        this.accountnumber = accountnumber;
    }

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    public String getDepsitor() {
        return depsitor;
    }

    public void setDepsitor(String depsitor) {
        this.depsitor = depsitor;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idepositID != null ? idepositID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Ideposit)) {
            return false;
        }
        Ideposit other = (Ideposit) object;
        if ((this.idepositID == null && other.idepositID != null) || (this.idepositID != null && !this.idepositID.equals(other.idepositID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.entities.Ideposit[ idepositID=" + idepositID + " ]";
    }
    
}
