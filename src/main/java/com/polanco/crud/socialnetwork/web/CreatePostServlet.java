/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.polanco.crud.socialnetwork.web;

import com.polanco.crud.socialnetwork.domain.PostApp;
import com.polanco.crud.socialnetwork.domain.UserApp;
import com.polanco.crud.socialnetwork.service.PostAppServiceWs;
import java.io.IOException;
import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author polanco
 */
@WebServlet("/crear-post")
public class CreatePostServlet extends HttpServlet{
    @Inject
    PostAppServiceWs postAppService;
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        
        UserApp user = (UserApp) request.getSession().getAttribute("sessionUser");
        String contentPost = (String) request.getParameter("contentPost");
        
        if(user != null){
            
            postAppService.insertPostApp(new PostApp(contentPost, user));
            request.getRequestDispatcher("/inicio").forward(request, response);
        }
        
    }
    
}
