package com.hieu.bean;

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
import javax.persistence.Table;

@Entity
@Table(name = "role")
public class Role {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;
	
	@Column(name = "rolename")
	private String roleName;

	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(name = "roleaccount", joinColumns = {@JoinColumn(name="role_id")}, inverseJoinColumns = {@JoinColumn(name="account_id")} )
	private List<Account> listaccount = new ArrayList<Account>();
	
	public Role() {
		
	}

	public Role(int id, String roleName) {
		this.id = id;
		this.roleName = roleName;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getRoleName() {
		return roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

	public List<Account> getListaccount() {
		return listaccount;
	}

	public void setListaccount(List<Account> listaccount) {
		this.listaccount = listaccount;
	}

	@Override
	public String toString() {
		return "Role [id=" + id + ", roleName=" + roleName + "]";
	}
	
	
}
