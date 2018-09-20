package com.capgemini.bankapp.client;

import java.sql.SQLException;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.capgemini.bankapp.config.AppConfig;
import com.capgemini.bankapp.controller.BankAccountController;
import com.capgemini.bankapp.exception.AccountNotFoundException;
import com.capgemini.bankapp.exception.LowBalanceException;

public class Application {
	public static void main(String args[]) throws AccountNotFoundException, SQLException {
/*		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");*/
		ApplicationContext context=new AnnotationConfigApplicationContext(AppConfig.class);
		BankAccountController bankAccountController = context.getBean("bankAccountController",
				BankAccountController.class);
/*		System.out.println(bankAccountController.getBalance(124));
*/		
		try {
			bankAccountController.fundTransfer(123, 124, 48000);
			System.out.println(bankAccountController.getBalance(123));
			
			/*bankAccountController.withdraw(124, 10000);
			System.out.println(bankAccountController.getBalance(124));

			bankAccountController.deposit(124, 10000);
			System.out.println(bankAccountController.getBalance(124));
			*/
	} catch (LowBalanceException e) {
			System.out.println(e.getMessage());
		}

	}

}
