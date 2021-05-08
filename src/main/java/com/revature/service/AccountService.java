package com.revature.service;

import java.util.List;

import com.revature.daos.AccountDAO;
import com.revature.daos.AccountDAOImpl;
import com.revature.daos.UserDAOImpl;
import com.revature.models.Account;

import com.revature.models.User;

public class AccountService {
	
	private AccountDAOImpl accDao = new AccountDAOImpl();
	
	private UserDAOImpl uDao = new UserDAOImpl();

	public List<Account> findAllAccounts() {
		
		
		return accDao.findAllAccounts();
	}

	public Account findByAccountId(int id) {
		return accDao.findByAccountId(id);
	}

	public List<Account> findByUser(Account a, User u) {
		return accDao.findByUser(a, u);
	}

	public boolean addAccount(Account a) {
		return accDao.addAccount(a);
	}

	

	

}
