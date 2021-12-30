package com.hieu.repository;

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

import com.hieu.bean.Invoice;
import com.hieu.bean.InvoiceDetail;
import com.hieu.bean.Product;
import com.hieu.bean.ProductDetail;
import com.hieu.repository.inter.InvoiceDetailRepos;

@Repository
@Transactional
public class InvoiceDetailRepository implements InvoiceDetailRepos{

	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public String getBestSallingProduct(int month, int year) {
		Session session = sessionFactory.getCurrentSession();
		CriteriaBuilder builder = session.getCriteriaBuilder();
		CriteriaQuery<Object[]> query = builder.createQuery(Object[].class);
		
		Root<InvoiceDetail> IdRoot = query.from(InvoiceDetail.class);
		Root<Invoice> Iroot = query.from(Invoice.class);
		Root<ProductDetail> PdRoot = query.from(ProductDetail.class);
		Root<Product> PRoot = query.from(Product.class);
		
		query.multiselect(
				builder.sum(IdRoot.get("quantity").as(Integer.class)),
				PRoot.get("name").as(String.class)
				);
		
		Predicate p1 = builder.equal(builder.function("MONTH", Integer.class, Iroot.get("createdate")), month);
		Predicate p2 = builder.equal(builder.function("YEAR", Integer.class, Iroot.get("createdate")), year);
		Predicate p3 = builder.equal(IdRoot.get("invoiceid"), Iroot.get("id"));
		Predicate p4 = builder.equal(IdRoot.get("productDetailid"), PdRoot.get("id"));
		Predicate p5 = builder.equal(PdRoot.get("productid"), PRoot.get("id"));
		
		query = query.where(builder.and(p1,p2,p3,p4,p5));
		query = query.groupBy(IdRoot.get("productDetailid"));
		query = query.orderBy(builder.desc(builder.sum(IdRoot.get("quantity"))));
		
		Query q = session.createQuery(query);
		List<Object[]> kq = q.setMaxResults(1).getResultList();
		System.out.println(kq.get(0)[1].toString());
		try {
			return kq.get(0)[1].toString();
		} catch (Exception e) {
			return null;
		}
	}

	
}
