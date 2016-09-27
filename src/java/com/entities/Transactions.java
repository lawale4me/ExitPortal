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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Table(name = "transactions")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Transactions.findAll", query = "SELECT t FROM Transactions t"),
    @NamedQuery(name = "Transactions.findAllDesc", query = "SELECT t FROM Transactions t order by t.trxnDate desc"),
    @NamedQuery(name = "Transactions.findById", query = "SELECT t FROM Transactions t WHERE t.id = :id"),
    @NamedQuery(name = "Transactions.findByAction", query = "SELECT t FROM Transactions t WHERE t.action = :action"),
    @NamedQuery(name = "Transactions.findByBeneficiary", query = "SELECT t FROM Transactions t WHERE t.beneficiary = :beneficiary"),
    @NamedQuery(name = "Transactions.findByReference", query = "SELECT t FROM Transactions t WHERE t.reference = :reference"),
    @NamedQuery(name = "Transactions.findByDetails", query = "SELECT t FROM Transactions t WHERE t.details = :details"),
    @NamedQuery(name = "Transactions.findByLocation", query = "SELECT t FROM Transactions t WHERE t.location = :location"),
    @NamedQuery(name = "Transactions.findByUuid", query = "SELECT t FROM Transactions t WHERE t.uuid = :uuid"),
    @NamedQuery(name = "Transactions.findByStatus", query = "SELECT t FROM Transactions t WHERE t.status = :status"),
    @NamedQuery(name = "Transactions.findByGlobalMerchant", query = "SELECT t FROM Transactions t WHERE t.globalMerchant = :globalMerchant"),
    @NamedQuery(name = "Transactions.findByTrxnDate", query = "SELECT t FROM Transactions t WHERE t.trxnDate = :trxnDate"),
    @NamedQuery(name = "Transactions.findByAmount", query = "SELECT t FROM Transactions t WHERE t.amount = :amount"),
    @NamedQuery(name = "Transactions.findByAmountGreater", query = "SELECT t FROM Transactions t WHERE t.amount >= :amount"),
    @NamedQuery(name = "Transactions.findByLnglat", query = "SELECT t FROM Transactions t WHERE t.latlng = :latlng")})
public class Transactions implements Serializable {
    @Column(name = "latlng")
    private String latlng;
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID")
    private Integer id;
    @Column(name = "action")
    private String action;
    @Column(name = "beneficiary")
    private String beneficiary;
    @Column(name = "reference")
    private String reference;
    @Column(name = "details")
    private String details;
    @Column(name = "location")
    private String location;
    @Column(name = "uuid")
    private String uuid;
    @Column(name = "status")
    private String status;
    @Column(name = "globalMerchant")
    private Integer globalMerchant;
    @Column(name = "trxnDate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date trxnDate;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "amount")
    private Double amount;
    @JoinColumn(name = "userName", referencedColumnName = "userName")
    @ManyToOne
    private Profile userName;

    public Transactions() {  
    }

    public Transactions(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }

    public String getBeneficiary() {
        return beneficiary;
    }

    public void setBeneficiary(String beneficiary) {
        this.beneficiary = beneficiary;
    }

    public String getReference() {
        return reference;
    }

    public void setReference(String reference) {
        this.reference = reference;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Integer getGlobalMerchant() {
        return globalMerchant;
    }

    public void setGlobalMerchant(Integer globalMerchant) {
        this.globalMerchant = globalMerchant;
    }

    public Date getTrxnDate() {
        return trxnDate;
    }

    public void setTrxnDate(Date trxnDate) {
        this.trxnDate = trxnDate;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }


    public Profile getUserName() {
        return userName;
    }

    public void setUserName(Profile userName) {
        this.userName = userName;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Transactions)) {
            return false;
        }
        Transactions other = (Transactions) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.entities.Transactions[ id=" + id + " ]";
    }

    public String getLatlng() {
        return latlng;
    }

    public void setLatlng(String latlng) {
        this.latlng = latlng;
    }
    
}
