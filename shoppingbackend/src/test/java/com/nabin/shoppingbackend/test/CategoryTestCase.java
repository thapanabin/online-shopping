package com.nabin.shoppingbackend.test;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.nabin.shoppingbackend.dao.CategoryDAO;
import com.nabin.shoppingbackend.dto.Category;

public class CategoryTestCase {
	private static AnnotationConfigApplicationContext context;
	
	private static CategoryDAO categoryDAO;
	
	private Category category;
	
	@BeforeClass
	public static void init() {
		context = new AnnotationConfigApplicationContext();
		context.scan("com.nabin.shoppingbackend");
		context.refresh();
		categoryDAO = (CategoryDAO) context.getBean("categoryDAO");
		
	}
	/*
	@Test
	public void testAddCategory() {
		category = new Category();
		category.setName("Television");
		category.setDescription("This is Television  latest launch");
		category.setImageUrl("pro.png");
		assertEquals("Successfully added the category in the table", true, categoryDAO.addCategory(category));
		
	}
	
	
	@Test 
	public void testGetCategory() {
		category = categoryDAO.get(4);
		assertEquals("Successfully fetched the category","Television", category.getName());
	}
	
	
	@Test
	public void testUpdateCategory() {
		category = categoryDAO.get(4);
		category.setName("TV");
		assertEquals("Successfully updated single category in the table",true,categoryDAO.updateCategory(category));
	}
	
	
	@Test
	public void testDeleteCategory() {
		category  = categoryDAO.get(3);
		assertEquals("Successfully deleted the category",true,categoryDAO.deleteCategory(category));
	}
	
	
	@Test
	public void testgetAllCategories() {
		
		assertEquals("Successfully fetched the list of active categories",3, categoryDAO.list().size());
	}
*/
	
	@Test
	public void testCRUDCategory() {
		//Adding the category
		category = new Category();
		category.setName("Laptop");
		category.setDescription("This is Laptop  latest launch");
		category.setImageUrl("CAT_1.png");
		assertEquals("Successfully added the category in the table", true, categoryDAO.addCategory(category));
		
		category = new Category();
		category.setName("Television");
		category.setDescription("This is Television  latest launch");
		category.setImageUrl("CAT_2.png");
		assertEquals("Successfully added the category in the table", true, categoryDAO.addCategory(category));
		
		//fetching and updating the category
		category = categoryDAO.get(2);
		category.setName("TV");
		assertEquals("Successfully updated single category in the table",true,categoryDAO.updateCategory(category));
	
		//delete the category
		assertEquals("Successfully deleted the category",true,categoryDAO.deleteCategory(category));
		
		//fetching the list
		assertEquals("Successfully fetched the list of active categories",1, categoryDAO.list().size());
		
		
		
		
	}
}
