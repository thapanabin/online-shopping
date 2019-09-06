package com.nabin.shoppingbackend.test;

import static org.junit.Assert.assertEquals;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.nabin.shoppingbackend.dao.CartLineDAO;
import com.nabin.shoppingbackend.dao.ProductDAO;
import com.nabin.shoppingbackend.dao.UserDAO;
import com.nabin.shoppingbackend.dto.Cart;
import com.nabin.shoppingbackend.dto.CartLine;
import com.nabin.shoppingbackend.dto.Product;
import com.nabin.shoppingbackend.dto.User;

public class CartLineTestCase {
	private static AnnotationConfigApplicationContext context;
	
	private static CartLineDAO cartLineDAO = null;
	private static ProductDAO productDAO = null;
	private static UserDAO userDAO = null;
	
	private Product product = null;
	private User user = null;
	private Cart cart = null;
	private CartLine cartLine = null;
	
	
	@BeforeClass
	public static void init() {
		context = new AnnotationConfigApplicationContext();
		context.scan("com.nabin.shoppingbackend");
		context.refresh();
		productDAO = (ProductDAO) context.getBean("productDAO");
		userDAO = (UserDAO) context.getBean("userDAO");
		cartLineDAO = (CartLineDAO) context.getBean("cartLineDAO");
		
	}
	
	@Test
	public void testAddNewCartLine() {
		//get the user
		user = userDAO.getByEmail("rajanthapa@gmail.com");
		//fetch the cart
		cart = user.getCart();
		
		//get the product
		product = productDAO.getProduct(1);
		
		//create the new cartline
		cartLine = new CartLine();
		cartLine.setBuyingPrice(product.getUnitPrice());
		
		cartLine.setProductCount(cartLine.getProductCount()+1);
		cartLine.setTotal(cartLine.getProductCount()*product.getUnitPrice());
		cartLine.setCartId(cart.getId());
		cartLine.setAvaiable(true);
		cartLine.setProduct(product);
		
		assertEquals("Failed to add the cartLine", true, cartLineDAO.add(cartLine));
		
		//update the cart
		cart.setGrandTotal(cart.getGrandTotal()+cartLine.getTotal());
		cart.setCartLines(cart.getCartLines()+1);
		assertEquals("Failed to update the cart", true,cartLineDAO.updateCart(cart));
		
		
	}
	

}
