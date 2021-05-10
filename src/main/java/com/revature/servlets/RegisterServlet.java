package com.revature.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class RegisterServlet extends HttpServlet{
	
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		String URI = request.getRequestURI();
		System.out.println(URI); //Just want to see if Servlet works
		
		//Print writer allow us to put text into the body of the response
		PrintWriter pw = response.getWriter();
		pw.print("<h1>This is your Register page</h1> ");//can write any html json xml
		}	
	
	}		

