/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.polanco.crud.socialnetwork.service;

import com.polanco.crud.socialnetwork.data.PostAppDao;
import com.polanco.crud.socialnetwork.domain.PostApp;
import com.polanco.crud.socialnetwork.domain.UserApp;
import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.jws.WebService;

/**
 *
 * @author polanco
 */
@Stateless
@WebService(endpointInterface="com.ṕolanco.crud.socialnetwork.service.PostAppServiceWs")
public class PostAppServiceWsImpl implements PostAppServiceWs{

    @Inject
    private PostAppDao postAppDao;
    
    @Override
    public List<PostApp> listPostApp() {
        return postAppDao.findAllPostApp();
    }

    @Override
    public PostApp findByIdPostApp(int id) {
        return postAppDao.findByIdPostApp(id);
    }

    @Override
    public List<PostApp> findByUserPostApp(UserApp user) {
        return postAppDao.findByUserPostApp(user);
    }

    @Override
    public void insertPostApp(PostApp post) {
        postAppDao.insertPostApp(post);
    }

    @Override
    public void quantityComments(PostApp post) {
        postAppDao.quantityComments(post);
    }

    @Override
    public void updatePostApp(PostApp post){
        postAppDao.updatePostApp(post);
    }

    @Override
    public void deletePostApp(PostApp post) {
        postAppDao.deletePostApp(post);
    }
}
