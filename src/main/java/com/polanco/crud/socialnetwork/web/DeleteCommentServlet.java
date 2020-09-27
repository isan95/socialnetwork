package com.polanco.crud.socialnetwork.web;

import com.polanco.crud.socialnetwork.domain.CommentApp;
import com.polanco.crud.socialnetwork.domain.UserApp;
import com.polanco.crud.socialnetwork.domain.PostApp;
import com.polanco.crud.socialnetwork.service.CommentAppServiceWs;
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
@WebServlet("/delete-comment")
public class DeleteCommentServlet extends HttpServlet {

    @Inject
    private CommentAppServiceWs commentAppService;
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        
        if(request.getSession().getAttribute("sessionUser") != null){
            CommentApp comment = commentAppService.findByIdCommentApp(Integer.parseInt(request.getParameter("idComment")));
            commentAppService.deleteCommentApp(comment);
    
			PostApp post = comment.getPostApp();
			request.getRequestDispatcher("/post?idPost="+ post.getIdPostApp()).forward(request, response);
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

