package com.hieu.bean;

import java.math.BigDecimal;

public class Cart {

	private int id;
	
	private int quantity;
	
	private BigDecimal price;

	private String name;
	
	private String image;
	
	public Cart() {
		
	}

	public Cart(int id,int quantity, BigDecimal price) {
		this.id = id;
		this.quantity = quantity;
		this.price = price;
	}

	
	public Cart(int id, int quantity, BigDecimal price, String name, String image) {
		this.id = id;
		this.quantity = quantity;
		this.price = price;
		this.name = name;
		this.image = image;
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

	public BigDecimal getPrice() {
		return price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	@Override
	public String toString() {
		return "Cart [id=" + id + ", quantity=" + quantity + "]";
	}
	
	
}
