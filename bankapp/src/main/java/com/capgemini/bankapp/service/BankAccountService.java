package com.capgemini.bankapp.service;

import java.sql.SQLException;

import com.capgemini.bankapp.exception.AccountNotFoundException;
import com.capgemini.bankapp.exception.LowBalanceException;

public interface BankAccountService {

	public double getBalance(long accountId) throws AccountNotFoundException, SQLException;
	public double withdraw(long accountId,double amount) throws LowBalanceException, AccountNotFoundException, SQLException;
	public double deposit(long accountId,double amount) throws AccountNotFoundException, SQLException;
	public boolean fundTransfer(long fromAcc,long toAcc,double amount) throws LowBalanceException, AccountNotFoundException, SQLException;
	
}
