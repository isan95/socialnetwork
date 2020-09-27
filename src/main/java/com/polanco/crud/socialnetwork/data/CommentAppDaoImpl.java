/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.polanco.crud.socialnetwork.data;

import com.polanco.crud.socialnetwork.domain.CommentApp;
import com.polanco.crud.socialnetwork.domain.PostApp;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author polanco
 */

@Stateless
public class CommentAppDaoImpl implements CommentAppDao{
    
    @PersistenceContext(unitName="SocialNetworkPU")
    private EntityManager em;
            
    @Override
    public List<CommentApp> findAllCommentApp() {
        return (List<CommentApp>) em.createNamedQuery("CommentApp.findAll").getResultList();
    }

    @Override
    public CommentApp findByIdCommentApp(Integer idCommentApp) {
        CommentApp comment = null;
        try{
            comment = (CommentApp) em.createNamedQuery("CommentApp.findByIdCommentApp").setParameter("idCommentApp", idCommentApp).getSingleResult();
        }catch(NoResultException e){
            
        }
        return comment;
    }

    @Override
    public List<CommentApp> findByContent(String content) {
        return (List<CommentApp>) em.createNamedQuery("CommentApp.findByContent").setParameter("content", content).getResultList();
    }

    @Override
    public List<CommentApp>  findByCommentAppDate(String date) {
        String commentAppDateStart = date+"00:00:00";
        String commentAppDateEnd = date+"23:59:59";
        
        Query query = em.createNamedQuery("CommentApp.findByCommentAppDate");
        query.setParameter("commentAppDateStart", commentAppDateStart);
        query.setParameter("commentAppDateEnd", commentAppDateEnd);
        
        return (List<CommentApp>)query.getResultList();
        
    }

    @Override
    public int quantityComment(PostApp post) {
        
        Query query = em.createQuery("SELECT COUNT (c) FROM CommentApp c WHERE c.postApp = :post");
        
        return Integer.parseInt(query.setParameter("post", post).getSingleResult().toString()) ;
    }

    @Override
    public void insertCommentApp(CommentApp comment) {
        em.persist(comment);
    }

    @Override
    public void updateCommentApp(CommentApp comment) {
        em.merge(comment);
    }

    @Override
    public void deleteCommentApp(CommentApp comment) {
        em.remove(em.merge(comment));
    }

    @Override
    public List<CommentApp> findByPostAppCommentApp(PostApp post) {
        return (List<CommentApp>) em.createNamedQuery("CommentApp.findByPostApp").setParameter("post", post).getResultList();
    }
    
}
