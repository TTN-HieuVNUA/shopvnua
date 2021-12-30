package com.hieu.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hieu.repository.inter.InvoiceDetailRepos;
import com.hieu.service.inter.InvoiceDetailSv;

@Service
public class InvoiceDetailService implements InvoiceDetailSv{

	@Autowired
	private InvoiceDetailRepos invoiceDetailRepos;
	
	@Override
	public String getBestSallingProduct(int month, int year) {
		return invoiceDetailRepos.getBestSallingProduct(month, year);
	}

}
