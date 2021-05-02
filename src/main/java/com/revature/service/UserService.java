package com.revature.service;

import java.util.List;

import com.revature.daos.UserDAO;
import com.revature.daos.UserDAOImpl;
import com.revature.models.User;

public class UserService {
	
	private UserDAO uDao = new UserDAOImpl();

	public List<User> findAll() {
		return uDao.findAll();
	}

	public User findById(int userId) {
		return uDao.findById(userId);
	}

	public User findByUsername(String username) {
		return uDao.findByUsername(username);
	}

	public int makeUser() {
		return uDao.makeUser();
	}

	public int update() {
		return uDao.update();
	}

	public int delete() {
		return uDao.delete();
	}
	

}
