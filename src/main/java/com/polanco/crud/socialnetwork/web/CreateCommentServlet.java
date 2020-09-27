/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.polanco.crud.socialnetwork.web;

import com.polanco.crud.socialnetwork.domain.CommentApp;
import com.polanco.crud.socialnetwork.domain.PostApp;
import com.polanco.crud.socialnetwork.domain.UserApp;
import com.polanco.crud.socialnetwork.service.CommentAppServiceWs;
import com.polanco.crud.socialnetwork.service.PostAppServiceWs;
import java.io.IOException;
import java.util.List;
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
@WebServlet("/comentar")
public class CreateCommentServlet extends HttpServlet{
    
    @Inject
    private CommentAppServiceWs commentAppService; 
    
    @Inject 
    private PostAppServiceWs postAppService;
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException{
        String contentComment = request.getParameter("contentComment");
        
		UserApp user = (UserApp) request.getSession().getAttribute("sessionUser");
        PostApp post = (PostApp) postAppService.findByIdPostApp(Integer.parseInt(request.getParameter("idPost")));
		
		commentAppService.insertCommentApp(new CommentApp(contentComment,post,user));
		
        request.getRequestDispatcher("/post?idPost="+ post.getIdPostApp()).forward(request, response);
    }
}
