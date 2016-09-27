/*
 * To change this template, choose Tools | Templates
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
@Table(name = "adminusers")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Adminusers.findAll", query = "SELECT a FROM Adminusers a"),
    @NamedQuery(name = "Adminusers.findById", query = "SELECT a FROM Adminusers a WHERE a.id = :id"),
    @NamedQuery(name = "Adminusers.findByDatecreated", query = "SELECT a FROM Adminusers a WHERE a.datecreated = :datecreated"),
    @NamedQuery(name = "Adminusers.findByEmail", query = "SELECT a FROM Adminusers a WHERE a.email = :email"),
    @NamedQuery(name = "Adminusers.findByFullname", query = "SELECT a FROM Adminusers a WHERE a.fullname = :fullname"),
    @NamedQuery(name = "Adminusers.findByPassword", query = "SELECT a FROM Adminusers a WHERE a.password = :password"),
    @NamedQuery(name = "Adminusers.findByPwdexpired", query = "SELECT a FROM Adminusers a WHERE a.pwdexpired = :pwdexpired"),
    @NamedQuery(name = "Adminusers.findByRole", query = "SELECT a FROM Adminusers a WHERE a.role = :role"),
    @NamedQuery(name = "Adminusers.findByStatus", query = "SELECT a FROM Adminusers a WHERE a.status = :status"),
    @NamedQuery(name = "Adminusers.findByUsername", query = "SELECT a FROM Adminusers a WHERE a.username = :username")})
public class Adminusers implements Serializable {
    @Column(name = "PHONE")
    private String phone;
    @Column(name = "PWDDATE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date pwddate;
    @Column(name = "TRYCOUNT")
    private Integer trycount;
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID")
    private Integer id;
    @Column(name = "DATECREATED")
    @Temporal(TemporalType.TIMESTAMP)
    private Date datecreated;
    @Column(name = "EMAIL")
    private String email;
    @Column(name = "FULLNAME")
    private String fullname;
    @Column(name = "password")
    private String password;
    @Column(name = "PWDEXPIRED")
    private Boolean pwdexpired;
    @Column(name = "ROLE")
    private Integer role;
    @Column(name = "STATUS")
    private Boolean status;
    @Column(name = "username")
    private String username;
//    @JoinColumn(name = "BRANCH_id", referencedColumnName = "id")
//    @ManyToOne
//    private Branch bRANCHid;

    public Adminusers() {
    }

    public Adminusers(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getDatecreated() {
        return datecreated;
    }

    public void setDatecreated(Date datecreated) {
        this.datecreated = datecreated;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Boolean getPwdexpired() {
        return pwdexpired;
    }

    public void setPwdexpired(Boolean pwdexpired) {
        this.pwdexpired = pwdexpired;
    }

    public Integer getRole() {
        return role;
    }

    public void setRole(Integer role) {
        this.role = role;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

//    public Branch getBRANCHid() {
//        return bRANCHid;
//    }
//
//    public void setBRANCHid(Branch bRANCHid) {
//        this.bRANCHid = bRANCHid;
//    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Adminusers)) {
            return false;
        }
        Adminusers other = (Adminusers) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.vanso.twofa.model.Adminusers[ id=" + id + " ]";
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Date getPwddate() {
        return pwddate;
    }

    public void setPwddate(Date pwddate) {
        this.pwddate = pwddate;
    }

    public Integer getTrycount() {
        return trycount;
    }

    public void setTrycount(Integer trycount) {
        this.trycount = trycount;
    }
    
}
