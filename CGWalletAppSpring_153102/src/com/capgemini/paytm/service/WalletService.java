package com.capgemini.paytm.service;

import java.math.BigDecimal;
import java.util.List;

import org.eclipse.jdt.core.compiler.InvalidInputException;

import com.capgemini.paytm.beans.Customer;
import com.capgemini.paytm.beans.Transaction;
import com.capgemini.paytm.exception.InsufficientBalanceException;


public interface WalletService {
	
	public Customer createAccount(Customer customer)throws InvalidInputException ;
	public Customer showBalance (String mobileno) throws InvalidInputException;
	public Customer fundTransfer (String sourceMobileNo,String targetMobileNo, BigDecimal amount)throws InvalidInputException;
	public Customer depositAmount (String mobileNo,BigDecimal amount )throws InvalidInputException,InsufficientBalanceException;
	public Customer withdrawAmount(String mobileNo, BigDecimal amount)throws InvalidInputException,InsufficientBalanceException;
	public List<Transaction> printTransaction(String mobileNo)throws InvalidInputException;
}
