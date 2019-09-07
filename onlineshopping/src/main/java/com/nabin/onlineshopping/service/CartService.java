package com.nabin.onlineshopping.service;


import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nabin.onlineshopping.modle.UserModel;
import com.nabin.shoppingbackend.dao.CartLineDAO;
import com.nabin.shoppingbackend.dto.Cart;
import com.nabin.shoppingbackend.dto.CartLine;

@Service("cartService")
public class CartService {
	
	@Autowired
	private CartLineDAO cartLineDAO;
	
	@Autowired
	private HttpSession session;
	
	//returns the cart of the user who have logged in
	private Cart getCart() {
		return ((UserModel)session.getAttribute("userModel")).getCart();
	}
	
	//returns the entire cart line
	public List<CartLine> getCartLines(){
		return cartLineDAO.list(this.getCart().getId());
		}
	
	
	

}
