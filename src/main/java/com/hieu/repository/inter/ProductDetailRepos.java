package com.hieu.repository.inter;

import java.util.List;
import java.util.Set;

import com.hieu.bean.Product;
import com.hieu.bean.ProductDetail;

public interface ProductDetailRepos {

	/*
	 * thêm sản phẩm, nếu có thì update nó
	 */
	public boolean add(ProductDetail productDetail, Product product,String username);
	
	public boolean add(ProductDetail productDetail, int idproduct,String username);
	
	public boolean delete(int id);
	
	public ProductDetail findAprProductDetail(int id);
	
	public void edit(ProductDetail productDetail, String username);
	
	public List<ProductDetail> findListProductDetail(String name);
	
	ProductDetail findAProductDetail(int id);
	
	List<ProductDetail> getListProductDetail();
	
	List<ProductDetail> getProductDetalByIdProduct(int idOfProduct);
	
	List<ProductDetail> getListProduct(String subString);
	
	List<ProductDetail> getListProduct(int page, String requesParam);
	
	int getNumberOfPage(String requesparam);
}
