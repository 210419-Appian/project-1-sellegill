package com.revature.daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.revature.models.Account;
import com.revature.models.User;
import com.revature.utils.ConnectionUtil;

public class UserDAOImpl implements UserDAO {
	
	
//	Connection conn = null; //Connection to DB
//	PreparedStatement stmt = null; //Protect against SQL Injection
/*-------------------------------------------------------------------------------*/	

	@Override
	public List<User> findAllUsers() {
		List<User> list = new ArrayList<>();
		
	try(Connection conn = ConnectionUtil.getConnection()){
		String sql="SELECT * FROM users;";
		
		Statement stat = conn.createStatement();
		
		ResultSet rs = stat.executeQuery(sql);
		
		while(rs.next()) {
			User u = new User();
			
			u.setUserId(rs.getInt("user_id"));
			u.setUsername(rs.getString("username"));
			u.setPassword(rs.getString("pass_word"));
			u.setFirstName(rs.getString("first_name"));
			u.setLastName(rs.getString("last_name"));
			u.setEmail(rs.getString("email"));
			u.setRoleName(rs.getInt("role_id")); 
			
			list.add(u);
		}
		return list;
		
	}catch(SQLException e) {
		e.printStackTrace();
	}
		return null;
	}
/*-------------------------------------------------------------------------------*/	
	@Override
	public User findById(int userId) {
		try(Connection conn = ConnectionUtil.getConnection()){
			String sql="SELECT * FROM users WHERE user_id = ?;";
			
			PreparedStatement stmt = conn.prepareStatement(sql);
			
			stmt.setInt(1, userId);
			
			ResultSet rs = stmt.executeQuery();
			
			while(rs.next()) {
				User u = new User();
	
				u.setUserId(rs.getInt("user_id"));
				u.setUsername(rs.getString("username"));
				u.setPassword(rs.getString("pass_word"));
				u.setFirstName(rs.getString("first_name"));
				u.setLastName(rs.getString("last_name"));
				u.setEmail(rs.getString("email"));
				u.setRoleName(rs.getInt("role_id"));
				
				return u;
			}
		}catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
/*-------------------------------------------------------------------------------*/	
	@Override
	public User findUserByUsername(String username) {
		try(Connection conn = ConnectionUtil.getConnection()){
			
			String sql="SELECT * FROM users WHERE username = ?;";
			
			PreparedStatement stmt = conn.prepareStatement(sql);
			
			stmt.setString(1, username);
			
			ResultSet rs = stmt.executeQuery();
			
			while(rs.next()) {
				User u = new User();
				u.setUserId(rs.getInt("user_id"));
				u.setUsername(rs.getString("username"));
				u.setPassword(rs.getString("pass_word"));
				u.setFirstName(rs.getString("first_name"));
				u.setLastName(rs.getString("last_name"));
				u.setEmail(rs.getString("email"));
				u.setRoleName(rs.getInt("role_id"));
				
				return u;
			}
		}catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
/*-------------------------------------------------------------------------------*/	
	@Override
	public boolean addUser(User u) {
		try(Connection conn = ConnectionUtil.getConnection()){
			String sql="INSERT INTO users (username, pass_word, first_name, last_name, email, role_id)" + "VALUES(?,?,?,?,?,?);";
			
			PreparedStatement stmt = conn.prepareStatement(sql);
			
			int index = 0;
			
			stmt.setString(++index, u.getUsername());
			stmt.setString(++index, u.getPassword());
			stmt.setString(++index, u.getFirstName());
			stmt.setString(++index, u.getLastName());
			stmt.setString(++index, u.getEmail());
			stmt.setInt(++index, u.getRoleId()); 
			
		/*	if(u.getUsername() != null) {
				stmt.setString(++index, u.getUsername());
			}else {
				stmt.setString(++index, null);
			} */
			stmt.execute();
			
			return true;
			
		}catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}
/*-------------------------------------------------------------------------------*/	
	@Override
	public boolean updateUser(User u, int id) {
		try(Connection conn = ConnectionUtil.getConnection()){
			String sql="UPDATE users SET" + "username = ?," + "password = ?," + "first_name = ?, " + "last_name = ?," 
		+ "email " + "role_id" + "WHERE user_id" + id + ";";
			
			PreparedStatement stmt = conn.prepareStatement(sql);
			
	         int index = 0;
			
			stmt.setString(++index, u.getUsername());
			stmt.setString(++index, u.getPassword());
			stmt.setString(++index, u.getFirstName());
			stmt.setString(++index, u.getLastName());
			stmt.setString(++index, u.getEmail());
			stmt.setInt(++index, u.getRoleId());
			
			stmt.execute();
			
			return true;
			
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return false;
	}
/*-------------------------------------------------------------------------------*/

}





