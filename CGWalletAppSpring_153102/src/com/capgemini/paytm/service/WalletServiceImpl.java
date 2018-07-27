package com.capgemini.paytm.service;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import org.eclipse.jdt.core.compiler.InvalidInputException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.capgemini.paytm.beans.Customer;
import com.capgemini.paytm.beans.Transaction;
import com.capgemini.paytm.beans.Wallet;
import com.capgemini.paytm.exception.InsufficientBalanceException;
import com.capgemini.paytm.repo.WalletRepo;
import com.capgemini.paytm.repo.WalletRepo2;

@Component(value="walletService")
public class WalletServiceImpl implements WalletService {

	@Autowired
	WalletRepo repo;
	
	@Autowired
	WalletRepo2 repo2;
	
	public Customer createAccount(Customer customer) throws InvalidInputException 
	{Customer cust=repo.findOne(customer.getMobileNo());
	if(cust!=null)
		throw new InvalidInputException("Account already exists");
				
		return repo.save(customer);
	}

	public Customer showBalance(String mobileNo) throws InvalidInputException 
	{
		
		Customer customer=repo.findOne(mobileNo);	
		if(customer==null)
			throw new InvalidInputException("Account does not exists");
			return customer;
	}

	public Customer fundTransfer(String sourceMobileNo, String targetMobileNo, BigDecimal amount) throws InvalidInputException {	
		
		Customer scust=new Customer();
		Customer tcust=new Customer();
		scust=repo.findOne(sourceMobileNo);
		tcust=repo.findOne(targetMobileNo);
		if(scust==null|tcust==null)
		{
			throw new InvalidInputException("Account does not exists");
		}
		Transaction strans=new Transaction();
		Transaction ttrans=new Transaction();
		
		Wallet sw=scust.getWallet();
		Wallet tw=tcust.getWallet();
		
		strans.setMobileNo(sourceMobileNo);
		ttrans.setMobileNo(targetMobileNo);
		strans.setTransaction_amount(amount.floatValue());
		ttrans.setTransaction_amount(amount.floatValue());
		strans.setTransactionDate(new Date().toString());
		ttrans.setTransactionDate(new Date().toString());
		strans.setTransaction_type("Fund Transfer");
		ttrans.setTransaction_type("Fund Transfer");
		
		
		if(scust!=null && tcust!=null )
		{	
			if(scust.getWallet().getBalance().compareTo(amount)==1)
			{
			
			BigDecimal amtSub=scust.getWallet().getBalance();
			BigDecimal diff=amtSub.subtract(amount);
			sw.setBalance(diff);
			scust.setWallet(sw);
			
			BigDecimal amtAdd=tcust.getWallet().getBalance();
			BigDecimal sum=amtAdd.add(amount);			
			tw.setBalance(sum);
			tcust.setWallet(tw);
			
			strans.setTransaction_status("successfull");
			ttrans.setTransaction_status("successfull");
			
			tcust.setMobileNo(targetMobileNo);
			repo.save( tcust);
			
			scust.setMobileNo(sourceMobileNo);
			repo.save( scust);
			
			}
			else
				{
				strans.setTransaction_status("failed");
				ttrans.setTransaction_status("failed");
				repo2.save(strans);
				repo2.save(ttrans);
				throw new InsufficientBalanceException("Insufficient Balance");
				}
		}
		
		repo2.save(strans);
		repo2.save(ttrans);
		
		return tcust;
	}

	public Customer depositAmount(String mobileNo, BigDecimal amount) throws InvalidInputException {
		
		Customer cust=new Customer();
		cust=repo.findOne(mobileNo);
		if(cust==null)
		{
			throw new InvalidInputException("Account does not exists");
		}
		Wallet wallet=cust.getWallet();
		Transaction strans=new Transaction();
		
		strans.setMobileNo(mobileNo);
		strans.setTransaction_amount(amount.floatValue());
		strans.setTransactionDate(new Date().toString());
		strans.setTransaction_type("Deposit");
		
		if(cust!=null)
		{
			
			BigDecimal amtAdd=cust.getWallet().getBalance().add(amount);
			wallet.setBalance(amtAdd);
			cust.setWallet(wallet);
			strans.setTransaction_status("success");
			
			
			repo2.save(strans);
			cust.setMobileNo(mobileNo);
			repo.save(cust);
		}
		
	
		return cust;
	}

	public Customer withdrawAmount(String mobileNo, BigDecimal amount) throws InvalidInputException {
		
		
		Customer cust=new Customer();
		cust=repo.findOne(mobileNo);
		if(cust==null)
		{
			throw new InvalidInputException("Account does not exists");
		}
		Wallet wallet=cust.getWallet();
		
		Transaction strans=new Transaction();
		
		strans.setMobileNo(mobileNo);
		strans.setTransaction_amount(amount.floatValue());
		strans.setTransactionDate(new Date().toString());
		strans.setTransaction_type("Withdraw");
		
		
		if(cust!=null)
		{
			if(cust.getWallet().getBalance().compareTo(amount)==1)
			{
			BigDecimal amtSub=cust.getWallet().getBalance().subtract(amount);
			wallet.setBalance(amtSub);
			cust.setWallet(wallet);
			cust.setMobileNo(mobileNo);
			repo.save( cust);
		
			strans.setTransaction_status("success");
			}
			else
				{
				strans.setTransaction_status("failed");
				repo2.save(strans);
				
				throw new InsufficientBalanceException("Insufficient Balance");
				}
		}
		
		repo2.save(strans);
		
		return cust;
	}
	
	
	public List<Transaction> printTransaction(String mobileNo) throws InvalidInputException
	{
		Customer cust=new Customer();
		cust=repo.findOne(mobileNo);
		if(cust==null)
		{
			throw new InvalidInputException("Account does not exists");
		}
		return repo2.findByMobileNo(mobileNo);
		
	}
	
	
}
