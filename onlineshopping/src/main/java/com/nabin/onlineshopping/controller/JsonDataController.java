package com.nabin.onlineshopping.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.nabin.shoppingbackend.dao.ProductDAO;
import com.nabin.shoppingbackend.dto.Product;

@Controller
@RequestMapping("/json/data")
public class JsonDataController {
	
	@Autowired
	private ProductDAO productDAO;
	
	@RequestMapping("/all/products")
	@ResponseBody
	public List<Product> getAllProducts(){
		return productDAO.listActiveProducts();
		
	}
	
	@RequestMapping("admin/all/products")
	@ResponseBody
	public List<Product>getAllProductsForAdmin(){
		return productDAO.listProducts();
	}
	
	@RequestMapping("/category/{id}/products")
	@ResponseBody
	public List<Product>getProductByCategory(@PathVariable int id){
		return productDAO.listActiveProuductByCategory(id);
	}
	
	
	

}
