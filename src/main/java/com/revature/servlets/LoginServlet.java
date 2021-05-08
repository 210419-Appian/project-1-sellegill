package com.revature.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.revature.models.UserDTO;

public class LoginServlet extends HttpServlet{
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		UserDTO u = new UserDTO();
		
		u.username = request.getParameter("userId"); //connected to html
		u.password = request.getParameter("password");
		
		//UserDTO shoudl pass thru service layer to make sure credentials are accurate
		
		RequestDispatcher rd = null;
		PrintWriter out = response.getWriter();
		
		if(u.username.equals("tommytwotoes") && u.password.equals("triplet")) {
			//create a session/cookie so we remember this user in the future
			
			HttpSession ses = request.getSession();//cookie is create here and placed in response
			ses.setAttribute("username", u.username);//Save username in session for use later
			
			rd = request.getRequestDispatcher("success");
			rd.forward(request, response);
			
		} else {
			rd = request.getRequestDispatcher("index.html");
			rd.include(request, response);
			
			out.print("<span style='color:red; text-align:center'>Invalid Username/Password</span>");
			
			//resp.setStatus(200); //Tomcat will do this by default if it finds a servlet method to handle the request. 
		}
	}

}
