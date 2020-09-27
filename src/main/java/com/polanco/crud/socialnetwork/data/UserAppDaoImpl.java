/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.polanco.crud.socialnetwork.data;

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
public class UserAppDaoImpl  implements UserAppDao{
    @PersistenceContext(unitName = "SocialNetworkPU")
    EntityManager em;
    @Override
    public List<UserApp> findAllUserApp() {
        return em.createNamedQuery("UserApp.findAll").getResultList();
    }

    @Override
    public UserApp findByIdUserApp(UserApp user) {
        return (UserApp)em.createNamedQuery("UserApp.findById").setParameter("id", user.getIdUserApp()).getSingleResult();
    }

    @Override
    public List<UserApp> findByName(UserApp user) {
        return em.createNamedQuery("UserApp.findByName").setParameter("name", user.getName()).getResultList();
    }

    @Override
    public List<UserApp> findByLastName(UserApp user) {
        return em.createNamedQuery("UserApp.findByLastName").setParameter("lastName", user.getLastName()).getResultList();
    }

    @Override
    public UserApp findByDoc(UserApp user) {
        UserApp usuario = null;
        try{
            usuario = (UserApp)em.createNamedQuery("UserApp.findByDoc").setParameter("ndoc", user.getNdoc()).getSingleResult();
            return usuario;
        }catch(NoResultException e){
            return usuario;
        }
        
    }

    @Override
    public void insertUserApp(UserApp user) {
        em.persist(user);
    }

    @Override
    public void updateUserApp(UserApp user) {
        em.merge(user);
    }

    @Override
    public void deleteUserApp(UserApp user) {
        em.remove(em.merge(user));
    }
    
}
