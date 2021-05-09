package com.revature.models;

import java.util.Objects;

public class Deposit {
 private int accountId;
 private double amount;
 
 
public Deposit() {
	super();
	// TODO Auto-generated constructor stub
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
	if (!(obj instanceof Deposit)) {
		return false;
	}
	Deposit other = (Deposit) obj;
	return accountId == other.accountId && Double.doubleToLongBits(amount) == Double.doubleToLongBits(other.amount);
}


@Override
public String toString() {
	return "Deposit [accountId=" + accountId + ", amount=" + amount + "]";
}
 
 
}
