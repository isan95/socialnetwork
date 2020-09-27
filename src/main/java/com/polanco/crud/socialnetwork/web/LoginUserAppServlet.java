/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.polanco.crud.socialnetwork.web;

import com.polanco.crud.socialnetwork.domain.PostApp;
import com.polanco.crud.socialnetwork.domain.UserApp;
import com.polanco.crud.socialnetwork.service.PostAppServiceWs;
import com.polanco.crud.socialnetwork.service.UserAppServiceWs;
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
@WebServlet("/login")
public class LoginUserAppServlet extends HttpServlet{
    
    @Inject
    private UserAppServiceWs userAppService;
    
    @Inject
    private PostAppServiceWs postAppService;
    
    private static boolean resultLogin = true;

    public static boolean isResultLogin() {
        return resultLogin;
    }

    public void setResultLogin(boolean resultLogin) {
        LoginUserAppServlet.resultLogin = resultLogin;
    }
    
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        
        String ndoc = (String) request.getParameter("ndoc");
        String pass = (String) request.getParameter("pass");
        resultLogin = userAppService.login(ndoc, pass);
        if(resultLogin){
            UserApp user = userAppService.findByDocUserApp(ndoc);
            request.getSession().setAttribute("sessionUser", user);
            request.getRequestDispatcher("/inicio").forward(request, response);
        }
        else {
            resultLogin = false;
            request.getRequestDispatcher("user/login.jsp").forward(request, response);
        }
        
    }
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		if(request.getSession().getAttribute("sessionUser") == null){
			
			request.getRequestDispatcher("user/login.jsp").forward(request, response);		
		}
		
		else{
			
			request.getRequestDispatcher("/inicio").forward(request, response);		
		}
		
		
	}
    
    
}
