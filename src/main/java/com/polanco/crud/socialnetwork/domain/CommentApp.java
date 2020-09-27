/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.polanco.crud.socialnetwork.domain;

import java.io.Serializable;
import java.time.Instant;
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
import javax.persistence.FetchType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author polanco
 */
@Entity
@Table(name = "comment_app")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "CommentApp.findAll", query = "SELECT c FROM CommentApp c"),
    @NamedQuery(name = "CommentApp.findByIdCommentApp", query = "SELECT c FROM CommentApp c WHERE c.idCommentApp = :idCommentApp"),
    @NamedQuery(name = "CommentApp.findByContent", query = "SELECT c FROM CommentApp c WHERE c.content = :content"),
    @NamedQuery(name = "CommentApp.findByCommentAppDate", query = "SELECT c FROM CommentApp c WHERE c.commentAppDate >= :commentAppDateStart AND c.commentAppDate <= :commentAppDateEnd"),
    @NamedQuery(name = "CommentApp.findByPostApp", query = "SELECT c FROM CommentApp c WHERE c.postApp = :post")})
@XmlAccessorType(XmlAccessType.FIELD)
public class CommentApp implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_comment_app")
    private Integer idCommentApp;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2147483647)
    @Column(name = "content")
    private String content;
    @Column(name = "comment_app_date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date commentAppDate;
    
    @JoinColumn(name="id_post_app_comment_app", referencedColumnName = "id_post_app")
    @ManyToOne(fetch = FetchType.EAGER)
    private PostApp postApp;
    
    @JoinColumn(name="id_user_app_comment_app", referencedColumnName="id_user_app")
    @ManyToOne()
    private UserApp userApp;

    public CommentApp() {
    }

    public CommentApp(Integer idCommentApp) {
        this.idCommentApp = idCommentApp;
    }

    public CommentApp(Integer idCommentApp, String content) {
        this.idCommentApp = idCommentApp;
        this.content = content;
    }

    public CommentApp(String content, PostApp postApp, UserApp userApp) {
        this.content = content;
        this.postApp = postApp;
        this.userApp = userApp;
		this.commentAppDate = Date.from(Instant.now());
    }
    
    

    public Integer getIdCommentApp() {
        return idCommentApp;
    }

    public void setIdCommentApp(Integer idCommentApp) {
        this.idCommentApp = idCommentApp;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Date getCommentAppDate() {
        return commentAppDate;
    }

    public void setCommentAppDate(Date commentAppDate) {
        this.commentAppDate = commentAppDate;
    }

    public PostApp getPostApp() {
        return postApp;
    }

    public void setPostApp(PostApp postApp) {
        this.postApp = postApp;
    }

    public UserApp getUserApp() {
        return userApp;
    }

    public void setUserApp(UserApp userApp) {
        this.userApp = userApp;
    }
    
    

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idCommentApp != null ? idCommentApp.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CommentApp)) {
            return false;
        }
        CommentApp other = (CommentApp) object;
        if ((this.idCommentApp == null && other.idCommentApp != null) || (this.idCommentApp != null && !this.idCommentApp.equals(other.idCommentApp))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "CommentApp{" + "idCommentApp=" + idCommentApp + ", content=" + content + ", commentAppDate=" + commentAppDate + ", postApp=" + postApp + ", userApp=" + userApp + '}';
    }

   

}
