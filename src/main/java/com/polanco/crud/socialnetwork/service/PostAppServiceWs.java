/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.polanco.crud.socialnetwork.service;

import com.polanco.crud.socialnetwork.domain.PostApp;
import com.polanco.crud.socialnetwork.domain.UserApp;
import java.util.List;
import javax.jws.WebMethod;
import javax.jws.WebService;

/**
 *
 * @author polanco
 */
@WebService()
public interface PostAppServiceWs {
    
    @WebMethod()
    public List<PostApp> listPostApp();
    
    @WebMethod()
    public PostApp findByIdPostApp(int id);
    
    @WebMethod()
    public List<PostApp> findByUserPostApp(UserApp user);
    
    @WebMethod()
    public void insertPostApp(PostApp post);
    
    @WebMethod()
    public void quantityComments(PostApp post);
    
    @WebMethod()
    public void updatePostApp(PostApp post);
    
    @WebMethod()
    public void deletePostApp(PostApp post);
    
}
