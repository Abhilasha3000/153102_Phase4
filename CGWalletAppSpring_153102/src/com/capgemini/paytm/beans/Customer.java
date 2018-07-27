package com.capgemini.paytm.beans;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;

@Entity
@Table(name="customersjpa")
public class Customer implements Serializable {

	private static final long serialVersionUID = 1L;


	@NotEmpty
	private String name;
	
	
	@Id
	
	@NotEmpty
	@Size(max=10,message="Enter 10 digit mobile no")
	@Pattern(regexp="(0/91)?[7-9][0-9]{9}",message="Enter valid mobile no")
	private String mobileNo;
	
	@OneToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="walletid")
	
	private Wallet wallet;
	
	
	
	public Customer(String name, String mobileNo,Wallet wallet) {
		super();
		this.name = name;
		this.mobileNo = mobileNo;
		this.wallet = wallet;
	}
	
	public Customer() {
		this.name = "";
		this.mobileNo = "";		
	}

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getMobileNo() {
		return mobileNo;
	}
	public void setMobileNo(String mobileNo) {
		this.mobileNo = mobileNo;
	}
	public Wallet getWallet() {
		return wallet;
	}
	public void setWallet(Wallet wallet) {
		this.wallet = wallet;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((mobileNo == null) ? 0 : mobileNo.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Customer other = (Customer) obj;
		if (mobileNo == null) {
			if (other.mobileNo != null)
				return false;
		} else if (!mobileNo.equals(other.mobileNo))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Customer Name=" + name + ", mobileNo=" + mobileNo
				+ ", wallet=" + wallet + "\n";
	}
	
}
