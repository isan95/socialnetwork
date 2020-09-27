/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.polanco.crud.socialnetwork.domain;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;
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
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author polanco
 */
@Entity
@Table(name="user_app")
@NamedQueries({
@NamedQuery(name="UserApp.findAll", query="SELECT u FROM UserApp u"),
@NamedQuery(name="UserApp.findById", query="SELECT u FROM UserApp u WHERE u.idUserApp = :id"),
@NamedQuery(name="UserApp.findByName", query = "SELECT u FROM UserApp u WHERE u.name = :name"),
@NamedQuery(name="UserApp.findByLastName", query = "SELECT u FROM UserApp u WHERE u.lastName = :lastName"),
@NamedQuery(name="UserApp.findByDoc", query = "SELECT u FROM UserApp u WHERE u.ndoc = :ndoc")
})
@XmlAccessorType(XmlAccessType.FIELD)
public class UserApp implements Serializable{

    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "name")
    private String name;
    
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 60)
    @Column(name = "last_name")
    private String lastName;
    
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "ndoc")
    private String ndoc;
    
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 200)
    @Column(name = "password")
    private String password;
    
    
    private static final long serialVersionUID = 1L;
    
    @Id
    @Column(name="id_user_app")
    @Basic(optional=false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idUserApp;
    
    
    /*@XmlTransient
    @OneToMany(mappedBy="user_app")    
    private List<PostApp> postAppList;*/

    public UserApp(String name, String lastName, String ndoc, String password) {
        this.name = name;
        this.lastName = lastName;
        this.ndoc = ndoc;
        this.password = password;
    }

    public UserApp(String ndoc) {
        this.ndoc = ndoc;
    }
    
    

    public UserApp() {
    }

    public UserApp(Integer idUserApp) {
        this.idUserApp = idUserApp;
    }
    
    

    public Integer getIdUserApp() {
        return idUserApp;
    }

    public void setIdUserApp(Integer idUserApp) {
        this.idUserApp = idUserApp;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getNdoc() {
        return ndoc;
    }

    public void setNdoc(String ndoc) {
        this.ndoc = ndoc;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    /*public List<PostApp> getPostAppList() {
        return postAppList;
    }

    public void setPostAppList(List<PostApp> postAppList) {
        this.postAppList = postAppList;
    }
    */
    

    @Override
    public String toString() {
        return "UserApp{" + "idUserApp=" + idUserApp + ", name=" + name + ", lastName=" + lastName + ", ndoc=" + ndoc + ", password=" + password + '}';
    }

    
}
