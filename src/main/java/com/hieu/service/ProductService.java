package com.hieu.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hieu.bean.Product;
import com.hieu.repository.inter.ProductRepos;
import com.hieu.service.inter.ProductDetailSv;
import com.hieu.service.inter.ProductSv;

@Service
public class ProductService implements ProductSv{

	@Autowired
	private ProductRepos productRepos;
	
	@Override
	public List<Product> getListProducts() {
		return productRepos.getLiProducts();
	}

	@Override
	public boolean add(Product product, int categoryId, int TradeMarkid) {
		if(!product.getName().equals("")) {
			boolean check = productRepos.add(product, categoryId, TradeMarkid);
			if(check) {
				return true;
			}
		}
		return false;
	}

	@Override
	public boolean delete(int id) {
		productRepos.delete(id);
		return false;
	}

	@Override
	public void edit(Product product,int idCategoy, int idTrademark) {
		productRepos.edit(product, idCategoy, idTrademark);
	}

	@Override
	public Product findAProduct(int id) {
		return productRepos.findAProduct(id);
	}

	@Override
	public List<Product> findListProduct(String name) {
		return productRepos.findListProduct(name);
	}
}
