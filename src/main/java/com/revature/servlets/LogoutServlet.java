package com.revature.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.fasterxml.jackson.databind.ObjectMapper;

public class LogoutServlet extends HttpServlet {
	
	private ObjectMapper om = new ObjectMapper();
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession ses = request.getSession(false);
		
		PrintWriter out = response.getWriter();
		if(ses != null) {
			out.print("You are logged out. Thanks for stopping by!");
			response.setStatus(200); //OK
			ses.invalidate();
		} else {
		//response.sendRedirect(""); sends back to the base url of my application
		response.sendRedirect("Oh no! You've been logged out.");
		response.setStatus(401);//unauthorized maybe 400 better?
		}
	}
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
