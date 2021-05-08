package com.revature.models;

import java.util.Objects;

public class Account{
	private int accountId; //primary key
	private double balance; //not null
	private int status;
	private int accType;
	private int owner_id;
	
	
	public Account() {
		super();

	}

	
public Account(int accountId, double balance, int status, int accType, int owner_id) {
		super();
		this.accountId = accountId;
		this.balance = balance;
		this.status = status;
		this.accType = accType;
		this.owner_id = owner_id;
	}

	//getters and setters
	public int getAccountId() {
		return accountId;
	}


	public void setAccountId(int accountId) {
		this.accountId = accountId;
	}


	public double getBalance() {
		return balance;
	}


	public void setBalance(double balance) {
		this.balance = balance;
	}


	public int getStatus() {
		return status;
	}


	public void setStatus(int status) {
		this.status = status;
	}


	public int getAccType() {
		return accType;
	}


	public void setAccType(int accType) {
		this.accType = accType;
	}


	public int getOwner_id() {
		return owner_id;
	}


	public void setOwner_id(int owner_id) {
		this.owner_id = owner_id;
	}


	@Override
	public int hashCode() {
		return Objects.hash(accType, accountId, balance, owner_id, status);
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (!(obj instanceof Account)) {
			return false;
		}
		Account other = (Account) obj;
		return accType == other.accType && accountId == other.accountId
				&& Double.doubleToLongBits(balance) == Double.doubleToLongBits(other.balance)
				&& owner_id == other.owner_id && status == other.status;
	}


	@Override
	public String toString() {
		return "Account [accountId=" + accountId + ", balance=" + balance + ", status=" + status + ", accType="
				+ accType + ", owner_id=" + owner_id + "]";
	}


	
}
