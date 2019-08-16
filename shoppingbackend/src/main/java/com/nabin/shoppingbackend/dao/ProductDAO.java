package com.nabin.shoppingbackend.dao;

import java.util.List;

import com.nabin.shoppingbackend.dto.Product;

public interface ProductDAO {

	Product getProduct(int productId);
	List<Product> listProducts();
	boolean addProduct(Product product);
	boolean updateProduct(Product product);
	boolean deleteProduct(Product product);
	
	//business methods
	List<Product> listActiveProducts();
	List<Product> listActiveProuductByCategory( int categoryId);
	List<Product> getLatestActiveProoducts(int count);
	
	
}
