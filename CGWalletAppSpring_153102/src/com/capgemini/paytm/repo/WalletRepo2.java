package com.capgemini.paytm.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.capgemini.paytm.beans.Transaction;

public interface WalletRepo2 extends JpaRepository<Transaction, String>{
	
	@Query("SELECT t FROM Transaction t WHERE t.mobileNo =:mobileno")
	public List<Transaction> findByMobileNo(@Param("mobileno") String mobileno);
	

}
