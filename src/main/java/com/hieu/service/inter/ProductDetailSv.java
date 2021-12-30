package com.hieu.service.inter;

import java.util.List;

import com.hieu.bean.Product;
import com.hieu.bean.ProductDetail;

public interface ProductDetailSv {

	boolean addOrUpdate(ProductDetail productDetail,Product product, String username);

	boolean add(ProductDetail productDetail,int idproduct, String username);
	
	boolean delete(int id);
	
	ProductDetail findAprProductDetail(int id);
	
	void edit(ProductDetail productDetail, String username);
	
	String editImage(ProductDetail productDetail);
	
	List<ProductDetail> getListProductDetail();
	
	List<ProductDetail> findListProductDetail(String name);
	
	ProductDetail findAProductDetail(int id);
	
	List<ProductDetail> getListProductDetail(int idOfProduct);
	
	List<ProductDetail> getListProductDetail(String subString);
	
	List<ProductDetail> getListProductDetails(int page, String requesParam);
	
	int getNumberOfPage(String requesParam);
}
