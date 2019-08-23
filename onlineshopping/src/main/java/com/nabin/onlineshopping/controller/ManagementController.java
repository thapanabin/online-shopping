package com.nabin.onlineshopping.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import javax.xml.ws.BindingType;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.config.MvcNamespaceHandler;

import com.nabin.onlineshopping.util.FileUploadUtility;
import com.nabin.onlineshopping.validator.ProductValidator;
import com.nabin.shoppingbackend.dao.CategoryDAO;
import com.nabin.shoppingbackend.dao.ProductDAO;
import com.nabin.shoppingbackend.dto.Category;
import com.nabin.shoppingbackend.dto.Product;

@Controller
@RequestMapping("/manage")
public class ManagementController {
	
	private static final Logger logger = LoggerFactory.getLogger(ManagementController.class);

	@Autowired
	CategoryDAO categoryDAO;

	@Autowired
	ProductDAO productDAO;

	@RequestMapping(value = "/products", method = RequestMethod.GET)
	public ModelAndView showManageProducts(@RequestParam(name = "operation",required = false) String operation) {
		ModelAndView mv = new ModelAndView("page");

		mv.addObject("userClickManageProducts", true);

		mv.addObject("title", "Manage Products");
		Product nProduct = new Product();

		// set some fields
		nProduct.setSupplierId(1);
		nProduct.setActive(true);
		mv.addObject("product", nProduct);
		if(operation !=null) {
			if(operation.equals("product")) {
				mv.addObject("message", "Product Submitted Successfully");
			}
		}

		return mv;
	}

	// handling the product Submission
	@RequestMapping(value = "/products", method = RequestMethod.POST)
	public String handleProductSubmission(@Valid @ModelAttribute("product") Product mproduct,BindingResult results,Model model,HttpServletRequest request) {
		//handle image validation for new product
				if(mproduct.getId() ==0) {
					new ProductValidator().validate(mproduct, results);
					
				}else {
					if(!mproduct.getFile().getOriginalFilename().equals("")) {
						new ProductValidator().validate(mproduct, results);

					}
				}
		
		
		//check if there are any errors
		if(results.hasErrors()) {
			
			model.addAttribute("userClickManageProducts", true);
			model.addAttribute("title", "ManageProducts");
			model.addAttribute("message", "Validation failed for product");
			return "page";
		}
		logger.info(mproduct.toString());
		
		
		
		if(mproduct.getId() ==0) {
			//create a new product if id is 0
			productDAO.addProduct(mproduct);
			}
		else {
			//update the product if id is not zero
			productDAO.updateProduct(mproduct);
		}
		productDAO.addProduct(mproduct);
		if(!mproduct.getFile().getOriginalFilename().equals("")) {
			FileUploadUtility.uploadFile(request,mproduct.getFile(),mproduct.getCode());
		}
		
		
		return "redirect:/manage/products?operation=product";
	}
	
	//for editing the product
	@RequestMapping(value = "/{id}/product",method = RequestMethod.GET)
	public ModelAndView showEditProduct(@PathVariable int id) {
		ModelAndView mv = new ModelAndView("page");
		mv.addObject("userClickManageProducts", true);
		mv.addObject("title", "Manage Products");
		//fetch the product from the database
		Product nproduct = productDAO.getProduct(id);
		//set the product fetch from the database
		mv.addObject("product", nproduct);
		return mv;
	}
	

	// returning categories for all the request mapping
	@ModelAttribute("categories")
	public List<Category> getCategories() {
		return categoryDAO.list();
	}
}
