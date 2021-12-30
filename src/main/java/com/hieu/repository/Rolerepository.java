package com.hieu.repository;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Query;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.hieu.bean.Role;
import com.hieu.repository.inter.RoleRepos;

@Repository
public class Rolerepository implements RoleRepos{

	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public List<Role> getRole() {
		List<Role> arrayList = new ArrayList<Role>();
		Session session = sessionFactory.getCurrentSession();
		Query query = session.createQuery("from Role");
		arrayList = query.getResultList();
		return arrayList;
	}

}
