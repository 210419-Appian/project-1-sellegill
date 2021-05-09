package com.revature.models;

import java.util.Objects;

public class Withdrawal {
	
	private int accountId;
	private double amount;
	
	
	//no args constructor
	public Withdrawal() {
		super();
	}


	public Withdrawal(int accountId, double amount) {
		super();
		this.accountId = accountId;
		this.amount = amount;
	}


	public int getAccountId() {
		return accountId;
	}


	public void setAccountId(int accountId) {
		this.accountId = accountId;
	}


	public double getAmount() {
		return amount;
	}


	public void setAmount(double amount) {
		this.amount = amount;
	}


	@Override
	public int hashCode() {
		return Objects.hash(accountId, amount);
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (!(obj instanceof Withdrawal)) {
			return false;
		}
		Withdrawal other = (Withdrawal) obj;
		return accountId == other.accountId && Double.doubleToLongBits(amount) == Double.doubleToLongBits(other.amount);
	}
	
	
	

}
