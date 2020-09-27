/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.polanco.crud.socialnetwork.domain;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author polanco
 */
@Entity
@Table(name="post_app")
@NamedQueries({
@NamedQuery(name = "PostApp.findAll", query = "SELECT p FROM PostApp p ORDER BY p.postAppDate DESC"),
@NamedQuery(name = "PostApp.findById", query = "SELECT p FROM PostApp p WHERE p.idPostApp = :id"),
@NamedQuery(name = "PostApp.findByUser", query = "SELECT p FROM PostApp p WHERE p.userApp.idUserApp = :idUser"),
@NamedQuery(name = "PostApp.quantityComments", query = "SELECT COUNT (c) FROM CommentApp c WHERE c.postApp.idPostApp = :idPost")
})
@XmlAccessorType(XmlAccessType.FIELD)
public class PostApp implements Serializable{
    
    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id_post_app")
    @Basic(optional=false)
    private Integer idPostApp;
    
    @Basic(optional=false)
    private String content;
    
    @Column(name="post_app_date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date postAppDate;

    @JoinColumn(name="id_user_app_post_app", referencedColumnName = "id_user_app")
    @ManyToOne()
    private UserApp userApp;
    
    @Transient
    private int quantityComments;
    
    @XmlTransient
    @OneToMany(mappedBy="postApp")
    private List<CommentApp> commentAppList;
        
    
    public PostApp() {
    }

    public PostApp(String content, UserApp userApp) {
        this.content = content;
        this.userApp = userApp;
        this.postAppDate = Date.from(Instant.now());
    }

    public PostApp(Integer idPostApp) {
        this.idPostApp = idPostApp;
    }
    
    

    public Integer getIdPostApp() {
        return idPostApp;
    }

    public void setIdPostApp(Integer idPostApp) {
        this.idPostApp = idPostApp;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getPostAppDate() {        
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy hh:mm:ss"); 
        
        return sdf.format(postAppDate.getTime());
    }

    public void setPostAppDate(Date postAppDate) {
        this.postAppDate = postAppDate;
    }

    public UserApp getUserApp() {
        return userApp;
    }

    public void setUserApp(UserApp userApp) {
        this.userApp = userApp;
    }

    public int getQuantityComments() {
        return quantityComments;
    }

    public void setQuantityComments(int quantityComments) {
        this.quantityComments = quantityComments;
    }
    
    
    
    
    @XmlTransient
    public List<CommentApp> getCommentAppList() {
        return commentAppList;
    }

    public void setCommentAppList(List<CommentApp> commentAppList) {
        this.commentAppList = commentAppList;
    }

    @Override
    public String toString() {
        return "PostApp{" + "idPostApp=" + idPostApp + ", content=" + content + ", postAppDate=" + postAppDate + ", userApp=" + userApp + '}';
    }
    
    
    
}
