package com.capgemini.paytm.controllers;

import java.math.BigDecimal;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.capgemini.paytm.beans.Customer;
import com.capgemini.paytm.beans.Transaction;
import com.capgemini.paytm.service.WalletService;

@Controller
public class CustomerActionController {
	@Autowired
	WalletService walletService;
	

@RequestMapping(value="/registerCustomer")

public ModelAndView registerCustomer(@Valid @ModelAttribute("customer")Customer customer,BindingResult result) {

	try
	{
	if(result.hasErrors())
		return new ModelAndView("registration");
	customer=walletService.createAccount(customer);
	return new ModelAndView("registrationSuccess","customer",customer);
	}
	catch(Exception e)
	{
		return new ModelAndView("registration","message",e.getMessage());
	}
	
}
@RequestMapping(value="/show")

public ModelAndView showBalance(@Valid @ModelAttribute("customer")Customer customer,BindingResult result,@RequestParam("mobileNo")String mobileno) {
	
	try{
		
		
	customer=walletService.showBalance(mobileno);
	return new ModelAndView("viewBalance","customer",customer);
	}
	catch(Exception e)
	{
		return new ModelAndView("showBalance","message",e.getMessage());
		
	}
	
}	
@RequestMapping(value="/log")

public ModelAndView showLogin(@Valid @ModelAttribute("customer")Customer customer,BindingResult result,@RequestParam("mobno")String mobileno) {
	

	try
	{
	customer=walletService.showBalance(mobileno);
	 
		return new ModelAndView("login","mobno",mobileno);
	}
	
	
	catch(Exception e)
	
	{return new ModelAndView("index","message",e.getMessage());
	}
	}
	

@RequestMapping(value="/depos")

public ModelAndView deposit(@Valid @ModelAttribute("customer")Customer customer,BindingResult result,@RequestParam("mobileNo")String mobileno,@RequestParam("wallet.balance")BigDecimal amount) {
	
	try{
		
		
	customer=walletService.depositAmount(mobileno, amount);
	return new ModelAndView("viewBalance","customer",customer);
	}
	catch(Exception e)
	{
		return new ModelAndView("deposit","message",e.getMessage());
		
	}
	
}	

@RequestMapping(value="/with")

public ModelAndView withdraw(@Valid @ModelAttribute("customer")Customer customer,BindingResult result,@RequestParam("mobileNo")String mobileno,@RequestParam("wallet.balance")BigDecimal amount) {
	
	
	try{
			
	customer=walletService.withdrawAmount(mobileno, amount);
	return new ModelAndView("viewBalance","customer",customer);
	}
	catch(Exception e)
	{
		return new ModelAndView("withdraw","message",e.getMessage());
		
	}
	
}

@RequestMapping(value="/ft")

public ModelAndView fundTransfer(@Valid @ModelAttribute("customer")Customer customer,BindingResult result,@RequestParam("mobileNo1")String mobileno1,@RequestParam("mobileNo2")String mobileno2,@RequestParam("wallet.balance")BigDecimal amount) {
		
	try{
		
		customer=walletService.fundTransfer(mobileno1,mobileno2, amount);
	return new ModelAndView("viewBalance","customer",customer);
	}
	catch(Exception e)
	{
		
		return new ModelAndView("fundTransfer","message",e.getMessage());
	}
	
}	

@RequestMapping(value="/print")

public ModelAndView printTransaction(@Valid @ModelAttribute("customer")Customer customer,BindingResult result,@RequestParam("mobileNo")String mobileno) {
	

	try
	
	{
	List<Transaction> transaction = walletService.printTransaction(mobileno);
	return new ModelAndView("viewtransaction","transaction",transaction);
	}
	catch(Exception e)
	{
		
		return new ModelAndView("printTransaction","message",e.getMessage());
	}
	
	
}	
	
}
