package com.revature.service;

import java.util.List;

import com.revature.daos.AccountDAO;
import com.revature.daos.AccountDAOImpl;
import com.revature.models.Account;

public class AccountService {
	
	private AccountDAO accDao = new AccountDAOImpl();

	public List<Account> findAllAccounts() {
		return accDao.findAllAccounts();
	}

	public List<Account> findAccountByUserId(int userId) {
		return accDao.findAccountByUserId(userId);
	}

	public int createAccount(Account account) {
		return accDao.createAccount(account);
	}

	public int update(Account account) {
		return accDao.update(account);
	}

	public int usersAccounts(int accountId) {
		return accDao.usersAccounts(accountId);
	}

	public int deposit() {
		return accDao.deposit();
	}
	
	

}
