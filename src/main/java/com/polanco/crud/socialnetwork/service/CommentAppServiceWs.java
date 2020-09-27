/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.polanco.crud.socialnetwork.service;

import com.polanco.crud.socialnetwork.domain.CommentApp;
import com.polanco.crud.socialnetwork.domain.PostApp;
import java.util.List;
import javax.jws.WebMethod;
import javax.jws.WebService;

/**
 *
 * @author polanco
 */

@WebService()
public interface CommentAppServiceWs {
    
    @WebMethod
    public List<CommentApp> findAllCommentApp();
	
	@WebMethod
	public CommentApp findByIdCommentApp(Integer idComment);
    
    @WebMethod
    public void insertCommentApp(CommentApp comment);
    
    @WebMethod
    public void updateCommentApp(CommentApp comment);
    
    @WebMethod
    public void deleteCommentApp (CommentApp comment);
    
    @WebMethod
    public int quantityCommentApp (PostApp post);
    
    @WebMethod
    public List<CommentApp> findByPostAppCommentApp(PostApp post);
	
	
	

}
