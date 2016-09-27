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
@Table(name = "campaigns")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Campaigns.findAll", query = "SELECT c FROM Campaigns c"),
    @NamedQuery(name = "Campaigns.findById", query = "SELECT c FROM Campaigns c WHERE c.id = :id"),
    @NamedQuery(name = "Campaigns.findByReadstatus", query = "SELECT c FROM Campaigns c WHERE c.readstatus = :readstatus"),
    @NamedQuery(name = "Campaigns.findBySentstatus", query = "SELECT c FROM Campaigns c WHERE c.sentstatus = :sentstatus"),
    @NamedQuery(name = "Campaigns.findByRedeemstatus", query = "SELECT c FROM Campaigns c WHERE c.redeemstatus = :redeemstatus"),
    @NamedQuery(name = "Campaigns.findByCampaignBatch", query = "SELECT c FROM Campaigns c WHERE c.campaignbatch = :campaignbatch"),
    @NamedQuery(name = "Campaigns.findByCampaigndate", query = "SELECT c FROM Campaigns c WHERE c.campaigndate = :campaigndate")})
public class Campaigns implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Column(name = "readstatus")
    private Integer readstatus;
    @Column(name = "sentstatus")
    private Integer sentstatus;
    @Column(name = "redeemstatus")
    private Integer redeemstatus;
    @Column(name = "campaigndate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date campaigndate;
    @JoinColumn(name = "profile", referencedColumnName = "ID")
    @ManyToOne
    private Profile profile;
    @JoinColumn(name = "campaignbatch", referencedColumnName = "id")
    @ManyToOne
    private Campaignbatch campaignbatch;

    public Campaigns() {
    }

    public Campaigns(Integer id) {
        this.id = id;
    }
    
    public Campaigns(Profile profile,Campaignbatch batch) {
        this.profile = profile;
        this.campaigndate=new Date();
        this.campaignbatch=batch;
        readstatus=0;
        sentstatus=0;
        redeemstatus=0;
        
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getReadstatus() {
        return readstatus;
    }

    public void setReadstatus(Integer readstatus) {
        this.readstatus = readstatus;
    }

    public Integer getSentstatus() {
        return sentstatus;
    }

    public void setSentstatus(Integer sentstatus) {
        this.sentstatus = sentstatus;
    }

    public Integer getRedeemstatus() {
        return redeemstatus;
    }

    public void setRedeemstatus(Integer redeemstatus) {
        this.redeemstatus = redeemstatus;
    }

    public Date getCampaigndate() {
        return campaigndate;
    }

    public void setCampaigndate(Date campaigndate) {
        this.campaigndate = campaigndate;
    }

    public Profile getProfile() {
        return profile;
    }

    public void setProfile(Profile profile) {
        this.profile = profile;
    }

    public Campaignbatch getCampaignbatch() {
        return campaignbatch;
    }

    public void setCampaignbatch(Campaignbatch campaignbatch) {
        this.campaignbatch = campaignbatch;
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
        if (!(object instanceof Campaigns)) {
            return false;
        }
        Campaigns other = (Campaigns) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.entities.Campaigns[ id=" + id + " ]";
    }
    
}
