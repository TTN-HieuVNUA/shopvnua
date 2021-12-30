package com.hieu.bean;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MappedSuperclass;

@MappedSuperclass
public class BaseEntity {

	
	@Column(name = "createddate")
	private Timestamp createdDate;
	
	@Column(name = "modifieddate")
	private Timestamp modifiedDate;
	
	@ManyToOne
	@JoinColumn(name = "createdby")
	private Employee createdBy;
	
	@ManyToOne
	@JoinColumn(name = "modifiedby")
	private Employee modifiedBy;

	public Timestamp getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Timestamp createdDate) {
		this.createdDate = createdDate;
	}

	public Timestamp getModifiedDate() {
		return modifiedDate;
	}

	public void setModifiedDate(Timestamp modifiedDate) {
		this.modifiedDate = modifiedDate;
	}

	public Employee getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(Employee createdBy) {
		this.createdBy = createdBy;
	}

	public Employee getModifiedBy() {
		return modifiedBy;
	}

	public void setModifiedBy(Employee modifiedBy) {
		this.modifiedBy = modifiedBy;
	}

	@Override
	public String toString() {
		return "createdDate=" + createdDate + ", modifiedDate=" + modifiedDate + ", createdBy=" + createdBy
				+ ", modifiedBy=" + modifiedBy + "]";
	}

	
	
	
}
