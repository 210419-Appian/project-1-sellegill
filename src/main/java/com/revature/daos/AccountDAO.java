package com.revature.daos;

import java.util.List;
//think of all roles admin, employee, customer
import com.revature.models.Account;

public interface AccountDAO {
	
	public List<Account> findAllAccounts(); 
	public List<Account> findAccountByUserId(int userId); 
	
	public int createAccount(Account account);
	public int update(Account account);
	public int usersAccounts(int accountId);
	
	public int deposit();

}
