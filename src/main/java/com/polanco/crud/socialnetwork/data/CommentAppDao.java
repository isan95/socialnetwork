/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.polanco.crud.socialnetwork.data;

import com.polanco.crud.socialnetwork.domain.CommentApp;
import com.polanco.crud.socialnetwork.domain.PostApp;
import java.util.List;

/**
 *
 * @author polanco
 */
public interface CommentAppDao {
    
    public List<CommentApp> findAllCommentApp();
    
    public CommentApp findByIdCommentApp(Integer idCommentApp);
    
    public List<CommentApp> findByContent(String content);
    
    public List<CommentApp> findByCommentAppDate(String date);
    
    public List<CommentApp> findByPostAppCommentApp (PostApp post);
    
    public int quantityComment (PostApp post);
    
    public void insertCommentApp(CommentApp comment);
    
    public void updateCommentApp (CommentApp comment);
    
    public void deleteCommentApp (CommentApp comment);
}
