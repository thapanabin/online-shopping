package com.nabin.shoppingbackend.dao;

import java.util.List;

import com.nabin.shoppingbackend.dto.Category;

public interface CategoryDAO {

	Category get(int id);
	List<Category> list();
	boolean addCategory(Category category);
	boolean updateCategory(Category category);
	boolean deleteCategory(Category category);
}
