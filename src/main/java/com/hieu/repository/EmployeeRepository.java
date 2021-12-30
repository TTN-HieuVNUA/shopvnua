package com.hieu.repository;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Query;
import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.hieu.bean.Employee;
import com.hieu.repository.inter.EmployeeRpos;

@Repository
@Transactional
public class EmployeeRepository implements EmployeeRpos{

	@Autowired
	private SessionFactory sessionFactory;
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Employee> getListEmployee() {
		Session session = sessionFactory.getCurrentSession();
		List<Employee> listEmp = new ArrayList<Employee>();
		Query query = session.createQuery("FROM Employee");
		listEmp = query.getResultList();
		return listEmp;
	}

}
