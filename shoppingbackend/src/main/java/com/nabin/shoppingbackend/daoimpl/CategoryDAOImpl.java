package com.nabin.shoppingbackend.daoimpl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.nabin.shoppingbackend.dao.CategoryDAO;
import com.nabin.shoppingbackend.dto.Category;

@Repository("categoryDAO")
public class CategoryDAOImpl implements CategoryDAO {
	private static List<Category> categories = new ArrayList<Category>();

	static {
		Category category = new Category();
		category.setId(1);
		category.setName("Television");
		category.setImageUrl("Cat1Image.jpg");
		category.setDescription("Thi is the oldest Television");
		category.setActive(true);
		categories.add(category);
		// addding second category
		category = new Category();
		category.setId(2);
		category.setName("Mobile");
		category.setDescription("This is the first phone launched");
		category.setImageUrl("Cat2Image.jpg");
		category.setActive(true);
		categories.add(category);
		// adding the third category
		category = new Category();
		category.setId(3);
		category.setName("Laptop");
		category.setDescription("This is the first laptop launched");
		category.setImageUrl("Cat3Image.jpg");
		category.setActive(true);
		categories.add(category);
	}

	@Override
	public List<Category> list() {
		return categories;
	}

	@Override
	public Category get(int id) {
		for (Category category : categories) {
			if (category.getId() == id) {
				return category;
			}
		}
		return null;
	}

}
