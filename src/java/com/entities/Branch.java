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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Table(name = "branch")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Branch.findAll", query = "SELECT b FROM Branch b"),
    @NamedQuery(name = "Branch.findByBranchId", query = "SELECT b FROM Branch b WHERE b.branchId = :branchId"),
    @NamedQuery(name = "Branch.findByBranchName", query = "SELECT b FROM Branch b WHERE b.branchName = :branchName"),
    @NamedQuery(name = "Branch.findByBranchLocation", query = "SELECT b FROM Branch b WHERE b.branchLocation = :branchLocation"),
    @NamedQuery(name = "Branch.findByBranchCredit", query = "SELECT b FROM Branch b WHERE b.branchCredit = :branchCredit")})
public class Branch implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "branch_id")
    private Integer branchId;
    @Column(name = "branchName")
    private String branchName;
    @Column(name = "branchLocation")
    private String branchLocation;
    @Column(name = "branchCredit")
    private Integer branchCredit;
    @JoinColumn(name = "globalMerchantID", referencedColumnName = "merchantID")
    @ManyToOne
    private Merchant globalMerchantID;
    @OneToMany(mappedBy = "branch")
    private Collection<Merchantprofile> merchantprofileCollection;

    public Branch() {
    }

    public Branch(Integer branchId) {
        this.branchId = branchId;
    }

    public Integer getBranchId() {
        return branchId;
    }

    public void setBranchId(Integer branchId) {
        this.branchId = branchId;
    }

    public String getBranchName() {
        return branchName;
    }

    public void setBranchName(String branchName) {
        this.branchName = branchName;
    }

    public String getBranchLocation() {
        return branchLocation;
    }

    public void setBranchLocation(String branchLocation) {
        this.branchLocation = branchLocation;
    }

    public Integer getBranchCredit() {
        return branchCredit;
    }

    public void setBranchCredit(Integer branchCredit) {
        this.branchCredit = branchCredit;
    }

    public Merchant getGlobalMerchantID() {
        return globalMerchantID;
    }

    public void setGlobalMerchantID(Merchant globalMerchantID) {
        this.globalMerchantID = globalMerchantID;
    }

    @XmlTransient
    @JsonIgnore
    public Collection<Merchantprofile> getMerchantprofileCollection() {
        return merchantprofileCollection;
    }

    public void setMerchantprofileCollection(Collection<Merchantprofile> merchantprofileCollection) {
        this.merchantprofileCollection = merchantprofileCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (branchId != null ? branchId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Branch)) {
            return false;
        }
        Branch other = (Branch) object;
        if ((this.branchId == null && other.branchId != null) || (this.branchId != null && !this.branchId.equals(other.branchId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.entities.Branch[ branchId=" + branchId + " ]";
    }
    
}
