/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.polanco.crud.socialnetwork.web;

import com.polanco.crud.socialnetwork.domain.CommentApp;
import com.polanco.crud.socialnetwork.domain.PostApp;
import com.polanco.crud.socialnetwork.domain.UserApp;
import com.polanco.crud.socialnetwork.service.PostAppServiceWs;
import com.polanco.crud.socialnetwork.service.CommentAppServiceWs;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author polanco
 */
@WebServlet("/post")
public class PostServlet extends HttpServlet {

    @Inject
    PostAppServiceWs postAppServiceWs;
	@Inject
	CommentAppServiceWs commentAppService;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        UserApp sessionUser = (UserApp) session.getAttribute("sessionUser");
        sendPost(sessionUser, request, response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        UserApp sessionUser = (UserApp) session.getAttribute("sessionUser");
        sendPost(sessionUser, request, response);
    }

    public void sendPost(UserApp sessionUser, HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException, NumberFormatException {
        if (sessionUser != null) {
            Integer idPost = Integer.parseInt(request.getParameter("idPost"));
			
            PostApp postApp = postAppServiceWs.findByIdPostApp(idPost);
           	List<CommentApp> comments = (List<CommentApp>) commentAppService.findByPostAppCommentApp(postApp);
			
            request.setAttribute("post", postApp);
            request.setAttribute("comments", comments);
            request.getRequestDispatcher("post/post.jsp").forward(request, response);

        } else {
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
