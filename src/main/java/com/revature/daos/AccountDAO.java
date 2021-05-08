package com.revature.daos;

import java.util.List;

import com.revature.models.Account;

import com.revature.models.User;

public interface AccountDAO {
	
	public List<Account> findAllAccounts(); //Find all accounts
	
	public Account findByAccountId(int id); //Find a single account
	
	public List<Account> findByUser(Account a, User u); //Find by User
	
	public boolean addAccount(Account a); //Create 
	
	

}
