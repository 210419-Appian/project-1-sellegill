package com.revature.servlets;



import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class HelloServlet extends HttpServlet{
	
	@Override 
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		String URI = request.getRequestURI();
		System.out.println(URI); //Just want to see if Servlet works
		
		//Print writer allow us to put text into the body of the response
		PrintWriter pw = response.getWriter();
		pw.print("<h1>Hello from your doGet Method</h1> ");//can write any html json xml
		
	}

}

/*
 * Don't have to return anything(void) the Server takes the response object and takes it back
 *Server calls the Servlet Method doGet
 *object is being built up and then at the end of the execution stack 
 *for the server it gets sent back as a response
 * So no return is needed
 */