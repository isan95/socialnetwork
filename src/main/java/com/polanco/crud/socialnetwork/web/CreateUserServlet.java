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

@WebServlet("/crear-usuario")

public class CreateUserServlet extends HttpServlet{
	
	@Inject
	UserAppServiceWs userAppService;
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.getRequestDispatcher("user/register_user.jsp").forward(request, response);
	}
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String ndoc = request.getParameter("ndoc");
		String name = request.getParameter("name");
		String lastName = request.getParameter("lname");
		String password = request.getParameter("pass");
		
		userAppService.saveUserApp(ndoc, name, lastName, password);
		
		response.sendRedirect("login");
	}
}