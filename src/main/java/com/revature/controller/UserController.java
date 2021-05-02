package com.revature.controller;

import java.util.List;

import com.revature.models.User;
import com.revature.service.UserService;

public class UserController {
	
	private final UserService uServ = new UserService();

	public int delete() {
		return uServ.delete();
	}

	public boolean equals(Object obj) {
		return uServ.equals(obj);
	}

	public List<User> findAll() {
		return uServ.findAll();
	}

	public User findById(int userId) {
		return uServ.findById(userId);
	}

	public User findByUsername(String username) {
		return uServ.findByUsername(username);
	}

	public int hashCode() {
		return uServ.hashCode();
	}

	public int makeUser() {
		return uServ.makeUser();
	}

	public String toString() {
		return uServ.toString();
	}

	public int update() {
		return uServ.update();
	}
	
	

}
