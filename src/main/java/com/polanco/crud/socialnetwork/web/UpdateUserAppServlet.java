package com.polanco.crud.socialnetwork.web;

import com.polanco.crud.socialnetwork.domain.UserApp;
import com.polanco.crud.socialnetwork.service.UserAppServiceWs;
import java.io.PrintWriter;
import java.io.IOException;
import javax.inject.Inject;
import javax.servlet.annotation.WebServlet;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/actualizar-usuario")
public class UpdateUserAppServlet extends HttpServlet{
	
	@Inject
	private UserAppServiceWs userAppService;
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException{
		
		UserApp user = (UserApp)request.getSession().getAttribute("sessionUser");
		if(user != null){
			
			request.getRequestDispatcher("user/update_profile.jsp").forward(request, response);
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
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException{
		
		UserApp user = (UserApp)request.getSession().getAttribute("sessionUser");
		if(user != null){		
			String ndoc = request.getParameter("ndoc");
			String name = request.getParameter("name");
			String lastName = request.getParameter("lastName");
			
			user.setNdoc(ndoc);
			user.setName(name);
			user.setLastName(lastName);
			
			userAppService.updateUserApp(user);
			
			//request.getRequestDispatcher("/perfil").forward(request, response);
			response.sendRedirect("perfil");
		}
		
	}
}