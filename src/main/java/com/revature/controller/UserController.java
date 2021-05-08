package com.revature.controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.models.User;
import com.revature.service.UserService;

public class UserController {

	private UserService uServ = new UserService();
	
	private ObjectMapper om = new ObjectMapper();
	
	public void getAllUsers(HttpServletResponse response) throws IOException {
		//Gets users from DB
		List <User> list = uServ.findAllUsers();
		
		//Convert Java object into JSOn String that can be written
		//in the body of the HTTP response
		String json = om.writeValueAsString(list);
		System.out.println(json);
		
		PrintWriter pw = response.getWriter();
		
		pw.print(json);
		response.setStatus(200); //Success!
	}
}
