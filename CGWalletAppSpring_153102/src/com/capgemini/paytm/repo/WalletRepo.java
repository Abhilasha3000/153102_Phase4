package com.capgemini.paytm.repo;



import org.springframework.data.jpa.repository.JpaRepository;

import com.capgemini.paytm.beans.Customer;


public interface WalletRepo extends JpaRepository<Customer, String> {

	/*public boolean save(Customer customer);	
	public Customer findOne(String mobileNo);
	public Customer Update(String mobileNo,Customer custm) ;
	public boolean saveTransaction(Transaction transaction);	
	public List<Transaction> findTransaction(String mobileNo);
	*/
	
	
	
}
