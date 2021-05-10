package com.revature.web;

import java.io.IOException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.revature.controller.AccountController;
import com.revature.controller.UserController;

public class FrontController extends HttpServlet{
	
	private String BaseURL = null;
	private UserController uControl = new UserController();
	private AccountController aControl = new AccountController();
	
	@Override 
	public void init(ServletConfig config) throws ServletException {
		BaseURL = config.getInitParameter("BaseURL");
	}
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("application/json");
		
		response.setStatus(404);//Not Found
		
		final String URL = request.getRequestURI().replace(BaseURL, "");
		
		System.out.println(URL);
		
		//path variable = pass info about request in URL
		
		String[] sections = URL.split("/");

		System.out.println(sections);
		
		switch(sections[0]) {
		case "users":
			if (request.getMethod().equals("GET")) {
				if (sections.length == 2) {
					int id = Integer.parseInt(sections[1]);
					uControl.addUser(request, response);
				} else {
					uControl.getAllUsers(response);
				}
			} else if (request.getMethod().equals("POST")) {
				uControl.addUser(request, response);
			} else if (request.getMethod().equals("PUT")&&sections.length==2) {
				uControl.putUser(request, response);
			} else if (request.getMethod().equals("PATCH")&&sections.length==2) {
				uControl.patchUser(request, response);
			}
			break;
			
		case "account":
			if(request.getMethod().equals("GET")) {
				if(sections.length == 2) {
					aControl.getAccount(response);
				} else {
					aControl.getAllAccount(response);
				}
				
			}else if(request.getMethod().equals("POST")) {
				aControl.addAccount(request, response);
			}
			
		}
	}
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
	
	@Override
	protected void doPut(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

	@Override
	protected void doDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
	
	protected void doPatch(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
	
	

}
