package com.revature.service;

import java.util.List;

import com.revature.daos.UserDAO;
import com.revature.daos.UserDAOImpl;
import com.revature.models.User;

public class UserService {
	
	private static UserDAO uDao = new UserDAOImpl();

	public List<User> findAllUsers() {
		return uDao.findAllUsers();
	}

	public User findById(int userId) {
		return uDao.findById(userId);
	}

	public User findUserByUsername(String username) {
		return uDao.findUserByUsername(username);
	}

	public boolean addUser(User u) {
		return uDao.addUser(u);
	}

	public boolean updateUser(User u, int id) {
		return uDao.updateUser(u, id);
	}



	
}
