/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.entities;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;
import org.codehaus.jackson.annotate.JsonIgnore;

/**
 *
 * @author Ahmed
 */
@Entity
@Table(name = "merchant")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Merchant.findAll", query = "SELECT m FROM Merchant m"),
    @NamedQuery(name = "Merchant.findByMerchantID", query = "SELECT m FROM Merchant m WHERE m.merchantID = :merchantID"),
    @NamedQuery(name = "Merchant.findByMerchantName", query = "SELECT m FROM Merchant m WHERE m.merchantName = :merchantName"),
    @NamedQuery(name = "Merchant.findByMerchantStatus", query = "SELECT m FROM Merchant m WHERE m.merchantStatus = :merchantStatus"),
    @NamedQuery(name = "Merchant.findByMerchantCredit", query = "SELECT m FROM Merchant m WHERE m.merchantCredit = :merchantCredit")})
public class Merchant implements Serializable {
    @OneToMany(mappedBy = "merchantid")
    private Collection<Campaignbatch> campaignbatchCollection;
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "merchantID")
    private Integer merchantID;
    @Column(name = "merchantName")
    private String merchantName;
    @Column(name = "merchantStatus")
    private Boolean merchantStatus;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "merchantCredit")
    private Double merchantCredit;
    @OneToMany(mappedBy = "globalMerchantID")
    private Collection<Branch> branchCollection;

    public Merchant() {
    }

    public Merchant(Integer merchantID) {
        this.merchantID = merchantID;
    }

    public Integer getMerchantID() {
        return merchantID;
    }

    public void setMerchantID(Integer merchantID) {
        this.merchantID = merchantID;
    }

    public String getMerchantName() {
        return merchantName;
    }

    public void setMerchantName(String merchantName) {
        this.merchantName = merchantName;
    }

    public Boolean getMerchantStatus() {
        return merchantStatus;
    }

    public void setMerchantStatus(Boolean merchantStatus) {
        this.merchantStatus = merchantStatus;
    }

    public Double getMerchantCredit() {
        return merchantCredit;
    }

    public void setMerchantCredit(Double merchantCredit) {
        this.merchantCredit = merchantCredit;
    }

    @XmlTransient
    @JsonIgnore
    public Collection<Branch> getBranchCollection() {
        return branchCollection;
    }

    public void setBranchCollection(Collection<Branch> branchCollection) {
        this.branchCollection = branchCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (merchantID != null ? merchantID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Merchant)) {
            return false;
        }
        Merchant other = (Merchant) object;
        if ((this.merchantID == null && other.merchantID != null) || (this.merchantID != null && !this.merchantID.equals(other.merchantID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.entities.Merchant[ merchantID=" + merchantID + " ]";
    }

    @XmlTransient
    @JsonIgnore
    public Collection<Campaignbatch> getCampaignbatchCollection() {
        return campaignbatchCollection;
    }

    public void setCampaignbatchCollection(Collection<Campaignbatch> campaignbatchCollection) {
        this.campaignbatchCollection = campaignbatchCollection;
    }
    
}
