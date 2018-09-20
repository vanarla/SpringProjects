package com.capgemini.bankapp.repository.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.capgemini.bankapp.exception.AccountNotFoundException;
import com.capgemini.bankapp.repository.BankAccountRepository;
import com.capgemini.bankapp.util.DatabaseUtil;

@Repository

public class BankAccountRepositoryImpl implements BankAccountRepository {

	@Autowired
	DatabaseUtil dbUtil;

@Override
public double getBalance(long accountId) throws AccountNotFoundException, SQLException {
	String query = "SELECT account_balance FROM accounts WHERE account_id = ?";
	try (Connection connection = dbUtil.getConnection();
			PreparedStatement statement = connection.prepareStatement(query)) {
		
		statement.setLong(1, accountId);
		try(ResultSet result = statement.executeQuery()){
		if (result.next()) {
			return result.getDouble(1);
		}
		}catch (SQLException e) {
		e.printStackTrace();
	}
	throw new AccountNotFoundException("Account doesn't exist!");
	}
}

//private HashSet<BankAccount> accounts;
//
//public BankAccountRepositoryimpl() {
//	super();
//	accounts = new HashSet<>();
//	accounts.add(new BankAccount(123,"Naina","SAVINGS",35000));
//	accounts.add(new BankAccount(103,"Shu","SAVINGS",30000));
//	accounts.add(new BankAccount(203,"Chi","CURRENT",10000));
//}

//@Override
//public double getBalance(long accountId) {
//	for (BankAccount bankAccount : accounts) {
//		if(bankAccount.getAccountId()==accountId)
//			return bankAccount.getAccountBalance();
//		
//	}
//	return -1;
//}
//
//@Override
//public boolean updateBalance(long accountId, double newBalance) {
//	for (BankAccount bankAccount : accounts) {
//		if(bankAccount.getAccountId()==accountId)
//			bankAccount.setAccountBalance(newBalance);
//		
//	}
	
//	return false;


	@Override
	public boolean updateBalance(long accountId, double newBalance) {
		// TODO Auto-generated method stub
		return false;
	}

}