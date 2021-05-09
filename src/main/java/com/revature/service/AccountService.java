package com.revature.service;

import java.util.List;

import com.revature.daos.AccountDAO;
import com.revature.daos.AccountDAOImpl;
import com.revature.daos.UserDAOImpl;
import com.revature.exceptions.InsufficientFunds;
import com.revature.models.Account;

import com.revature.models.User;

public class AccountService {
	
	private AccountDAOImpl accDao = new AccountDAOImpl();
	
	private UserDAOImpl uDao = new UserDAOImpl();
	
//if stat w/ Sercurity exception for Admin or EMployees
	public List<Account> findAllAccounts() {
		
		return accDao.findAllAccounts();
	}
	//if stat w/ Sercurity exception for Admin or EMployees
	public Account findByAccountId(int id) {
		return accDao.findByAccountId(id);
	}
	//if stat w/ Sercurity exception for Admin or EMployees || OR && AND
	public List<Account> findByUser(Account a, User u) {
		return accDao.findByUser(a, u);
	}

	//maybe this too ||
	public boolean addAccount(Account a) {
		return accDao.addAccount(a);
	}

	public boolean deposit(Account a, double amount) {
		return accDao.deposit(a, amount);
	}

/*	public boolean equals(Object obj) {
		return accDao.equals(obj);
	}
*/
	public List<Account> findAccountByStatus(int status) {
		return accDao.findAccountByStatus(status);
	}
/*
	public int hashCode() {
		return accDao.hashCode();
	}

	public String toString() {
		return accDao.toString();
	}
*/
	public boolean withdrawal(Account a, double amount) throws InsufficientFunds {
		if(a.getBalance() < amount) {
			throw new InsufficientFunds("Transaction was not completed due to insufficient funds ");
		} else {
		return accDao.withdrawal(a, amount);
		}
	}
	
	//use if statement throw insufficient funds exception
	public boolean transfer(Account sourceAccountId, Account targetAccountId, double amount) {
		return accDao.transfer(sourceAccountId, targetAccountId, amount);
	}

	

	

}
