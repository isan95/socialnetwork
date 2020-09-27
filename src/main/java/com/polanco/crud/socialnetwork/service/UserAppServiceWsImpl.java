/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.polanco.crud.socialnetwork.service;

import com.polanco.crud.socialnetwork.data.UserAppDao;
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
@WebService(endpointInterface="com.polanco.crud.socialnetwork.service.UserAppServiceWs")
public class UserAppServiceWsImpl implements UserAppServiceWs{
    
    @Inject
    private UserAppDao userAppDao;
    
    @Override
    public List<UserApp> listUserApp() {
        return userAppDao.findAllUserApp();
    }
	
	@Override
    public UserApp findByDocUserApp(String doc) {
        UserApp userApp = userAppDao.findByDoc(new UserApp(doc));
        return userApp;
    }

    @Override
    public boolean login(String doc, String pass) {
        UserApp user = userAppDao.findByDoc(new UserApp(doc));
        if(user != null){
           if(user.getPassword().equals(pass)){
               return true;
           }
           else{
               return false;
           }
        }
        else{
            return false;
        }
    }

    @Override
    public void saveUserApp(String doc, String name, String lastName, String pass) {
        
        userAppDao.insertUserApp(new UserApp(name, lastName,doc,pass));
    }

    @Override
	public void updateUserApp(UserApp user){
		
		userAppDao.updateUserApp(user);
	}
	
	@Override
	public void deleteUserApp(UserApp user){
		
		userAppDao.deleteUserApp(user);
	}
    
}
