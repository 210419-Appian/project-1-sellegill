package com.revature.daos;

import java.util.List;

import com.revature.models.User;


public interface UserDAO {
	
	public List<User> findAllUsers(); //Retrieve from DB 
	
	public User findById(int userId); //Find by UserId
	
	public User findUserByUsername(String username); //Find by username
	
	public boolean addUser(User u); 
	
	public boolean updateUser(User u, int id); //Update 
	
	
	

}
