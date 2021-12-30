package com.hieu.service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;
import com.hieu.bean.Product;
import com.hieu.bean.ProductDetail;
import com.hieu.repository.ProductDetailRepository;
import com.hieu.repository.inter.ProductDetailRepos;
import com.hieu.service.inter.ProductDetailSv;
import com.hieu.service.inter.ProductSv;

@Service
public class ProductDetailService implements ProductDetailSv{

	@Autowired
	private ProductDetailRepos productDetailRepos;
	
	@Autowired
	private ProductSv productSv;
	
	@Autowired
	private Cloudinary cloud;
	
	private ProductDetailRepository productDetailRepository = new ProductDetailRepository();
	
	@Override
	public boolean addOrUpdate(ProductDetail productDetail,Product product, String username) {
		try {
			Map r = this.cloud.uploader().upload(productDetail.getFile().getBytes(), 
					ObjectUtils.asMap("resource_type","auto"));
			String c = (String) r.get("secure_url");
			productDetail.setImage(c);
			String typefile = productDetail.getFile().getContentType().toString();
			if(typefile.equalsIgnoreCase("image/jpeg") || typefile.equalsIgnoreCase("image/png")) {
				productDetailRepos.add(productDetail,product, username);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public boolean delete(int id) {
		productDetailRepos.delete(id);
		return false;
	}

	@Override
	public ProductDetail findAprProductDetail(int id) {
		return productDetailRepos.findAprProductDetail(id);
	}

	@Override
	public void edit(ProductDetail productDetail, String username) {
		productDetailRepos.edit(productDetail, username);
	}

	@Override
	public String editImage(ProductDetail productDetail) {
		try {
			Map r = this.cloud.uploader().upload(productDetail.getFile().getBytes(), 
					ObjectUtils.asMap("resource_type","auto"));
			String c = (String) r.get("secure_url");
			return c;
		} catch (IOException e) {
			return null;
		}
	}

	@Override
	public boolean add(ProductDetail productDetail, int idproduct, String username) {
		try {
			Map r = this.cloud.uploader().upload(productDetail.getFile().getBytes(), 
					ObjectUtils.asMap("resource_type","auto"));
			String c = (String) r.get("secure_url");
			productDetail.setImage(c);
			productDetailRepos.add(productDetail,idproduct, username);
			return true;
		} catch (IOException e) {
			e.printStackTrace();
			return false;
		}
		
	}

	@Override
	public List<ProductDetail> getListProductDetail() {
		return productDetailRepos.getListProductDetail();
	}

	@Override
	public List<ProductDetail> findListProductDetail(String name) {
		return productDetailRepos.findListProductDetail(name);
	}

	@Override
	public ProductDetail findAProductDetail(int id) {
		return productDetailRepos.findAProductDetail(id);
	}

	@Override
	public List<ProductDetail> getListProductDetail(int idOfProduct) {
		return productDetailRepos.getProductDetalByIdProduct(idOfProduct);
	}

	@Override
	public List<ProductDetail> getListProductDetail(String subString) {
		return productDetailRepos.getListProduct(subString);
	}

	@Override
	public int getNumberOfPage(String requesParam) {
		return productDetailRepos.getNumberOfPage(requesParam);
	}

	@Override
	public List<ProductDetail> getListProductDetails(int page, String requesParam) {
		return productDetailRepos.getListProduct(page,requesParam);
	}

}
