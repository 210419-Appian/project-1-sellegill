package com.revature.controller;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.models.Account;
import com.revature.models.User;
import com.revature.service.AccountService;

public class AccountController {

	private AccountService aServ = new AccountService();
	
	private ObjectMapper om = new ObjectMapper();
	
	public void getAllAccount(HttpServletResponse response) throws IOException {
		List <Account> list = aServ.findAllAccounts(null);
		String json = om.writeValueAsString(list);
		System.out.println(json);
		
		PrintWriter pw = response.getWriter();
		
		pw.print(json);
		response.setStatus(200); //Success!		
		
	}
	
public void getAccount(HttpServletResponse response) throws IOException {
	//Gets users from DB
	List<Account> a = aServ.findByUser(null, null);
	
	//Convert Java object into JSOn String that can be written
	//in the body of the HTTP response
	String json = om.writeValueAsString(a);
	System.out.println(json);
	
	PrintWriter pw = response.getWriter();
	
	pw.print(json);
	response.setStatus(200); //Success!
				
		
	}
	
public void addAccount(HttpServletRequest request, HttpServletResponse response) throws IOException {
	
	BufferedReader br = request.getReader();
	
	StringBuilder sb = new StringBuilder();
	
	String line = br.readLine();
	
	while(line != null) {
		sb.append(line);
		line = br.readLine();
	}
	
	String body = new String(sb);
	
	User u = om.readValue(body, User.class);
	
	if(aServ.addAccount(null)) { //won't accept a 
		response.setStatus(201);// Created
	} else {
		response.setStatus(406); //Not Acceptable
	}
	
	
}
}
