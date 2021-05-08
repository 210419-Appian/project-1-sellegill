package com.revature.service;

import java.util.List;

import com.revature.daos.AccountDAO;
import com.revature.daos.AccountDAOImpl;
import com.revature.models.Account;

import com.revature.models.User;

public class AccountService {
	
	
	
	private AccountDAO accDao = new AccountDAOImpl();
	
	public List<Account> getAllAccounts(){
	
	List<Account> accounts = accDao.findAllAccounts();
	//business logic 

		return accounts;
	}	
	


	//public List<Account> findAllAccounts() {
	//	return accDao.findAllAccounts();
	//}


	

	
	
	//DO NOT LEAVE THIS HERE******** YOU HAVE BEEN WARNED	
	//Accounts must be able to withdrawal, deposit, and transfer using balance 
	//	public void deposit(double amount) {
	//		this.balance += amount;
	//	}
		
	//	public void withdraw(double amount) {
	//		this.balance -= amount;
	//	}
		
	//	public void transfer(double amount, Account a) {
	//		this.withdraw(amount);
	//		a.deposit(amount);
	//	}
		
	
	

}
