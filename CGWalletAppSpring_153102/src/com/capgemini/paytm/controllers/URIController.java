package com.capgemini.paytm.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.capgemini.paytm.beans.Customer;
import com.capgemini.paytm.beans.Transaction;

@Controller
public class URIController {
	
	
	@RequestMapping(value="/")
	public String getIndexPage() {
		return "index";
	}
	
	
	
	@RequestMapping(value="registration")
	public String getRegistrationPage() {
		return "registration";
	}
	
	@RequestMapping(value="menu")
	public String getMenuPage() {
		return "menu";
	}
	
	@RequestMapping(value="logout")
	public String getLogoutPage() {
		return "logout";
	}
	
	@RequestMapping(value="showBalance")
	public String getBalancePage() {
		return "showBalance";
	}
	
	@RequestMapping(value="deposit")
	public String getDepositPage() {
		return "deposit";
	}
	
	@RequestMapping(value="withdraw")
	public String getWithdrawPage() {
		return "withdraw";
	}
	
	@RequestMapping(value="fundTransfer")
	public String getFundTransferPage() {
		return "fundTransfer";
	}
	
	@ModelAttribute("customer")
	public Customer getCustomer()
	{
		return new Customer();
	}
	
	
	@ModelAttribute("transaction")
	public Transaction getTransaction()
	{
		return new Transaction();
	}

	
	@RequestMapping(value="printTransaction")
	public String getPrintTransactionPage() {
		return "printTransaction";
	}
	

}
