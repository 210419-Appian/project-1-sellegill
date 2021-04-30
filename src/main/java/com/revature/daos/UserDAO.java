package com.revature.daos;

import java.util.List;

import com.revature.models.User;

//use DML CRUD /DQL?

public interface UserDAO {
	
	
	public List<User> findAll(); //Retrieve from DB 
	public User findById(int userId); //Retrieve from DB 
	public User findByUsername(String username); //Retrieve from DB 
	
	public int makeUser(); //Create/Insert
	
	public int update(); //Update 
	
	public int delete(); //Delete
	
	
	
	
	
	
	

}
