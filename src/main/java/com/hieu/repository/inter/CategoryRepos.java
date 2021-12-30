package com.hieu.repository.inter;

import java.util.List;

import com.hieu.bean.Category;

public interface CategoryRepos {

	public List<Category> getlistCategories();
	
	public Category findCategory(int id);
}
