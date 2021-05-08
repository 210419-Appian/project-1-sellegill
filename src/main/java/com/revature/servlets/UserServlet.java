package com.revature.servlets;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.models.User;
import com.revature.service.UserService;

public class UserServlet extends HttpServlet{
	
	private UserService uServ = new UserService();
	
	private ObjectMapper om = new ObjectMapper();
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//Get my users from database
		List<User> list = uServ.findAllUsers();
		
		//Convert Java object into a JSON String that can be 
		//written into the body of an HTTP response
		//json can be read and easily transfered along with an HTTP Response
		//server isn't aware of what the client is. 
		//It (the Server) just accepts the HTTP requests and returns the HTTP responses 
		//and the client can be using a web page using javascript. 
		//it could be postman or even another Java application
		
		String json = om.writeValueAsString(list);
		System.out.println(json);
		
		PrintWriter pw = response.getWriter();
		pw.print(json);
		response.setStatus(200);
		response.setContentType("application/json");
				
		
		
	}
	
	//Add to db
@Override
 protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		StringBuilder sb = new StringBuilder();
		
		//request object has a built in method to return an object that can read the body line by line
		BufferedReader reader = request.getReader();
		
		String line = reader.readLine();
		
		while(line != null) {
			sb.append(line);
			//advance to next line
			line = reader.readLine();
		}
		
		String body = new String(sb);
		
	//Everything above ^^^^ is there so object mapper can read the body
	
	//Jackson will convert the json that is in the body to a java object we tell it to

	User u = om.readValue( body, User.class);
	
	if(uServ.addUser(u)) {
		response.setStatus(201); //created
	} else {
		response.setStatus(400);// bad request
	}
}
}
