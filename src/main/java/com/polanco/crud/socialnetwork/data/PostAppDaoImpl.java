/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.polanco.crud.socialnetwork.data;

import com.polanco.crud.socialnetwork.domain.PostApp;
import com.polanco.crud.socialnetwork.domain.UserApp;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;


/**
 *
 * @author polanco
 */
@Stateless
public class PostAppDaoImpl implements PostAppDao{
    @PersistenceContext(unitName="SocialNetworkPU")
    private EntityManager em;
    
    @Override
    public List<PostApp> findAllPostApp() {
        return (List<PostApp>) em.createNamedQuery("PostApp.findAll").getResultList();
    }

    @Override
    public PostApp findByIdPostApp(int  id) {
        PostApp postApp = null;
        try{
            postApp = (PostApp)em.createNamedQuery("PostApp.findById").setParameter("id", id).getSingleResult();
        }catch(NoResultException e){
            
        }
        return postApp;
    }

    @Override
    public List<PostApp> findByUserPostApp(UserApp user) {
        
        List<PostApp> posts = null;
        
        try{
            
             posts = (List<PostApp>)em.createNamedQuery("PostApp.findByUser").setParameter("idUser", user.getIdUserApp()).getResultList();
             return posts;
        }catch(NoResultException e){
            
            return posts;
        }
        
        
    }

    @Override
    public void insertPostApp(PostApp post) {
        
        em.persist(post);
    }

    @Override
    public void updatePostApp(PostApp post) {
        em.merge(post);
    }

    @Override
    public void deletePostApp(PostApp post) {
        em.remove(em.merge(post));
    }

    @Override
    public void quantityComments(PostApp post) {
        int quantityComments;
        //quantityComments = Integer.parseInt(em.createQuery("SELECT COUNT(c) FROM CommentApp c WHERE c.postApp.idPostApp = :idPost").setParameter("idPost", post.getIdPostApp()).getSingleResult().toString());
        quantityComments = (Integer) em.createNamedQuery("PostApp.quantityComments").setParameter("idPost", post).getSingleResult();
        post.setQuantityComments(quantityComments);
    }

  
    
}
