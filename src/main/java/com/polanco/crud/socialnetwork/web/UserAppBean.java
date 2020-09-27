/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.polanco.crud.socialnetwork.web;

import com.polanco.crud.socialnetwork.domain.UserApp;
import com.polanco.crud.socialnetwork.service.UserAppServiceWs;
import java.io.IOException;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;
//import javax.xml.ws.Response;
import javax.xml.ws.WebServiceContext;
import javax.servlet.http.HttpServletResponse;


/**
 *
 * @author polanco
 */
@Named("userAppBean")
@RequestScoped
public class UserAppBean {
    @Inject
    private UserAppServiceWs userAppServiceWs;
    
    

    
    private String doc;
    private String pass;
    private String name;
    private String lastName;
    
    private List<UserApp> usersList;
    

    public UserAppBean() {
       
    }
    
    @PostConstruct
    public void initialize(){
        usersList = userAppServiceWs.listUserApp();
    }
    
    public List<UserApp> getUsersApp(){
        return usersList;
    }

    public String getDoc() {
        return doc;
    }

    public void setDoc(String doc) {
        this.doc = doc;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    
    
    
    
    public void login(){
        boolean result = this.userAppServiceWs.login(doc, pass);
        HttpServletResponse response = null;
        
        if(result){
            System.out.println("Todo correcto");
            try{
                response.sendRedirect("home");
            }catch(IOException e){
                System.out.println("No se encuentra la direccion");
            }
            
        }
        else{ 
            System.out.println("Contraseña o usuario incorrecto");
            try{
                response.sendRedirect("#");
            }catch(IOException ex){
                System.out.println("No se encentra la direccion");
            }
            
        }        
    }
    
    public void saveUserApp(){
        userAppServiceWs.saveUserApp(doc, name, lastName, pass);
    }
}
