package com.revature.controller;
import java.io.IOException;

import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.service.AccountService;

public class AccountController {

	private AccountService aServ = new AccountService();
	
	private ObjectMapper om = new ObjectMapper();
	
	public void getAccount(HttpServletResponse response, String string) throws IOException {
		
		
	}
	
	
	
	
}
