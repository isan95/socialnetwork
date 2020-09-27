package com.polanco.crud.socialnetwork.web;

import com.polanco.crud.socialnetwork.domain.UserApp;
import com.polanco.crud.socialnetwork.service.UserAppServiceWs;
import java.io.IOException;
import java.io.PrintWriter;
import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/eliminar-usuario")
public class DeleteUserAppServlet extends HttpServlet{
	
	@Inject
	UserAppServiceWs userAppService;
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		
		UserApp user = (UserApp)request.getSession().getAttribute("sessionUser");
		
		if(user != null){
			
			userAppService.deleteUserApp(user);
			request.getSession().setAttribute("sessionUser",null);
			request.getRequestDispatcher("/login").forward(request, response);
		}
	}
}