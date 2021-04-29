package com.revature.models;

public class Role {
	
	private int roleId;
	private String role;
	
	//no args constructor
	public Role() {
		super();
	}
	
	public Role(int roleId, String role) {
		super();
		this.roleId = roleId;
		this.role = role;
	}
	
	//getters and setters 
	
	public int getId() {
		return roleId;
	}
	
	public void setId(int roleId) {
		this.roleId = roleId;
	}
	
	public String getRole() {
		return role;
	}
	
	public void setRole(String role) {
		this.role = role;
	}

}
