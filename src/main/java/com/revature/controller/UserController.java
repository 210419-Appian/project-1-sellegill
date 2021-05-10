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
	
	public void getUser(HttpServletResponse response, int id) throws IOException {
		
		User u = uServ.findById(id);
		
		String json = om.writeValueAsString(u);
		System.out.println(json);
		
		PrintWriter pw = response.getWriter();
		
		pw.print(json);
		response.setStatus(200); //Success!
	}
	
	public void addUser(HttpServletRequest request, HttpServletResponse response) throws IOException {
		
		BufferedReader br = request.getReader();
		
		StringBuilder sb = new StringBuilder();
		
		String line = br.readLine();
		
		while(line != null) {
			sb.append(line);
			line = br.readLine();
		}
		
		String body = new String(sb);
		
		User u = om.readValue(body, User.class);
		
		if(uServ.addUser(u)) {
			response.setStatus(201);// Created
		} else {
			response.setStatus(406); //Not Acceptable
		}
	}
public void putUser(HttpServletRequest request, HttpServletResponse response) throws IOException {
		
		BufferedReader br = request.getReader();
		
		StringBuilder sb = new StringBuilder();
		
		String line = br.readLine();
		
		while(line != null) {
			sb.append(line);
			line = br.readLine();
		}
		
		String body = new String(sb);
		
		User u = om.readValue(body, User.class);
		
		if(uServ.updateUser(u, 0)) {
			response.setStatus(201);// Created
		} else {
			response.setStatus(400); //Bad Request
		}
	}

public void patchUser(HttpServletRequest request, HttpServletResponse response) throws IOException {
	
	BufferedReader br = request.getReader();
	
	StringBuilder sb = new StringBuilder();
	
	String line = br.readLine();
	
	while(line != null) {
		sb.append(line);
		line = br.readLine();
	}
	
	String body = new String(sb);
	
	User u = om.readValue(body, User.class);
	
	if(uServ.updateUser(u, 0)) {
		response.setStatus(200);// Success
	} else {
		response.setStatus(400); //Bad Request
	}
}
}
