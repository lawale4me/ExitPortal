/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.entities;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Ahmed
 */
@Entity
@Table(name = "transactionhistory")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Transactionhistory.findAll", query = "SELECT t FROM Transactionhistory t"),
    @NamedQuery(name = "Transactionhistory.findByTranxID", query = "SELECT t FROM Transactionhistory t WHERE t.tranxID = :tranxID"),
    @NamedQuery(name = "Transactionhistory.findByUuid", query = "SELECT t FROM Transactionhistory t WHERE t.uuid = :uuid"),
    @NamedQuery(name = "Transactionhistory.findByTransactionDate", query = "SELECT t FROM Transactionhistory t WHERE t.transactionDate = :transactionDate"),
    @NamedQuery(name = "Transactionhistory.findByTranxStatus", query = "SELECT t FROM Transactionhistory t WHERE t.tranxStatus = :tranxStatus"),
    @NamedQuery(name = "Transactionhistory.findByDescription", query = "SELECT t FROM Transactionhistory t WHERE t.description = :description")})
public class Transactionhistory implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "tranxID")
    private Integer tranxID;
    @Column(name = "uuid")
    private String uuid;
    @Column(name = "transactionDate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date transactionDate;
    @Column(name = "tranxStatus")
    private Integer tranxStatus;
    @Column(name = "description")
    private String description;

    public Transactionhistory() {
    }

    public Transactionhistory(Integer tranxID) {
        this.tranxID = tranxID;
    }

    public Integer getTranxID() {
        return tranxID;
    }

    public void setTranxID(Integer tranxID) {
        this.tranxID = tranxID;
    }

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public Date getTransactionDate() {
        return transactionDate;
    }

    public void setTransactionDate(Date transactionDate) {
        this.transactionDate = transactionDate;
    }

    public Integer getTranxStatus() {
        return tranxStatus;
    }

    public void setTranxStatus(Integer tranxStatus) {
        this.tranxStatus = tranxStatus;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (tranxID != null ? tranxID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Transactionhistory)) {
            return false;
        }
        Transactionhistory other = (Transactionhistory) object;
        if ((this.tranxID == null && other.tranxID != null) || (this.tranxID != null && !this.tranxID.equals(other.tranxID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.entities.Transactionhistory[ tranxID=" + tranxID + " ]";
    }
    
}
