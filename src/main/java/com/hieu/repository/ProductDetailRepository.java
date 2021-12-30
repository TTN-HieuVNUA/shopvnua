package com.hieu.repository;

import java.io.File;
import java.io.FileNotFoundException;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

import javax.persistence.Persistence;
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

import com.hieu.bean.Account;
import com.hieu.bean.Category;
import com.hieu.bean.Employee;
import com.hieu.bean.Product;
import com.hieu.bean.ProductDetail;
import com.hieu.repository.inter.AccountRepos;
import com.hieu.repository.inter.ProductDetailRepos;
import com.hieu.repository.inter.ProductRepos;

@Repository
@Transactional
public class ProductDetailRepository implements ProductDetailRepos {

	@Autowired
	private SessionFactory sessionFactory;

	@Autowired
	private ProductRepos productRepos;

	@Autowired
	private AccountRepos accountRepos;

	@Override
	public boolean add(ProductDetail productDetail, Product product, String username) {
		try {
			Session session = sessionFactory.getCurrentSession();
			Account account = accountRepos.findAccount(username);
			Employee employee = account.getEmployee();
			productDetail.setCreatedBy(employee);
			productDetail.setCreatedDate(new Timestamp(System.currentTimeMillis()));
			productDetail.setProductid(product);
			session.save(productDetail);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	@Override
	public boolean delete(int id) {
		Session session = sessionFactory.getCurrentSession();
		ProductDetail pro = session.get(ProductDetail.class, id);
		session.delete(pro);
		return false;
	}

	@Override
	public ProductDetail findAprProductDetail(int id) {
		Session session = sessionFactory.getCurrentSession();
		ProductDetail productDetail = session.get(ProductDetail.class, id);
		return productDetail;
	}

	@Override
	public void edit(ProductDetail productDetail, String username) {
		Session session = sessionFactory.getCurrentSession();
		Account account = accountRepos.findAccount(username);
		Employee employee = account.getEmployee();
		ProductDetail proDetail = session.get(ProductDetail.class, productDetail.getId());
		proDetail.setModifiedBy(employee);
		proDetail.setColor(productDetail.getColor());
		proDetail.setImage(productDetail.getImage());
		proDetail.setPrice(productDetail.getPrice());
		proDetail.setQuantity(productDetail.getQuantity());
		proDetail.setModifiedDate(new Timestamp(System.currentTimeMillis()));
		session.update(proDetail);
	}

	@Override
	public boolean add(ProductDetail productDetail, int idproduct, String username) {
		Session session = sessionFactory.getCurrentSession();
		Account account = accountRepos.findAccount(username);
		Employee employee = account.getEmployee();
		productDetail.setCreatedBy(employee);
		Product product = productRepos.findAProduct(idproduct);
		productDetail.setProductid(product);
		productDetail.setCreatedDate(new Timestamp(System.currentTimeMillis()));
		session.save(productDetail);
		return false;
	}

	@Override
	public List<ProductDetail> getListProductDetail() {
		Session session = sessionFactory.getCurrentSession();
		List<ProductDetail> list = new ArrayList<ProductDetail>();
		Query query = session.createQuery("FROM ProductDetail");
		list = query.getResultList();
		return list;
	}

	@Override
	public List<ProductDetail> findListProductDetail(String name) {
		Session session = sessionFactory.getCurrentSession();
		List<Product> listProduct = new ArrayList<Product>();
		List<ProductDetail> listprodetail = new ArrayList<ProductDetail>();
		listProduct = productRepos.findListProduct(name);
		for (int i = 0; i < listProduct.size(); i++) {
			listprodetail.addAll(listProduct.get(i).getProductDetaillist());
		}
		return listprodetail;
	}

	@Override
	public ProductDetail findAProductDetail(int id) {
		Session session = sessionFactory.getCurrentSession();
		ProductDetail productDetail = new ProductDetail();
		productDetail = session.get(ProductDetail.class, id);
		return productDetail;
	}

	@Override
	public List<ProductDetail> getProductDetalByIdProduct(int idOfProduct) {
		Session session = sessionFactory.getCurrentSession();
		CriteriaBuilder builder = session.getCriteriaBuilder();
		CriteriaQuery<ProductDetail> query = builder.createQuery(ProductDetail.class);
		Root<ProductDetail> pdroot = query.from(ProductDetail.class);
		Root<Product> proot = query.from(Product.class);

		query.select(pdroot);
		Predicate p1 = builder.equal(proot.get("id"), pdroot.get("productid"));
		Predicate p2 = builder.equal(proot.get("id"), idOfProduct);
		query = query.where(builder.and(p1, p2));

		Query q = session.createQuery(query);
		return q.getResultList();
	}

	// get product by pathvariable
	@Override
	public List<ProductDetail> getListProduct(String subString) {
		Session session = sessionFactory.getCurrentSession();
		CriteriaBuilder builder = session.getCriteriaBuilder();
		CriteriaQuery<ProductDetail> query = builder.createQuery(ProductDetail.class);
		Root<ProductDetail> pdroot = query.from(ProductDetail.class);
		Root<Product> proot = query.from(Product.class);
		Root<Category> croot = query.from(Category.class);

		query.select(pdroot);
		Predicate p1 = builder.equal(pdroot.get("productid"), proot.get("id"));
		Predicate p2 = builder.equal(proot.get("categoryid"), croot.get("id"));
		Predicate p3 = builder.like(croot.get("name"), "%" + subString + "%");
		Predicate p4 = builder.between(pdroot.get("createdDate"),
				new Timestamp(System.currentTimeMillis() - (1000*60*60*24*90L)),
				new Timestamp(System.currentTimeMillis()));
		if (!subString.equals("")) {
			query = query.where(builder.and(p1, p2, p3));
		} else if (subString.equals("")) {
			query = query.where(builder.and(p1, p2, p4));
		}
		Query q = session.createQuery(query);
		return q.getResultList();
	}

	@Override
	public List<ProductDetail> getListProduct(int page, String requesParam) {
		Session session = sessionFactory.getCurrentSession();
		CriteriaBuilder builder = session.getCriteriaBuilder();
		CriteriaQuery<ProductDetail> query = builder.createQuery(ProductDetail.class);
		Root<ProductDetail> root = query.from(ProductDetail.class);
		
		query.select(root);
		if (!requesParam.equals("") && !requesParam.equalsIgnoreCase("new")) {
			Root<Product> proot = query.from(Product.class);
			Root<Category> croot = query.from(Category.class);
			Predicate p1 = builder.equal(root.get("productid"), proot.get("id"));
			Predicate p2 = builder.equal(proot.get("categoryid"), croot.get("id"));
			Predicate p3 = builder.like(croot.get("name"), "%"+requesParam+"%");
			query = query.where(builder.and(p1,p2,p3));
		}
		if (requesParam.equalsIgnoreCase("new")) {
			Predicate p1 = builder.between(root.get("createdDate"), 
					new Timestamp(System.currentTimeMillis() - (1000*60*60*24*90L)), 
					new Timestamp(System.currentTimeMillis()));
			query = query.where(p1);
		}
		Query q = session.createQuery(query);
		return q.setFirstResult(6*(page-1)).setMaxResults(6).getResultList();
	}

	@Override
	public int getNumberOfPage(String requesParam) {
		Session session = sessionFactory.getCurrentSession();
		CriteriaBuilder builder = session.getCriteriaBuilder();
		CriteriaQuery<Object> query = builder.createQuery(Object.class);
		Root<ProductDetail> root = query.from(ProductDetail.class);
		
		query.multiselect(builder.count(root.get("id").as(Integer.class)));
		
		if (!requesParam.equals("no") && !requesParam.equalsIgnoreCase("new")) {
			Root<Category> croot = query.from(Category.class);
			Root<Product> proot = query.from(Product.class);
			Predicate p = builder.equal(root.get("productid"), proot.get("id"));
			Predicate p1 = builder.equal(proot.get("categoryid"), croot.get("id"));
			Predicate p2 = builder.like(croot.get("name"), "%"+requesParam+"%");
			query = query.where(builder.and(p, p1,p2));
		}
		
		else if (requesParam.equalsIgnoreCase("new") && !requesParam.equals("no")) {
			Predicate p = builder.between(root.get("createdDate"),
					new Timestamp(System.currentTimeMillis() - (1000*60*60*24*90L)),
					new Timestamp(System.currentTimeMillis()));
			query = query.where(p);
		}
		
		Query q = session.createQuery(query);
		Object obj = q.getSingleResult();
		String s = String.valueOf(obj);
		int numberOfProduct = Integer.valueOf(s);
		float numberOfPage = (float)numberOfProduct/6;
		if (numberOfPage == (int)numberOfPage) {
			return (int)numberOfPage;
		}
		else {
			return ((int)numberOfPage+1);
		}
	}
	
}
