package com.revature.models;
/*
 * The AccountStatus model is used to track the status of accounts.
 *  Status possibilities are 
 *  Pending, Open, or Closed, or Denied
 */

import java.util.Objects;

public class AccountStatus {
	private int statusId; //primary key
	private String status; //not null, unique
	
	//no args constructor 
	public AccountStatus() {
		super();
		
	}
	//default Constructor 
	public AccountStatus(int statusId, String status) {
		super();
		this.statusId = statusId;
		this.status = status;
	}
	
	//getters and setters
	public int getStatusId() {
		return statusId;
	}
	
	public void setStatusId(int statusId) {
		this.statusId = statusId;
	}
	
	public String getStatus() {
		return status;
	}
	
	public void setStatus(String status) {
		this.status = status;
	}
	
	//test both options generated options seem too busy
	
	/*@Override 
	 * public int hashCode(){
	 *  return Objects.hash(status, statusId);
	 * Maybe good to bring up in Presentation
	 * 
	 * Not using generated hashcode or .equals to have more concise code?
	 */
	
	@Override
	public int hashCode() {
		return Objects.hash(status, statusId);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (!(obj instanceof AccountStatus)) {
			return false;
		}
		AccountStatus other = (AccountStatus) obj;
		return Objects.equals(status, other.status) && statusId == other.statusId;
	}
	
	
	@Override
	public String toString() {
		return "AccountStatus [statusId=" + statusId + ", status=" + status + "]";
	}
	

}
