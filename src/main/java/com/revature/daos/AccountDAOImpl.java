package com.revature.daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.revature.models.Account;


import com.revature.models.User;
import com.revature.utils.ConnectionUtil;

public class AccountDAOImpl implements AccountDAO {

	@Override
	public List<Account> findAllAccounts() {
		List<Account> list = new ArrayList<>();
		try(Connection conn = ConnectionUtil.getConnection()){
			String sql="SELECT * FROM account;";
			
			Statement stmt = conn.createStatement();
			
			ResultSet rs = stmt.executeQuery(sql);
			
			while(rs.next()) {
				Account a = new Account();
				a.setAccountId(rs.getInt("account_id"));
				a.setBalance(rs.getDouble("balance"));
				a.setStatus(rs.getInt("account_status_id"));
				a.setAccType(rs.getInt("account_type_id"));
				a.setOwner_id(rs.getInt("owner_id"));
				
				list.add(a);
			}
			return list;
			
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
/*---------------------------------------------------------------------------------------------*/
	@Override
	public Account findByAccountId(int id) {
		
		try(Connection conn = ConnectionUtil.getConnection()){
			String sql="SELECT * FROM account WHERE account_id =?;";
			
			PreparedStatement stmt = conn.prepareStatement(sql);
			
			stmt.setInt(1, id);
			
			ResultSet rs = stmt.executeQuery();
			
			while(rs.next()) {
				Account a = new Account();
				
				a.setAccountId(rs.getInt("account_id"));
				a.setBalance(rs.getDouble("balance"));
				a.setStatus(rs.getInt("account_status_id"));
				a.setAccType(rs.getInt("account_type_id"));
				a.setOwner_id(rs.getInt("owner_id"));
				
				return a;
			}
			
			
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
/*---------------------------------------------------------------------------------------------*/	
	//ASK FOR HELP
	@Override
	public List<Account> findByUser(Account a, User u) {
		List<Account> list = new ArrayList<>();
			try(Connection conn = ConnectionUtil.getConnection()){
		
			String sql="SELECT * FROM account WHERE owner_id = ?;";
		
			PreparedStatement stmt = conn.prepareStatement(sql);
		
		//	stmt.setInt(1, a.getAccountId() );
			
		//	stmt.setString(2, u.getEmail());
		
			ResultSet rs = stmt.executeQuery();
		
			while(rs.next()) {
			Account acc = new Account();
			acc.setAccountId(rs.getInt("account_id"));
			acc.setBalance(rs.getDouble("balance"));
			acc.setStatus(rs.getInt("account_status_id"));
			acc.setAccType(rs.getInt("account_type_id"));
			acc.setOwner_id(rs.getInt("owner_id"));
			
			list.add(acc);
			}		
		//	return list;
			
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return list;
	}
/*---------------------------------------------------------------------------------------------*/
	@Override
	public boolean addAccount(Account a) {
		try(Connection conn = ConnectionUtil.getConnection()){
			String sql="INSERT INTO account (balance, account_status_id, account_type_id, owner_id)"+
		"VALUES(?,?,?,?)";
			
			PreparedStatement stmt = conn.prepareStatement(sql);
			
			
			
			int index = 0;
			stmt.setDouble(++index, a.getBalance());
			stmt.setInt(++index, a.getStatus());
			stmt.setInt(++index, a.getAccType());
			stmt.setInt(++index, a.getOwner_id());
			
			stmt.execute();
			
			return true;
			
			
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return false;
	}
/*---------------------------------------------------------------------------------------------*/
	@Override
	public boolean deposit(Account a, double amount) {
		try(Connection conn = ConnectionUtil.getConnection()){
			String sql = "UPDATE account SET balance = ? WHERE account_id = ?;";
			
			PreparedStatement stmt = conn.prepareStatement(sql);
			
			int accountId = a.getAccountId();
			double balance = a.getBalance() + amount;
			
			
			stmt.setInt(1, accountId);
			stmt.setDouble(2, balance);
			
			stmt.execute();
			
			return true;
			
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return false;
	}
/*-------------------------------------------------------------------------------*/	
	@Override
	public boolean withdrawal(Account a, double amount) {
		try(Connection conn = ConnectionUtil.getConnection()){
			
			String sql="UPDATE account SET balance = ? WHERE account_id = ?;";
			
			PreparedStatement stmt = conn.prepareStatement(sql);
			//use different keywords
			int accountId = a.getAccountId(); 
			double balance = a.getBalance() - amount ; //-= 
			
			stmt.execute();
			
			return true;
			
		}catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}
/*-------------------------------------------------------------------------------*/	
	//USE TCL BEGIN COMMIT
	@Override
	public boolean transfer(Account sourceAccountId, Account targetAccountId, double amount) {
		
		try(Connection conn = ConnectionUtil.getConnection()){
			
			String sql ="BEGIN;" + "UPDATE account SET balance = ? WHERE account_id =?;";//Commit?
			
			PreparedStatement stmt = conn.prepareStatement(sql);
			
			ResultSet rs = stmt.executeQuery();
			//
		/*	stmt.setDouble(1, amount);
			stmt.setInt(2, sourceAccountId);
			stmt.setDouble(3, amount);
			*/
		}catch(SQLException e) {
			
		}
		return false;
	}
/*-------------------------------------------------------------------------------*/	
	@Override
	public List<Account> findAccountByStatus(int status) {
		List <Account> list = new ArrayList<>();
		
		try(Connection conn = ConnectionUtil.getConnection()){
			
		   String sql = "SELECT * FROM account WHERE account_status_id =?;";	
		
	       PreparedStatement stmt = conn.prepareStatement(sql);
	       
	       
	       stmt.setInt(1, status);
			
			ResultSet rs = stmt.executeQuery();
			
			while(rs.next()) {
				Account a = new Account();
				
				a.setAccountId(rs.getInt("account_id"));
				a.setBalance(rs.getDouble("balance"));
				a.setStatus(rs.getInt("account_status_id"));
				a.setAccType(rs.getInt("account_type_id"));
				a.setOwner_id(rs.getInt("owner_id"));
				
				list.add(a);
			}
			return list;
			
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	
}
