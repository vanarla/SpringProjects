package com.capgemini.bankapp.controller;

import com.capgemini.bankapp.exception.LowBalanceException;
import com.capgemini.bankapp.service.BankAccountService;

public class BankAccountController {
	
	private BankAccountService bankAccountService;

	public void setBankAccountService(BankAccountService bankAccountService)
	{
		this.bankAccountService=bankAccountService;
	}
	
	public double getBalance(long accountId)
	{
		return bankAccountService.getBalance(accountId);
	}
	
	public double withdraw(long accountId,double amount) throws LowBalanceException
	{
		return bankAccountService.withdraw(accountId, amount);
	}
	
	public double deposit(long accountId,double amount)
	{
		return bankAccountService.deposit(accountId, amount);
	}
	
	public boolean fundTransfer(long fromAcc,long toAcc,double amount) throws LowBalanceException
	{
		return bankAccountService.fundTransfer(fromAcc, toAcc, amount);
	}
	
	
}
