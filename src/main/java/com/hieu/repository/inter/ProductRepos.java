package com.hieu.repository.inter;

import java.util.List;

import com.hieu.bean.Product;
import com.hieu.bean.ProductDetail;

public interface ProductRepos {

	public List<Product> getLiProducts();
	
	public boolean add(Product product, int categoryId, int TradeMarkid);
	
	public boolean delete(int id);
	
	public void edit(Product product,int idCategoy, int idTrademark);
	
	public Product findAProduct(int id);
	
	public List<Product> findListProduct(String name);
	
}
