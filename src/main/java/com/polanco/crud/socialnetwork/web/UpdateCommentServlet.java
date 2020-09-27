package com.polanco.crud.socialnetwork.web;

import com.polanco.crud.socialnetwork.domain.PostApp;
import com.polanco.crud.socialnetwork.domain.UserApp;
import com.polanco.crud.socialnetwork.domain.CommentApp;
import com.polanco.crud.socialnetwork.service.PostAppServiceWs;
import com.polanco.crud.socialnetwork.service.CommentAppServiceWs;
import java.io.IOException;
import java.io.PrintWriter;
import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/actualizar-comentario")
public class UpdateCommentServlet extends HttpServlet  {
	@Inject
	private CommentAppServiceWs commentAppService;
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		
		UserApp user = (UserApp)request.getSession().getAttribute("sessionUser");
			
		if(user != null){
			Integer idComment = Integer.parseInt(request.getParameter("idComment"));
			CommentApp comment = commentAppService.findByIdCommentApp(idComment);
			request.setAttribute("comment", comment);

			request.getRequestDispatcher("comment/editionComment.jsp").forward(request, response);
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
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		
		UserApp user = (UserApp)request.getSession().getAttribute("sessionUser");
			
		if(user != null){
			
			Integer idComment = Integer.parseInt(request.getParameter("idComment"));
			String commentContent = request.getParameter("content");
			CommentApp comment = commentAppService.findByIdCommentApp(idComment);
			comment.setContent(commentContent);
			commentAppService.updateCommentApp(comment);

			request.getRequestDispatcher("/post?idPost="+comment.getPostApp().getIdPostApp()).forward(request, response);
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