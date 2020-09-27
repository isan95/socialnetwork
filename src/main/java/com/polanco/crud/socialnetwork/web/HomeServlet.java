/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.polanco.crud.socialnetwork.web;

import com.polanco.crud.socialnetwork.domain.PostApp;
import com.polanco.crud.socialnetwork.domain.UserApp;
import com.polanco.crud.socialnetwork.service.CommentAppServiceWs;
import com.polanco.crud.socialnetwork.service.PostAppServiceWs;
import com.polanco.crud.socialnetwork.service.UserAppServiceWs;
import java.io.IOException;
import java.io.PrintWriter;
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
@WebServlet("/inicio")
public class HomeServlet extends HttpServlet{
    
    @Inject
    private PostAppServiceWs postAppService;
    
    @Inject
    private UserAppServiceWs userAppService;
    
    @Inject
    private CommentAppServiceWs commentAppService;
    
    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException{
        
        dispacherHome(request, response);
    }
    
     @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        
        dispacherHome(request, response);
    
    }
    
    
    public void dispacherHome(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        
        UserApp userApp = (UserApp) request.getSession().getAttribute("sessionUser");
        
        if (userApp != null){
            
            List<PostApp> posts = postAppService.listPostApp();
            
            posts.forEach((i) -> {
                i.setQuantityComments(commentAppService.quantityCommentApp(i));
            });
            
            request.setAttribute("posts", posts);
			request.setAttribute("title","Inicio");
            request.getRequestDispatcher("post/list_posts.jsp").forward(request, response);
        }
        else {
            response.setContentType("text/html;Charset=UTF-8");
            PrintWriter out = response.getWriter();
            out.println("<html><head><title>Inicia sesion</title></head>");
            out.println("<body>");
            out.println("<center><h2>Debes iniciar sesion antes</h2></center>");
            out.println("<center><a href='http://localhost:8080/socialnetwork'>click aqui para iniciar sesion</a></center>");
            out.println("</body></html>");
            out.close();
        }
       
    }
    
}  

