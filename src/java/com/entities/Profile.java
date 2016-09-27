/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.entities;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;
import org.codehaus.jackson.annotate.JsonIgnore;

/**
 *
 * @author Ahmed
 */
@Entity
@Table(name = "profile")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Profile.findAll", query = "SELECT p FROM Profile p"),
    @NamedQuery(name = "Profile.findAllByDate", query = "SELECT p FROM Profile p order by p.id"),
    @NamedQuery(name = "Profile.findById", query = "SELECT p FROM Profile p WHERE p.id = :id"),
    @NamedQuery(name = "Profile.findByUserName", query = "SELECT p FROM Profile p WHERE p.userName = :userName"),
    @NamedQuery(name = "Profile.findByPassword", query = "SELECT p FROM Profile p WHERE p.password = :password"),
    @NamedQuery(name = "Profile.findByFullName", query = "SELECT p FROM Profile p WHERE p.fullName = :fullName"),
    @NamedQuery(name = "Profile.findByPhoneNo", query = "SELECT p FROM Profile p WHERE p.phoneNo = :phoneNo"),
    @NamedQuery(name = "Profile.findByEmail", query = "SELECT p FROM Profile p WHERE p.email = :email"),
    @NamedQuery(name = "Profile.findByLocation", query = "SELECT p FROM Profile p WHERE p.location = :location"),
    @NamedQuery(name = "Profile.findByUuid", query = "SELECT p FROM Profile p WHERE p.uuid = :uuid"),
    @NamedQuery(name = "Profile.findByStatus", query = "SELECT p FROM Profile p WHERE p.status = :status"),
    @NamedQuery(name = "Profile.findByDeviceId", query = "SELECT p FROM Profile p WHERE p.deviceId = :deviceId"),
    @NamedQuery(name = "Profile.findByRegDate", query = "SELECT p FROM Profile p WHERE p.regDate = :regDate"),
    @NamedQuery(name = "Profile.findByLatlng", query = "SELECT p FROM Profile p WHERE p.latlng = :latlng"),
    @NamedQuery(name = "Profile.findByDeviceType", query = "SELECT p FROM Profile p WHERE p.deviceType = :deviceType")})
public class Profile implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID")
    private Integer id;
    @Column(name = "userName")
    private String userName;
    @Column(name = "password")
    private String password;
    @Column(name = "fullName")
    private String fullName;
    @Column(name = "phoneNo")
    private String phoneNo;
    @Column(name = "email")
    private String email;
    @Column(name = "location")
    private String location;
    @Column(name = "uuid")
    private String uuid;
    @Column(name = "status")
    private Boolean status;
    @Column(name = "deviceId")
    private String deviceId;
    @Column(name = "regDate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date regDate;
    @Column(name = "latlng")
    private String latlng;
    @Column(name = "deviceType")
    private String deviceType;
    
    @OneToMany(mappedBy="profile")
    private Collection<Campaigns> campaignsCollection;
    @JoinColumn(name="userName", referencedColumnName="userName")
    private Collection<Transactions> transactionsCollection;

    public Profile() {
    }

    public Profile(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getPhoneNo() {
        return phoneNo;
    }

    public void setPhoneNo(String phoneNo) {
        this.phoneNo = phoneNo;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
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

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    public String getDeviceId() {
        return deviceId;
    }

    public void setDeviceId(String deviceId) {
        this.deviceId = deviceId;
    }

    public Date getRegDate() {
        return regDate;
    }

    public void setRegDate(Date regDate) {
        this.regDate = regDate;
    }

    public String getLatlng() {
        return latlng;
    }

    public void setLatlng(String latlng) {
        this.latlng = latlng;
    }

    public String getDeviceType() {
        return deviceType;
    }

    public void setDeviceType(String deviceType) {
        this.deviceType = deviceType;
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
        if (!(object instanceof Profile)) {
            return false;
        }
        Profile other = (Profile) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.entities.Profile[ id=" + id + " ]";
    }
    
    
    
     @XmlTransient
    @JsonIgnore
    public Collection<Campaigns> getCampaignsCollection() {
        return campaignsCollection;
    }

    public void setCampaignsCollection(Collection<Campaigns> campaignsCollection) {
        this.campaignsCollection = campaignsCollection;
    }

     @XmlTransient
    @JsonIgnore
    public Collection<Transactions> getTransactionsCollection() {
        return transactionsCollection;
    }

    public void setTransactionsCollection(Collection<Transactions> transactionsCollection) {
        this.transactionsCollection = transactionsCollection;
    }
    
    
    
    
    
}
