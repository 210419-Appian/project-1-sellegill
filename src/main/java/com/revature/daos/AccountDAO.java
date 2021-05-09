package com.revature.daos;

import java.util.List;

import com.revature.models.Account;

import com.revature.models.User;

public interface AccountDAO {
	
	public List<Account> findAllAccounts(); //Find all accounts
	
	public Account findByAccountId(int id); //Find a single account
	
	public List<Account> findByUser(Account a, User u); //Find by User
	
	public boolean addAccount(Account a); //Create 
	
	public boolean deposit(Account a, double amount);
	
	public boolean withdrawal(Account a, double amount);
	
	public boolean transfer(Account sourceAccountId, Account targetAccountId, double amount );
	
	List<Account> findAccountByStatus(int status);

}
