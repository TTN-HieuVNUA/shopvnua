package com.hieu.bean;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.springframework.web.multipart.MultipartFile;

@Entity
@Table(name = "productdetail")
public class ProductDetail extends BaseEntity{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	private String color;
	
	private BigDecimal price;
	
	private String size;
	
	private int quantity;
	
	private String image;
	
	
	/*
	 * đánh dấu 1 field không map đến column nào trong CSDL
	 */
	@Transient
	private MultipartFile file;
	
	@ManyToOne
	@JoinColumn(name = "pro_code")
	private Product productid;

	@OneToMany(mappedBy = "productDetailid")
	private List<InvoiceDetail> invoiceDetaillist = new ArrayList<InvoiceDetail>();
	
	public ProductDetail() {
	
	}

	public ProductDetail(String image) {
		this.image = image;
	}

	public ProductDetail(int id, String color, BigDecimal price, String size, int quantity, String image) {
		this.id = id;
		this.color = color;
		this.price = price;
		this.size = size;
		this.quantity = quantity;
		this.image = image;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public BigDecimal getPrice() {
		return price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}

	public String getSize() {
		return size;
	}

	public void setSize(String size) {
		this.size = size;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public Product getProductid() {
		return productid;
	}

	public void setProductid(Product productid) {
		this.productid = productid;
	}

	public List<InvoiceDetail> getInvoiceDetaillist() {
		return invoiceDetaillist;
	}

	public void setInvoiceDetaillist(List<InvoiceDetail> invoiceDetaillist) {
		this.invoiceDetaillist = invoiceDetaillist;
	}

	public MultipartFile getFile() {
		return file;
	}

	public void setFile(MultipartFile file) {
		this.file = file;
	}

	@Override
	public String toString() {
		return "ProductDetail [id=" + id + ", color=" + color + ", price=" + price + ", size=" + size
				+ ", quantity=" + quantity + ", image=" + image + "\n";
	}
	
	
}
