package com.hieu.bean;

import java.sql.Date;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "employee")
public class Employee {

	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	private String name;
	
	@Column(name = "birth_year")
	private Date birthday;
	
	@Column(name = "phone")
	private int numphone;
	
	private String address;
	
	@Column(name = "image")
	private String avatar;
	
	@Column(name = "createddate")
	private Timestamp createdate;
	
	@OneToOne
	@JoinColumn(name = "account_id", referencedColumnName = "id")
	private Account accountid;
	
	@OneToMany(mappedBy = "employeeid")
	private List<Invoice> listInvoice = new ArrayList<Invoice>();

	@OneToMany(mappedBy = "createdBy")
	private List<Customer> listcreatedCustomers = new ArrayList<Customer>();
	
	@OneToMany(mappedBy = "modifiedBy")
	private List<Customer> listmodifiedCustomers = new ArrayList<Customer>();
	
	@OneToMany(mappedBy = "createdBy")
	private List<ProductDetail> listcreatedProductDetail = new ArrayList<ProductDetail>();
	
	@OneToMany(mappedBy = "modifiedBy")
	private List<ProductDetail> listmodifiedProductDetail = new ArrayList<ProductDetail>();
	
	public Employee() {
		
	}
	
	public Employee(int id, String name, Date birthday, int numphone, String address, String avatar,
			Timestamp createdate) {
		this.id = id;
		this.name = name;
		this.birthday = birthday;
		this.numphone = numphone;
		this.address = address;
		this.avatar = avatar;
		this.createdate = createdate;
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

	public Date getBirthday() {
		return birthday;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
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

	public String getAvatar() {
		return avatar;
	}

	public void setAvatar(String avatar) {
		this.avatar = avatar;
	}

	public Timestamp getCreatedate() {
		return createdate;
	}

	public void setCreatedate(Timestamp createdate) {
		this.createdate = createdate;
	}

	public Account getAccountid() {
		return accountid;
	}

	public void setAccountid(Account accountid) {
		this.accountid = accountid;
	}

	public List<Invoice> getListInvoice() {
		return listInvoice;
	}

	public void setListInvoice(List<Invoice> listInvoice) {
		this.listInvoice = listInvoice;
	}

	public List<Customer> getListcreatedCustomers() {
		return listcreatedCustomers;
	}

	public void setListcreatedCustomers(List<Customer> listcreatedCustomers) {
		this.listcreatedCustomers = listcreatedCustomers;
	}

	public List<Customer> getListmodifiedCustomers() {
		return listmodifiedCustomers;
	}

	public void setListmodifiedCustomers(List<Customer> listmodifiedCustomers) {
		this.listmodifiedCustomers = listmodifiedCustomers;
	}

	

	public List<ProductDetail> getListcreatedProductDetail() {
		return listcreatedProductDetail;
	}

	public void setListcreatedProductDetail(List<ProductDetail> listcreatedProductDetail) {
		this.listcreatedProductDetail = listcreatedProductDetail;
	}

	public List<ProductDetail> getListmodifiedProductDetail() {
		return listmodifiedProductDetail;
	}

	public void setListmodifiedProductDetail(List<ProductDetail> listmodifiedProductDetail) {
		this.listmodifiedProductDetail = listmodifiedProductDetail;
	}

	@Override
	public String toString() {
		return "Employee [id=" + id + ", name=" + name + ", birthday=" + birthday + ", numphone=" + numphone
				+ ", address=" + address + ", avatar=" + avatar + ", createdate=" + createdate+ "]";
	}
	
	public int caculateAge() {
		LocalDate localDate = LocalDate.now();
        int year = localDate.getYear();
        int years = getBirthday().getYear();
        return year-(years+1900);
	}
	
}
