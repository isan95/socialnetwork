/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.polanco.crud.socialnetwork.data;

import com.polanco.crud.socialnetwork.domain.UserApp;
import java.util.List;

/**
 *
 * @author polanco
 */
public interface UserAppDao {
    
    public List<UserApp> findAllUserApp();
    
    public UserApp findByIdUserApp(UserApp user);
    
    public List<UserApp> findByName(UserApp user);
    
    public List<UserApp> findByLastName(UserApp user);
    
    public UserApp findByDoc(UserApp user);
    
    public void insertUserApp(UserApp user);
    
    public void updateUserApp (UserApp user);
    
    public void deleteUserApp (UserApp user); 
}
