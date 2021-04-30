package com.revature.models;

import java.util.Objects;

/*
 * The AccountType model is used to track what kind of account is being created. 
 * Type possibilities are Checking or Savings
 * 
 */
public class AccountType {
	private int typeId; //primary key
	private String type; // not null unique
	
	
	public AccountType() {
		super();
		
	}
	//default constructor
	public AccountType(int typeId, String type) {
		super();
		this.typeId = typeId;
		this.type = type;
	}
	
	//Getters and Setters
	public int getTypeId() {
		return typeId;
	}
	public void setTypeId(int typeId) {
		this.typeId = typeId;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	
	/*
	 * Used instance of 
	 * block if 
	 * use objects.hash + Objects.equals method
	 * 
	 * 
	 */
	
	@Override
	public int hashCode() {
		return Objects.hash(type, typeId);
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (!(obj instanceof AccountType)) {
			return false;
		}
		AccountType other = (AccountType) obj;
		return Objects.equals(type, other.type) && typeId == other.typeId;
	}
	
	@Override
	public String toString() {
		return "AccountType [typeId=" + typeId + ", type=" + type + "]";
	}
	

	
}
