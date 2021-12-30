package com.hieu.repository;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Query;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.hieu.bean.Category;
import com.hieu.repository.inter.CategoryRepos;

@Repository
@Transactional
public class CategoryRepository implements CategoryRepos{

	@Autowired
	private SessionFactory sessionFactory;
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Category> getlistCategories() {
		List<Category> categorylist = new ArrayList<Category>();
		Session session = sessionFactory.getCurrentSession();
			Query query = session.createQuery("From Category");
			categorylist = query.getResultList();
		return categorylist;
	}

	@Override
	public Category findCategory(int id) {
		Session session = sessionFactory.getCurrentSession();
		Category category = session.get(Category.class, id);
		return category;
	}
	
	
	
}
