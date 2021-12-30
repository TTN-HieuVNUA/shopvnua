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
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "account")
public class Account{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;
	
	private String username;
	
	private String password;
	
	private int status;

	@Column(name = "createddate")
	private Timestamp createdDate;
	
	@Column(name = "modifieddate")
	private Timestamp modifiedDate;
	
	@Column(name = "name")
	private String name;
	
	@ManyToOne
	@JoinColumn(name = "createdby")
	private Account createdBy;
	
	@ManyToOne
	@JoinColumn(name = "modifiedby")
	private Account modifiedBy;
	
	@OneToMany(mappedBy = "createdBy")
	private List<Account> listAccountcreate = new ArrayList<Account>();
	
	@OneToMany(mappedBy = "modifiedBy")
	private List<Account> listAccountModified = new ArrayList<Account>();
	
	@OneToOne(mappedBy = "accountid")
	private Employee employee;
	
	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(name = "roleaccount", joinColumns = {@JoinColumn(name="account_id")}, inverseJoinColumns = {@JoinColumn(name="role_id")} )
	private List<Role> lisRoles = new ArrayList<Role>();
	
	public Account() {
		
	}

	public Account(int id, String username, String password, int status) {
		this.id = id;
		this.username = username;
		this.password = password;
		this.status = status;
	}

	public Account(int id, String username, String password, int status, Timestamp createdDate, Timestamp modifiedDate,
			String name) {
		this.id = id;
		this.username = username;
		this.password = password;
		this.status = status;
		this.createdDate = createdDate;
		this.modifiedDate = modifiedDate;
		this.name = name;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

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

	public Account getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(Account createdBy) {
		this.createdBy = createdBy;
	}

	public Account getModifiedBy() {
		return modifiedBy;
	}

	public void setModifiedBy(Account modifiedBy) {
		this.modifiedBy = modifiedBy;
	}

	public List<Account> getListAccountcreate() {
		return listAccountcreate;
	}

	public void setListAccountcreate(List<Account> listAccountcreate) {
		this.listAccountcreate = listAccountcreate;
	}

	public List<Account> getListAccountModified() {
		return listAccountModified;
	}

	public void setListAccountModified(List<Account> listAccountModified) {
		this.listAccountModified = listAccountModified;
	}

	public Employee getEmployee() {
		return employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}

	public List<Role> getLisRoles() {
		return lisRoles;
	}

	public void setLisRoles(List<Role> lisRoles) {
		this.lisRoles = lisRoles;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "Account [id=" + id + ", username=" + username + ", password=" + password + ", status=" + status
				+ ", createdDate=" + createdDate + ", modifiedDate=" + modifiedDate + "]";
	}


}
