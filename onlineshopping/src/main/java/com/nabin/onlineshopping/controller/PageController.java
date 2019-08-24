package com.nabin.onlineshopping.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.nabin.onlineshopping.exception.ProductNotFoundException;
import com.nabin.shoppingbackend.dao.CategoryDAO;
import com.nabin.shoppingbackend.dao.ProductDAO;
import com.nabin.shoppingbackend.dto.Category;
import com.nabin.shoppingbackend.dto.Product;

@Controller
public class PageController {
	private static final Logger logger = LoggerFactory.getLogger(PageController.class);
	@Autowired
	private CategoryDAO categoryDAO;
	
	@Autowired
	private ProductDAO productDAO;
	
	@RequestMapping(value = {"/", "/home","/index"})
	public ModelAndView index() {
		ModelAndView mv = new ModelAndView("page");
		mv.addObject("title","Home");
		logger.info("Inside PageController index method - INFO");
		logger.debug("Inside PageController index method -DEBUG");
		mv.addObject("categories", categoryDAO.list());
		mv.addObject("userClickHome",true);
		
		return mv;
	}
	@RequestMapping(value = "/about")
	public ModelAndView about() {
		ModelAndView mv = new ModelAndView("page");
		mv.addObject("title", "About Us");
		mv.addObject("userClickAbout", true);
		return mv;
	}
	
	@RequestMapping(value = "/contact")
	public ModelAndView contact() {
		ModelAndView mv = new ModelAndView("page");
		mv.addObject("title", "Contact Us");
		mv.addObject("userClickContact", true);
		return mv;
	}
	//method to load all the product
	@RequestMapping(value = "/show/all/products")
	public ModelAndView showAllProducts() {
		ModelAndView mv = new ModelAndView("page");
		mv.addObject("title", "All Products");
		mv.addObject("products", productDAO.listProducts());
		mv.addObject("userClickViewProducts", true);
		return mv;
	}
	
	//method to load all the products based on category
	@RequestMapping(value = "/show/category/{id}/products")
	public ModelAndView showCategoryProducts(@PathVariable("id") int id) {
		ModelAndView mv = new ModelAndView("page");
		//category to fetch the single category products
		Category category = null;
		category = categoryDAO.get(id);
		mv.addObject("title", category.getName());
		//passing the list of categories
		mv.addObject("categories", categoryDAO.list());
		//passing the single category
		mv.addObject("category", category);
		mv.addObject("userClickCategoryProducts",true);
		return mv;
		
	}
	
	/*
	 * 
	 * Viewing the single product
	 */
	
@RequestMapping(value ="/show/{id}/product")
public ModelAndView showSingleProduct(@PathVariable int id) throws ProductNotFoundException {
	ModelAndView mv = new ModelAndView("page");
	Product product = productDAO.getProduct(id);
	if(product == null) {
		throw new ProductNotFoundException();
	}
	//update the views when user click on the view product
	product.setViews(product.getViews()+1);
	productDAO.updateProduct(product);
	mv.addObject("title", product.getName());
	mv.addObject("product", product);
	mv.addObject("userClickShowProduct", true);
	return mv;
}

@RequestMapping(value = "/register")
public ModelAndView register() {
	ModelAndView mv = new ModelAndView("page");
	mv.addObject("title", "All Products");
	
	return mv;
}
	
}
