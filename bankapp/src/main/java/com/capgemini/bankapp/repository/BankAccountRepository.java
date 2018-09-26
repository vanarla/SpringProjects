package com.capgemini.bankapp.repository;

import java.sql.SQLException;
import java.util.List;

import com.capgemini.bankapp.exception.AccountNotFoundException;
import com.capgemini.bankapp.modal.BankAccount;

public interface BankAccountRepository {
	
	public double getBalance(long accountId) throws AccountNotFoundException, SQLException;
	public boolean updateBalance(long accountId,double newBalance);
	public boolean addBankAcoount(BankAccount account);
	public BankAccount findBankAccountById(long accountId);
	
	public List<BankAccount> findAllBankAccounts();
    public BankAccount updateBankAccount(BankAccount account);
    public boolean deleteBankAccount(long accountId);
    
}
