package com.hieu.bean;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "invoice")
public class Invoice {

	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(name = "createddate")
	private Timestamp createdate;
	
	private String paymethod;
	
	private BigDecimal totalmoney;
	
	@ManyToOne
	@JoinColumn(name = "customer_id")
	private Customer customerid;
	
	@ManyToOne
	@JoinColumn(name = "emp_id")
	private Employee employeeid;
	
	@OneToMany(mappedBy = "invoiceid")
	private List<InvoiceDetail> invoiceDetaillist = new ArrayList<InvoiceDetail>();
	
	public Invoice() {
		
	}

	public Invoice(int id, Timestamp createdate, String paymethod, BigDecimal totalmoney) {
		this.id = id;
		this.createdate = createdate;
		this.paymethod = paymethod;
		this.totalmoney = totalmoney;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Timestamp getCreatedate() {
		return createdate;
	}

	public void setCreatedate(Timestamp createdate) {
		this.createdate = createdate;
	}

	public String getPaymethod() {
		return paymethod;
	}

	public void setPaymethod(String paymethod) {
		this.paymethod = paymethod;
	}

	public BigDecimal getTotalmoney() {
		return totalmoney;
	}

	public void setTotalmoney(BigDecimal totalmoney) {
		this.totalmoney = totalmoney;
	}

	public Customer getCustomerid() {
		return customerid;
	}

	public void setCustomerid(Customer customerid) {
		this.customerid = customerid;
	}

	public Employee getEmployeeid() {
		return employeeid;
	}

	public void setEmployeeid(Employee employeeid) {
		this.employeeid = employeeid;
	}

	public List<InvoiceDetail> getInvoiceDetaillist() {
		return invoiceDetaillist;
	}

	public void setInvoiceDetaillist(List<InvoiceDetail> invoiceDetaillist) {
		this.invoiceDetaillist = invoiceDetaillist;
	}

	@Override
	public String toString() {
		return "Invoice [id=" + id + ", createdate=" + createdate + ", paymethod=" + paymethod + ", totalmoney="
				+ totalmoney + "]";
	}
	
	
}
