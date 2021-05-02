package com.revature.controller;

import java.util.List;

import com.revature.models.Account;
import com.revature.service.AccountService;

public class AccountController {
	
	private final AccountService aServ = new AccountService();

	public int createAccount(Account account) {
		return aServ.createAccount(account);
	}

	public int deposit() {
		return aServ.deposit();
	}

	public boolean equals(Object arg0) {
		return aServ.equals(arg0);
	}

	public List<Account> findAllAccounts() {
		return aServ.findAllAccounts();
	}

	public List<Account> findAccountByUserId(int userId) {
		return aServ.findAccountByUserId(userId);
	}

	public int hashCode() {
		return aServ.hashCode();
	}

	public String toString() {
		return aServ.toString();
	}

	public int update(Account account) {
		return aServ.update(account);
	}

	public int usersAccounts(int accountId) {
		return aServ.usersAccounts(accountId);
	}
	
	

}
