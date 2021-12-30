package com.hieu.repository;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Join;
import javax.persistence.criteria.JoinType;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.hieu.bean.Customer;
import com.hieu.bean.Employee;
import com.hieu.bean.Invoice;
import com.hieu.repository.inter.InvoiceRepos;

@Repository
@Transactional
public class InvoiceRepositoty implements InvoiceRepos {

	@Autowired
	private SessionFactory sessionFactoy;

	private List<String> listRevenue = new ArrayList<String>();

	@Override
	public String getSumTotalMoney(int month, int year) {
		Session session = sessionFactoy.getCurrentSession();
		CriteriaBuilder builder = session.getCriteriaBuilder();
		CriteriaQuery<Object> query = builder.createQuery(Object.class);
		Root<Invoice> root = query.from(Invoice.class);

		query.multiselect(builder.sum(root.get("totalmoney").as(BigDecimal.class)));
		Predicate p1 = builder.equal(builder.function("MONTH", Integer.class, root.get("createdate")), month);
		Predicate p2 = builder.equal(builder.function("YEAR", Integer.class, root.get("createdate")), year);
		query.where(builder.and(p1, p2));
		Query q = session.createQuery(query);
		Object kq = (Object) q.getSingleResult();
		return String.valueOf(kq);
	}

	@Override
	public String getNameCustomer(int month, int year) {
		Session session = sessionFactoy.getCurrentSession();
		CriteriaBuilder builder = session.getCriteriaBuilder();
		CriteriaQuery<Object[]> query = builder.createQuery(Object[].class);

		Root<Invoice> root = query.from(Invoice.class);
		Root<Customer> croot = query.from(Customer.class);
		query.multiselect(builder.sum(root.get("totalmoney").as(BigDecimal.class)), croot.get("name").as(String.class));

		Predicate p1 = builder.equal(builder.function("MONTH", Integer.class, root.get("createdate")), month);
		Predicate p2 = builder.equal(builder.function("YEAR", Integer.class, root.get("createdate")), year);
		Predicate p3 = builder.equal(root.get("customerid"), croot.get("id"));
		query.where(builder.and(p1, p2, p3));

		query = query.groupBy(root.get("customerid"));
		query = query.orderBy(builder.desc(builder.sum(root.get("totalmoney"))));

		List<Object[]> customerNames = session.createQuery(query).setMaxResults(1).getResultList();
		try {
			return customerNames.get(0)[1].toString();
		} catch (Exception e) {
			return null;
		}
	}

	@Override
	public String getNameEmployee(int month, int year) {
		Session session = sessionFactoy.getCurrentSession();
		CriteriaBuilder builder = session.getCriteriaBuilder();
		CriteriaQuery<Object[]> query = builder.createQuery(Object[].class);

		Root<Invoice> Iroot = query.from(Invoice.class);
		Root<Employee> Eroot = query.from(Employee.class);

		query.multiselect(builder.sum(Iroot.get("totalmoney").as(BigDecimal.class)),
				Eroot.get("name").as(String.class));
		
		Predicate p1 = builder.equal(builder.function("MONTH", Integer.class, Iroot.get("createdate")), month);
		Predicate p2 = builder.equal(builder.function("YEAR", Integer.class, Iroot.get("createdate")), year);
		Predicate p3 = builder.equal(Iroot.get("employeeid"), Eroot.get("id"));
		
		query = query.where(builder.and(p1,p2,p3));
		query = query.groupBy(Iroot.get("employeeid"));
		query = query.orderBy(builder.desc(builder.sum(Iroot.get("totalmoney"))));
		
		Query q = session.createQuery(query);
		List<Object[]> kq = q.setMaxResults(1).getResultList();
		try {
			return kq.get(0)[1].toString();
		} catch (Exception e) {
			return null;
		}
	}

}
