package com.nabin.shoppingbackend.test;

import static org.junit.Assert.assertEquals;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.nabin.shoppingbackend.dao.ProductDAO;
import com.nabin.shoppingbackend.dto.Product;

public class ProductTestCase {

	private static AnnotationConfigApplicationContext context;

	private static ProductDAO productDAO;

	private Product product;

	@BeforeClass
	public static void init() {
		context = new AnnotationConfigApplicationContext();
		context.scan("com.nabin.shoppingbackend");
		context.refresh();
		productDAO = (ProductDAO) context.getBean("productDAO");
	}

	/*@Test
	public void addProduct() {

		// create Operation
		product = new Product();
		product.setName("Oppo Selfie S53");
		product.setBrand("Oppo");
		product.setDescription("This is some description for oppo mobile phone");
		product.setUnitPrice(25000);
		product.setActive(true);
		product.setCategoryId(3);
		product.setSupplierId(3);
		assertEquals("something went wrong while inserting the new product!",true, productDAO.addProduct(product));

	}
	
	
	//reading and updating the category
	
	@Test
	public void updateProduct() {
		product = productDAO.getProduct(6);
		product.setDescription("This is Oppo Phone sponsored to nepal idol");
		assertEquals("something went wrong while updating the produt",true, productDAO.updateProduct(product));
	}
	
	
	//list product 
	@Test
	public void testListProduct() {
		assertEquals("Something went wrong while fetching the product",6 ,productDAO.listProducts().size());
	}
	
	// testing for getting individual product
	@Test
	public void testGetProduct() {
		assertEquals("Something went wrong while getching the individual product","Oppo Selfie S53",productDAO.getProduct(6).getName());
	}
	
	//testcases for deleting the product
	@Test
	public void testDeleteProduct() {
		product = productDAO.getProduct(6);
		assertEquals("Something went wrong while deleting the product",true, productDAO.deleteProduct(product));
	}
	
	*/
	
	@Test
	public void testCRUDProduct() {
		// create Operation
				product = new Product();
				product.setName("Oppo Selfie S53");
				product.setBrand("Oppo");
				product.setDescription("This is some description for oppo mobile phone");
				product.setUnitPrice(25000);
				product.setActive(true);
				product.setCategoryId(3);
				product.setSupplierId(3);
				assertEquals("something went wrong while inserting the new product!",true, productDAO.addProduct(product));
				
				//updating the product
				product = productDAO.getProduct(6);
				product.setDescription("This is Oppo Phone sponsored to nepal idol");
				assertEquals("something went wrong while updating the produt",true, productDAO.updateProduct(product));
				
				//getting the product by id
				assertEquals("Something went wrong while getching the individual product","Oppo Selfie S53",productDAO.getProduct(6).getName());
				
				//listing the products
				assertEquals("Something went wrong while fetching the product",6 ,productDAO.listProducts().size());
				
				//deleting the product
				product = productDAO.getProduct(6);
				assertEquals("Something went wrong while deleting the product",true, productDAO.deleteProduct(product));
	}
	//testcase for listing the active products
	
	@Test
	public void testListActiveProduct() {
		assertEquals("Something went wrong while fetching the active products",5, productDAO.listActiveProducts().size());
	}
	
	
	//testcase for listing the active product by category
	@Test
	public void testListActiveProductByCategory() {
		assertEquals("Something went wrong while fetching the active product by category",3, productDAO.listActiveProuductByCategory(3).size());
		assertEquals("Something went wrong while fetching the active product by category",2, productDAO.listActiveProuductByCategory(1).size());
	}
	
	@Test
	public void testGetLatestActiveProduct() {
	
		assertEquals("something went wrong while fetching the latest active product",3, productDAO.getLatestActiveProoducts(3).size());
		
	}
	
	
}
