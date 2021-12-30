package com.hieu.bean;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "trademark")
public class TradeMark {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	private String name;

	@Column(name = "createddate")
	private Timestamp createdDate;
	
	@OneToMany(mappedBy = "trademarkid")
	private List<Product> proList = new ArrayList<Product>();
	
	public TradeMark() {
		
	}


	public TradeMark(int id, String name, Timestamp createdDate) {
		super();
		this.id = id;
		this.name = name;
		this.createdDate = createdDate;
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

	public List<Product> getProList() {
		return proList;
	}

	public void setProList(List<Product> proList) {
		this.proList = proList;
	}

	public Timestamp getCreatedDate() {
		return createdDate;
	}


	public void setCreatedDate(Timestamp createdDate) {
		this.createdDate = createdDate;
	}


	@Override
	public String toString() {
		return "TradeMark [id=" + id + "]";
	}
	
}
