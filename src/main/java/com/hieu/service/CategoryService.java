package com.hieu.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hieu.bean.Category;
import com.hieu.repository.inter.CategoryRepos;
import com.hieu.service.inter.CategorySv;

@Service
public class CategoryService implements CategorySv{

	@Autowired
	private CategoryRepos categoryRepos;
	
	/*
	 * get list category
	 */
	@Override
	public List<Category> getlistCategories() {
		return categoryRepos.getlistCategories();
	}

}
