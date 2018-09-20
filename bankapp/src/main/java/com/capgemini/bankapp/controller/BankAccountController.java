package com.capgemini.bankapp.controller;

import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.capgemini.bankapp.exception.AccountNotFoundException;
import com.capgemini.bankapp.exception.LowBalanceException;
import com.capgemini.bankapp.service.BankAccountService;
@Controller
public class BankAccountController {
	
	private BankAccountService bankAccountService;
@Autowired
private BankAccountController(BankAccountService bankAccountService) {
		super();
		this.bankAccountService = bankAccountService;
	}

//	public void setBankAccountService(BankAccountService bankAccountService)
//	{
//		this.bankAccountService=bankAccountService;
//	}
//	
	
	
	public double getBalance(long accountId) throws AccountNotFoundException, SQLException
	{
		return bankAccountService.getBalance(accountId);
	}
	
	public double withdraw(long accountId,double amount) throws LowBalanceException, AccountNotFoundException, SQLException
	{
		return bankAccountService.withdraw(accountId, amount);
	}
	
	public double deposit(long accountId,double amount) throws AccountNotFoundException, SQLException
	{
		return bankAccountService.deposit(accountId, amount);
	}
	
	public boolean fundTransfer(long fromAcc,long toAcc,double amount) throws LowBalanceException, SQLException, AccountNotFoundException
	{
		return bankAccountService.fundTransfer(fromAcc, toAcc, amount);
	}
	
	
}
