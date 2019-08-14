package com.nabin.shoppingbackend.dao;

import java.util.List;

import com.nabin.shoppingbackend.dto.Category;

public interface CategoryDAO {

	List<Category> list();
	Category get(int id);
}
