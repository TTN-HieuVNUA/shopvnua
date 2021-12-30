package com.hieu.repository.inter;

public interface InvoiceRepos {

	public String getSumTotalMoney(int month, int year);
	
	String getNameCustomer(int month, int year);
	
	String getNameEmployee(int month, int year);
	
}
