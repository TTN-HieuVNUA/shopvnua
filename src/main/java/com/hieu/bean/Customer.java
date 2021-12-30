package com.hieu.bean;

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
@Table(name = "customer")
public class Customer extends BaseEntity{

	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(name = "name")
	private String name;
	
	@Column(name = "phone")
	private int numphone;
	
	@Column(name = "address")
	private String address;
	
	public Customer() {
		
	}

	public Customer(int id, String name, int numphone, String address) {
		this.id = id;
		this.name = name;
		this.numphone = numphone;
		this.address = address;
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

	public int getNumphone() {
		return numphone;
	}

	public void setNumphone(int numphone) {
		this.numphone = numphone;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}


	@Override
	public String toString() {
		return "Customer [id=" + id + ", name=" + name + ", numphone=" + numphone + ", address="
				+ address + ", createdate=" + super.toString();
	}
	
}
