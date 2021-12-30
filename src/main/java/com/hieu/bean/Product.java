package com.hieu.bean;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "product" )
public class Product{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(name = "name", unique = true)
	@NotNull
	private String name;

	@ManyToOne
	@JoinColumn(name = "trademarkid")
	private TradeMark trademarkid;
	
	@ManyToOne
	@JoinColumn(name = "categoryId")
	private Category categoryid;
	
	@OneToMany(mappedBy = "productid", fetch = FetchType.EAGER)
	private List<ProductDetail> productDetaillist = new ArrayList<ProductDetail>();

	
	public Product() {
		
	}

	public Product(int id, String name) {
		this.id = id;
		this.name = name;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}


	public TradeMark getTrademarkid() {
		return trademarkid;
	}

	public void setTrademarkid(TradeMark trademarkid) {
		this.trademarkid = trademarkid;
	}

	public Category getCategoryid() {
		return categoryid;
	}

	public void setCategoryid(Category categoryid) {
		this.categoryid = categoryid;
	}

	public List<ProductDetail> getProductDetaillist() {
		return productDetaillist;
	}

	public void setProductDetaillist(List<ProductDetail> productDetaillist) {
		this.productDetaillist = productDetaillist;
	}

	
	@Override
	public String toString() {
		return "Product [id=" + id + ", name=" + name + ", createdate=" + "]" + super.toString();
	}
	
	
	
}
