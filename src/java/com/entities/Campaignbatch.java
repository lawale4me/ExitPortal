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
import javax.persistence.Lob;
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
@Table(name = "campaignbatch")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Campaignbatch.findAll", query = "SELECT c FROM Campaignbatch c"),
    @NamedQuery(name = "Campaignbatch.findById", query = "SELECT c FROM Campaignbatch c WHERE c.id = :id"),
    @NamedQuery(name = "Campaignbatch.findByCampaignname", query = "SELECT c FROM Campaignbatch c WHERE c.campaignname = :campaignname"),
    @NamedQuery(name = "Campaignbatch.findByCampaigndetails", query = "SELECT c FROM Campaignbatch c WHERE c.campaigndetails = :campaigndetails"),
    @NamedQuery(name = "Campaignbatch.findByBatchdate", query = "SELECT c FROM Campaignbatch c WHERE c.batchdate = :batchdate"),
    @NamedQuery(name = "Campaignbatch.findByOpendate", query = "SELECT c FROM Campaignbatch c WHERE c.opendate = :opendate"),
    @NamedQuery(name = "Campaignbatch.findByClosedate", query = "SELECT c FROM Campaignbatch c WHERE c.closedate = :closedate"),
    @NamedQuery(name = "Campaignbatch.findByFrequency", query = "SELECT c FROM Campaignbatch c WHERE c.frequency = :frequency"),
    @NamedQuery(name = "Campaignbatch.findByCampaigntype", query = "SELECT c FROM Campaignbatch c WHERE c.campaigntype = :campaigntype"),
    @NamedQuery(name = "Campaignbatch.findByProfile", query = "SELECT c FROM Campaignbatch c WHERE c.adminuser = :profile"),
    @NamedQuery(name = "Campaignbatch.findByStatus", query = "SELECT c FROM Campaignbatch c WHERE c.status = :status"),
    @NamedQuery(name = "Campaignbatch.findByMindeposit", query = "SELECT c FROM Campaignbatch c WHERE c.mindeposit = :mindeposit")})
public class Campaignbatch implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Column(name = "campaignname")
    private String campaignname;
    @Column(name = "campaigndetails")
    private String campaigndetails;
    @Column(name = "batchdate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date batchdate;
    @Lob
    @Column(name = "message")
    private String message;
    @Column(name = "opendate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date opendate;
    @Column(name = "closedate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date closedate;
    @Column(name = "frequency")
    private Integer frequency;
    @Column(name = "campaigntype")
    private Integer campaigntype;
    @Lob
    @Column(name = "campaignimage")
    private byte[] campaignimage;
    @Basic(optional = false)
    @Column(name = "status")
    private int status;
    @Basic(optional = false)
    @Column(name = "mindeposit")
    private int mindeposit;
    @JoinColumn(name = "merchantid", referencedColumnName = "merchantID")
    @ManyToOne
    private Merchant merchantid;
    @JoinColumn(name = "adminuser", referencedColumnName = "ID")
    @ManyToOne
    private Merchantprofile adminuser;

    public Campaignbatch() {
    }

    public Campaignbatch(Integer id) {
        this.id = id;
    }

    public Campaignbatch(Integer id, int status, int mindeposit) {
        this.id = id;
        this.status = status;
        this.mindeposit = mindeposit;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCampaignname() {
        return campaignname;
    }

    public void setCampaignname(String campaignname) {
        this.campaignname = campaignname;
    }

    public String getCampaigndetails() {
        return campaigndetails;
    }

    public void setCampaigndetails(String campaigndetails) {
        this.campaigndetails = campaigndetails;
    }

    public Date getBatchdate() {
        return batchdate;
    }

    public void setBatchdate(Date batchdate) {
        this.batchdate = batchdate;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Date getOpendate() {
        return opendate;
    }

    public void setOpendate(Date opendate) {
        this.opendate = opendate;
    }

    public Date getClosedate() {
        return closedate;
    }

    public void setClosedate(Date closedate) {
        this.closedate = closedate;
    }

    public Integer getFrequency() {
        return frequency;
    }

    public void setFrequency(Integer frequency) {
        this.frequency = frequency;
    }

    public Integer getCampaigntype() {
        return campaigntype;
    }

    public void setCampaigntype(Integer campaigntype) {
        this.campaigntype = campaigntype;
    }

    public byte[] getCampaignimage() {
        return campaignimage;
    }

    public void setCampaignimage(byte[] campaignimage) {
        this.campaignimage = campaignimage;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public int getMindeposit() {
        return mindeposit;
    }

    public void setMindeposit(int mindeposit) {
        this.mindeposit = mindeposit;
    }

    public Merchant getMerchantid() {
        return merchantid;
    }

    public void setMerchantid(Merchant merchantid) {
        this.merchantid = merchantid;
    }

    public Merchantprofile getAdminuser() {
        return adminuser;
    }

    public void setAdminuser(Merchantprofile adminuser) {
        this.adminuser = adminuser;
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
        if (!(object instanceof Campaignbatch)) {
            return false;
        }
        Campaignbatch other = (Campaignbatch) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.entities.Campaignbatch[ id=" + id + " ]";
    }
    
}
