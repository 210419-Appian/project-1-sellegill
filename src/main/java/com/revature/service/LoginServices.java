package com.revature.service;

import com.revature.models.User;
import com.revature.models.UserDTO;

public class LoginServices {
//if username is correct and password is correct = true 
	//else false or null
	private UserService uServ = new UserService();
	//use thus instead DTO
//	private AccountService aServ = new AccountService();	
	//UserDTO udto = new UserDTO();

//	public User findUserByUsername(String username) {
//		return uServ.findUserByUsername(username);
//	}
	
//	public boolean login(String username, String password) {
//		User u = uServ.findUserByUsername(username);
		
	public boolean login(String username, String password) {
		User u = uServ.findUserByUsername(username);
		
		if(u != null) {
			return true;
		} else if(u.getPassword().equals(password)) {
			
		}
		return false; //boolean return
		
	//	} else {
	//		return false;
		}
		
		
	}
	

	


