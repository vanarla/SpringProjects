package com.capgemini.bankapp.repository;

import java.sql.SQLException;

import com.capgemini.bankapp.exception.AccountNotFoundException;

public interface BankAccountRepository {
	
	public double getBalance(long accountId) throws AccountNotFoundException, SQLException;
	public boolean updateBalance(long accountId,double newBalance);

}
