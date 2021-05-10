package com.revature.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.models.User;
import com.revature.models.UserDTO;
import com.revature.service.LoginServices;
import com.revature.service.UserService;

public class LoginServlet extends HttpServlet{
	
	private UserService uServ = new UserService(); 
	private LoginServices lServ = new LoginServices();
	
	private ObjectMapper om = new ObjectMapper();
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		UserDTO u = new UserDTO();
		
		u.username = request.getParameter("userId"); //connected to html
		u.password = request.getParameter("password");
		
		//UserDTO should pass thru service layer to make sure credentials are accurate
		
		//create a session/cookie so we remember this user in the future
	
		PrintWriter pw = response.getWriter();
		
		//call service layer for correct protocol
	      if(lServ.login(u.username, u.password)) {
		
			HttpSession ses = request.getSession();//cookie is create here and placed in response
			ses.setAttribute("username", u.username);//Save username in session for use later
			
			
			//User u2 = uServ.findUserByUsername(u.username);
			
			//Friendly Welcome
			pw.print("Welcome, You have successfully logged in" );
			response.setStatus(200);//OK
		}else {
		
			pw.print("Login Failed");
			response.setStatus(400);//Bad Request
		}
				
		
		//	response.setStatus(400); //Bad Request
			
			//resp.setStatus(200); //Tomcat will do this by default if it finds a servlet method to handle the request. 
		}
	
	//no longer getting 405 but blank screen
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	  HttpSession ses = request.getSession(false);
	  PrintWriter pw = response.getWriter();
	  //project requirement
	  if(ses != null) {
		  pw.print(ses.getAttribute("username").toString() + "You're all set");
	  } else {
		  pw.print("Login Failed");
	  }
	}
		

}
