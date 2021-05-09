package com.revature.models;

import java.util.Objects;

public class Transfer {
	private int sourceAccountId;
	private int targetAccountId;
	private double amount;
	
	
	public Transfer() {
		super();
	}


	public Transfer(int sourceAccountId, int targetAccountId, double amount) {
		super();
		this.sourceAccountId = sourceAccountId;
		this.targetAccountId = targetAccountId;
		this.amount = amount;
	}


	public int getSourceAccountId() {
		return sourceAccountId;
	}


	public void setSourceAccountId(int sourceAccountId) {
		this.sourceAccountId = sourceAccountId;
	}


	public int getTargetAccountId() {
		return targetAccountId;
	}


	public void setTargetAccountId(int targetAccountId) {
		this.targetAccountId = targetAccountId;
	}


	public double getAmount() {
		return amount;
	}


	public void setAmount(double amount) {
		this.amount = amount;
	}


	@Override
	public int hashCode() {
		return Objects.hash(amount, sourceAccountId, targetAccountId);
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (!(obj instanceof Transfer)) {
			return false;
		}
		Transfer other = (Transfer) obj;
		return Double.doubleToLongBits(amount) == Double.doubleToLongBits(other.amount)
				&& sourceAccountId == other.sourceAccountId && targetAccountId == other.targetAccountId;
	}


	@Override
	public String toString() {
		return "Transfer [sourceAccountId=" + sourceAccountId + ", targetAccountId=" + targetAccountId + ", amount="
				+ amount + "]";
	}
	
	

}
