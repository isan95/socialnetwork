package com.polanco.crud.socialnetwork.web;

import com.polanco.crud.socialnetwork.domain.UserApp;
import com.polanco.crud.socialnetwork.service.UserAppServiceWs;
import java.io.IOException;
import java.io.PrintWriter;
import javax.inject.Inject;
import javax.servlet.annotation.WebServlet;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/cambiar-contrasenia")
public class ChangePasswordServlet extends HttpServlet {	
		
	@Inject
	private UserAppServiceWs userAppService;
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		
		if (request.getSession().getAttribute("sessionUser") != null){
				
            	request.setAttribute("equalsOldPass", true);
				request.getRequestDispatcher("user/change_pass.jsp").forward(request, response);
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
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		
		String oldPass = request.getParameter("old_pass");
		String newPass = request.getParameter("new_pass");
		
		UserApp user = (UserApp) request.getSession().getAttribute("sessionUser");
		
		if(user.getPassword().equals(oldPass)){
						
			user.setPassword(newPass);
			
			userAppService.updateUserApp(user);
			
			response.sendRedirect("/perfil");
			
		}
		else{
			
			request.setAttribute("equalsOldPass", false);
			request.getRequestDispatcher("user/change_pass.jsp").forward(request, response);
		}
	}
}