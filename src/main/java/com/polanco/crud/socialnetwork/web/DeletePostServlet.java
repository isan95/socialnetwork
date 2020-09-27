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
import java.io.PrintWriter;
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
@WebServlet("/delete")
public class DeletePostServlet extends HttpServlet {

    @Inject
    private PostAppServiceWs postAppService;
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        
        if(request.getSession().getAttribute("sessionUser") != null){
            PostApp post = postAppService.findByIdPostApp(Integer.parseInt(request.getParameter("idPost")));
            postAppService.deletePostApp(post);
            UserApp user = (UserApp) request.getSession().getAttribute("sessionUser");
            request.getSession().setAttribute("sessionUser", user);
            request.getRequestDispatcher("/inicio").forward(request, response);
        }
        
        else{
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
