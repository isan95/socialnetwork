/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.polanco.crud.socialnetwork.data;

import com.polanco.crud.socialnetwork.domain.PostApp;
import com.polanco.crud.socialnetwork.domain.UserApp;
import java.util.List;

/**
 *
 * @author polanco
 */
public interface PostAppDao {
    
    public List<PostApp> findAllPostApp();
    
    public PostApp findByIdPostApp(int id);
    
    public List<PostApp> findByUserPostApp (UserApp user);
    
    public void quantityComments(PostApp post);
    
    public void insertPostApp(PostApp post);
    
    public void updatePostApp(PostApp post);
    
    public void deletePostApp(PostApp post);
}
