package com.hieu.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hieu.repository.inter.InvoiceRepos;
import com.hieu.service.inter.InvoiceSv;

@Service
public class InvoiceService implements InvoiceSv{

	@Autowired
	private InvoiceRepos invoiceRepos;
	
	@Override
	public String getSumTotalMoney(int month, int year) {
		return invoiceRepos.getSumTotalMoney(month, year);
	}

	@Override
	public String getCusName(int month, int year) {
		return invoiceRepos.getNameCustomer(month, year);
	}

	@Override
	public String getEmpName(int month, int year) {
		return invoiceRepos.getNameEmployee(month, year);
	}

}
