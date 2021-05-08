package com.revature.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class ConnectionUtil {

	//ask about making constructor private vs public for password hashing (Possible improvement point to make in QC)
/*	private static Connection conn = null;
	
	private ConnectionUtil() {
		super();
	} 
	
*/
	
	public static Connection getConnection() throws SQLException {
		
		try {
			Class.forName("org.postgresql.Driver");
		} catch(ClassNotFoundException e) {
			e.printStackTrace();
		
	}
	
	
	String url = "jdbc:postgresql://appian-210419.cxcucfqpjgnt.us-east-2.rds.amazonaws.com:5432/postgres";
	String username = "postgres";
	String password = "password";

	
	return DriverManager.getConnection(url, username, password);


 }
	//Look up System.getenv later 
	
	//test connection it worked 5/6/21
/*
	public static void main(String[] args) {
		
		try(Connection conn=ConnectionUtil.getConnection()) {
			
			System.out.println("Connection Successful");
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
*/
}
