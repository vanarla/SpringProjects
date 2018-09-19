package com.capgemini.bankapp.repository.impl;

import java.util.HashSet;

import com.capgemini.bankapp.modal.BankAccount;
import com.capgemini.bankapp.repository.BankAccountRepository;

public class BankAccountRepositoryImpl implements BankAccountRepository {

	private HashSet<BankAccount> bankAccounts;
	
	
	public BankAccountRepositoryImpl() {
		super();
		bankAccounts=new HashSet<>();
		bankAccounts.add(new BankAccount(123,"Pallavi","Savings",45000));
		bankAccounts.add(new BankAccount(124,"Teju","Savings",12000));
		bankAccounts.add(new BankAccount(125,"Naveena","Current",34000));
		bankAccounts.add(new BankAccount(126,"Spandana","Savings",15000));
	}

	@Override
	public double getBalance(long accountId) {
		for (BankAccount bankAccount : bankAccounts) {
			if(bankAccount.getAccountId()==accountId)
				return bankAccount.getAccountBalance();
			
		}
		return -1;
	}

	@Override
	public boolean updateBalance(long accountId, double newBalance) {
		for (BankAccount bankAccount : bankAccounts) {
			if(bankAccount.getAccountId()==accountId)
			bankAccount.setAccountBalance(newBalance);
			return true;
			
		}
		return false;
	}

}
