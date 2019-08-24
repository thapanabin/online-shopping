package com.nabin.shoppingbackend.test;

import static org.junit.Assert.assertEquals;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.nabin.shoppingbackend.dao.UserDAO;
import com.nabin.shoppingbackend.dto.Address;
import com.nabin.shoppingbackend.dto.Cart;
import com.nabin.shoppingbackend.dto.User;

public class UserTestCase {
	private static AnnotationConfigApplicationContext context;
	private static UserDAO userDAO;
	private User user = null;
	private Address address = null;
	private Cart cart = null;
	
	
	@BeforeClass
	public static void init() {
		context = new AnnotationConfigApplicationContext();
		context.scan("com.nabin.shoppingbackend");
		context.refresh();
		
		userDAO = (UserDAO) context.getBean("userDAO");
	}
	
	
	@Test
	public void testAdd() {
		
		user = new User();
		user.setFirstName("Nabin");
		user.setLastName("Thapa");
		user.setEmail("nabinthapant@hotmail.com");
		user.setPassword("nabin");
		user.setContactNumber("123456789");
		user.setRole("USER");
		
		//add the user
		assertEquals("Failed to add the user!", true, userDAO.addUser(user));
		
		
		address = new Address();
		address.setAddressLineOne("sigana 4 Thapathar,Baglung");
		address.setAddressLineTwo("Pokhara 11, Phoolbari Pokhara");
		address.setCity("Baglung");
		address.setState("Baglung");
		address.setCountry("Nepal");
		address.setPostalCode("977");
		address.setBilling(true);
		
		//link the user with the address using user id
		address.setUserId(user.getId());
		
		//add address 
		assertEquals("Failed to add the address!", true,userDAO.addAddress(address));
		
		if(user.getRole().equals("USER")) {
			//create a cart for this user
			cart = new Cart();
			cart.setUser(user);
			
			//add the cart
			assertEquals("Failed to add cart!", true,userDAO.addCart(cart));
			
			//add a shipping address for this user
			address = new Address();
			address.setAddressLineOne("888 Bedford Texas");
			address.setAddressLineTwo("Euless Texas");
			address.setCity("Euless");
			address.setState("Texas");
			address.setCountry("USA");
			address.setPostalCode("999");
			//set shipping address true
			address.setShipping(true);
			//link it with the user
			address.setUserId(user.getId());
			
			assertEquals("Failed to add Shipping address", true,userDAO.addAddress(address));
		}
		
		
		}

}
