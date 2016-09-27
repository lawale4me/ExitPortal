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
@Table(name = "merchantprofile")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Merchantprofile.findAll", query = "SELECT m FROM Merchantprofile m"),
    @NamedQuery(name = "Merchantprofile.findById", query = "SELECT m FROM Merchantprofile m WHERE m.id = :id"),
    @NamedQuery(name = "Merchantprofile.findByUserName", query = "SELECT m FROM Merchantprofile m WHERE m.userName = :userName"),
    @NamedQuery(name = "Merchantprofile.findByPassword", query = "SELECT m FROM Merchantprofile m WHERE m.password = :password"),
    @NamedQuery(name = "Merchantprofile.findByFullName", query = "SELECT m FROM Merchantprofile m WHERE m.fullName = :fullName"),
    @NamedQuery(name = "Merchantprofile.findByPhoneNo", query = "SELECT m FROM Merchantprofile m WHERE m.phoneNo = :phoneNo"),
    @NamedQuery(name = "Merchantprofile.findByEmail", query = "SELECT m FROM Merchantprofile m WHERE m.email = :email"),
    @NamedQuery(name = "Merchantprofile.findByLocation", query = "SELECT m FROM Merchantprofile m WHERE m.location = :location"),
    @NamedQuery(name = "Merchantprofile.findByUuid", query = "SELECT m FROM Merchantprofile m WHERE m.uuid = :uuid"),
    @NamedQuery(name = "Merchantprofile.findByStatus", query = "SELECT m FROM Merchantprofile m WHERE m.status = :status"),
    @NamedQuery(name = "Merchantprofile.findByLatlng", query = "SELECT m FROM Merchantprofile m WHERE m.latlng = :latlng"),
    @NamedQuery(name = "Merchantprofile.findByRole", query = "SELECT m FROM Merchantprofile m WHERE m.role = :role")})
public class Merchantprofile implements Serializable {
    @OneToMany(mappedBy = "adminuser")
    private Collection<Campaignbatch> campaignbatchCollection;
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
    @Column(name = "latlng")
    private String latlng;
    @Column(name = "role")
    private Integer role;
    @JoinColumn(name = "branch", referencedColumnName = "branch_id")
    @ManyToOne
    private Branch branch;

    public Merchantprofile() {
    }

    public Merchantprofile(Integer id) {
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

    public String getLatlng() {
        return latlng;
    }

    public void setLatlng(String latlng) {
        this.latlng = latlng;
    }

    public Integer getRole() {
        return role;
    }

    public void setRole(Integer role) {
        this.role = role;
    }

    public Branch getBranch() {
        return branch;
    }

    public void setBranch(Branch branch) {
        this.branch = branch;
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
        if (!(object instanceof Merchantprofile)) {
            return false;
        }
        Merchantprofile other = (Merchantprofile) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.entities.Merchantprofile[ id=" + id + " ]";
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
