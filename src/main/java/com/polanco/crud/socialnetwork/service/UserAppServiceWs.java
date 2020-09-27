/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.polanco.crud.socialnetwork.service;

import com.polanco.crud.socialnetwork.domain.UserApp;
import java.util.List;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;

/**
 *
 * @author polanco
 */
@WebService()
public interface UserAppServiceWs {
    
    @WebMethod()
    public List<UserApp> listUserApp();
	
	@WebMethod()
    public UserApp findByDocUserApp(@WebParam(name="documento")String doc);
        
    @WebMethod(operationName="iniciarSesion")
    public boolean login(@WebParam(name="documento") String doc, @WebParam(name="contrasena") String pass);
    
    @WebMethod()
    public void saveUserApp(@WebParam(name="documento") String doc, @WebParam(name = "nombre") String name, @WebParam(name = "apellido") String lastName, @WebParam(name="contraseña") String pass);
    
    @WebMethod()
	public void updateUserApp(@WebParam(name="usuario") UserApp user);
	
	@WebMethod()
	public void deleteUserApp(@WebParam(name="usuario") UserApp user);
    
}
