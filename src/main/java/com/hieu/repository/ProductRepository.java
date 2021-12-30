package com.hieu.repository;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.hieu.bean.Category;
import com.hieu.bean.Product;
import com.hieu.bean.ProductDetail;
import com.hieu.bean.TradeMark;
import com.hieu.repository.inter.CategoryRepos;
import com.hieu.repository.inter.ProductRepos;
import com.hieu.repository.inter.TrademarkRepos;
import com.hieu.service.inter.ProductDetailSv;

@Repository
@Transactional
public class ProductRepository implements ProductRepos{

	@Autowired
	private SessionFactory sessionFactory;
	
	@Autowired
	private CategoryRepos categoryRepos;
	
	@Autowired
	private TrademarkRepos trademarkRepos;
	
	@Override
	public List<Product> getLiProducts() {
		List<Product> arrayList = new ArrayList<Product>();
		Session session = sessionFactory.getCurrentSession();
		Query query = session.createQuery("FROM Product");
		arrayList = query.getResultList();
		return arrayList;
	}

	@Override
	public boolean add(Product product, int categoryId, int TradeMarkid) {
		Session session = sessionFactory.getCurrentSession();
		try {
			TradeMark tradeMark = session.get(TradeMark.class, TradeMarkid);
			Category category = session.get(Category.class, categoryId);
			product.setCategoryid(category);
			product.setTrademarkid(tradeMark);
			String name = product.getName().replaceAll("[!-/_:-?]+", "");
			product.setName(name);
			session.save(product);
			
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	@Override
	public boolean delete(int id) {
		Session session = sessionFactory.getCurrentSession();
		Product product = session.get(Product.class, id);
		session.delete(product);
		return false;
	}

	@Override
	public void edit(Product product, int idCategoy, int idTrademark) {
		Category category = categoryRepos.findCategory(idCategoy);
		TradeMark tradeMark = trademarkRepos.findTradeMark(idTrademark);
		Session session = sessionFactory.getCurrentSession();
		Product products = session.get(Product.class, product.getId());
		products.setName(product.getName());
		products.setCategoryid(category);
		products.setTrademarkid(tradeMark);
		session.update(products);
	}

	@Override
	public Product findAProduct(int id) {
		Session session = sessionFactory.getCurrentSession();
		Product product = session.get(Product.class, id);
		return product;
	}

	@Override
	public List<Product> findListProduct(String name) {
		Session session = sessionFactory.getCurrentSession();
		List<Product> listPro = new ArrayList<Product>();
		
		CriteriaBuilder builder = session.getCriteriaBuilder();
		CriteriaQuery<Product> query = builder.createQuery(Product.class);
		Root<Product> root = query.from(Product.class);
		String[] list = name.split(" ");
		StringBuilder stringBuilder = new StringBuilder("%");
		for (int i = 0; i < list.length; i++) {
			stringBuilder.append(list[i]).append("%");
		}
		Predicate p = builder.like(root.get("name").as(String.class), stringBuilder.toString());
		query.where(builder.and(p));
		Query q = session.createQuery(query);
		listPro = q.getResultList();
		System.out.println(""+listPro);
		return listPro;
	}

}
