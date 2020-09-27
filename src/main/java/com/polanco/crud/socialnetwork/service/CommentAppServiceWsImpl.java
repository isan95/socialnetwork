/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.polanco.crud.socialnetwork.service;

import com.polanco.crud.socialnetwork.data.CommentAppDao;
import com.polanco.crud.socialnetwork.domain.CommentApp;
import com.polanco.crud.socialnetwork.domain.PostApp;
import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.jws.WebService;

/**
 *
 * @author polanco
 */
@Stateless
@WebService(endpointInterface = "com.polanco.crud.socialnetwork.service.CommentAppServiceWs")
public class CommentAppServiceWsImpl implements CommentAppServiceWs{

    @Inject
    private CommentAppDao commentAppDao; 
    
    @Override
    public List<CommentApp> findAllCommentApp() {
        return commentAppDao.findAllCommentApp();
    }
	
	@Override
	public CommentApp findByIdCommentApp(Integer idComment){
		return commentAppDao.findByIdCommentApp(idComment);
	}

    @Override
    public void insertCommentApp(CommentApp comment) {
        commentAppDao.insertCommentApp(comment);
    }

    @Override
    public void updateCommentApp(CommentApp comment) {
        commentAppDao.updateCommentApp(comment);
    }

    @Override
    public void deleteCommentApp(CommentApp comment) {
        commentAppDao.deleteCommentApp(comment);
    }

    @Override
    public int quantityCommentApp(PostApp post) {
        return commentAppDao.quantityComment(post);
    }

    @Override
    public List<CommentApp> findByPostAppCommentApp(PostApp post) {
        return commentAppDao.findByPostAppCommentApp(post);
    }
    
}
