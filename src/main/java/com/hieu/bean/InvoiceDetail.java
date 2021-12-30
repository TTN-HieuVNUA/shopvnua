package com.hieu.bean;

import java.math.BigDecimal;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "invoicedetail")
public class InvoiceDetail {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	private int quantity;
	
	private BigDecimal money;
	
	@ManyToOne
	@JoinColumn(name = "productDetail_id")
	private ProductDetail productDetailid;
	
	@ManyToOne
	@JoinColumn(name = "invoice_id")
	private Invoice invoiceid;

	public InvoiceDetail() {
		
	}

	public InvoiceDetail(int id, int quantity, BigDecimal money) {
		this.id = id;
		this.quantity = quantity;
		this.money = money;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public BigDecimal getMoney() {
		return money;
	}

	public void setMoney(BigDecimal money) {
		this.money = money;
	}

	public ProductDetail getProductDetailid() {
		return productDetailid;
	}

	public void setProductDetailid(ProductDetail productDetailid) {
		this.productDetailid = productDetailid;
	}

	public Invoice getInvoiceid() {
		return invoiceid;
	}

	public void setInvoiceid(Invoice invoiceid) {
		this.invoiceid = invoiceid;
	}

	@Override
	public String toString() {
		return "InvoiceDetail [id=" + id + ", quantity=" + quantity + ", money=" + money + "]";
	}
	
	
}
