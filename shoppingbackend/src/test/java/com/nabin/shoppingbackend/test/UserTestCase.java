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
	
	
//	@Test
//	public void testAdd() {
//		
//		user = new User();
//		user.setFirstName("Nabin");
//		user.setLastName("Thapa");
//		user.setEmail("nabinthapant@hotmail.com");
//		user.setPassword("nabin");
//		user.setContactNumber("123456789");
//		user.setRole("USER");
//		
//		//add the user
//		assertEquals("Failed to add the user!", true, userDAO.addUser(user));
//		
//		
//		address = new Address();
//		address.setAddressLineOne("sigana 4 Thapathar,Baglung");
//		address.setAddressLineTwo("Pokhara 11, Phoolbari Pokhara");
//		address.setCity("Baglung");
//		address.setState("Baglung");
//		address.setCountry("Nepal");
//		address.setPostalCode("977");
//		address.setBilling(true);
//		
//		//link the user with the address using user id
//		address.setUserId(user.getId());
//		
//		//add address 
//		assertEquals("Failed to add the address!", true,userDAO.addAddress(address));
//		
//		if(user.getRole().equals("USER")) {
//			//create a cart for this user
//			cart = new Cart();
//			cart.setUser(user);
//			
//			//add the cart
//			assertEquals("Failed to add cart!", true,userDAO.addCart(cart));
//			
//			//add a shipping address for this user
//			address = new Address();
//			address.setAddressLineOne("888 Bedford Texas");
//			address.setAddressLineTwo("Euless Texas");
//			address.setCity("Euless");
//			address.setState("Texas");
//			address.setCountry("USA");
//			address.setPostalCode("999");
//			//set shipping address true
//			address.setShipping(true);
//			//link it with the user
//			address.setUserId(user.getId());
//			
//			assertEquals("Failed to add Shipping address", true,userDAO.addAddress(address));
//		}
//		
//		
//		}
	
//	@Test
//	public void testAdd() {
//		
//		user = new User();
//		user.setFirstName("Nabin");
//		user.setLastName("Thapa");
//		user.setEmail("nabinthapant@hotmail.com");
//		user.setPassword("nabin");
//		user.setContactNumber("123456789");
//		user.setRole("USER");
//		
//		
//		
//		
//		
//		if(user.getRole().equals("USER")) {
//			//create a cart for this user
//			cart = new Cart();
//			cart.setUser(user);
//			//attach the cart with the user
//			user.setCart(cart);
//			
//			}
//		//add the user
//				assertEquals("Failed to add the user!", true, userDAO.addUser(user));
//		
//		}
	
//	@Test
//	public void updateCart() {
//		//fetching the user by its email
//		user = userDAO.getByEmail("nabinthapant@hotmail.com");
//		
//		//get cart of the user
//		cart = user.getCart();
//		cart.setCartLines(2);
//		cart.setGrandTotal(50000);
//		assertEquals("Failed to update the cart", true,userDAO.updateCart(cart));
//	}
	
//	@Test
//	public void testAddAddress() {
//		//we need to add an user
//		user = new User();
//		user.setFirstName("Nabin");
//		user.setLastName("Thapa");
//		user.setEmail("nabinthapant@hotmail.com");
//		user.setPassword("nabin");
//		user.setContactNumber("123456789");
//		user.setRole("USER");
//		
//		//add the user
//		assertEquals("Failed to add the user!", true, userDAO.addUser(user));
//		
//		//we are  going to add the address
//		address = new Address();
//		address.setAddressLineOne("sigana 4 Thapathar,Baglung");
//		address.setAddressLineTwo("Pokhara 11, Phoolbari Pokhara");
//		address.setCity("Baglung");
//		address.setState("Baglung");
//		address.setCountry("Nepal");
//		address.setPostalCode("977");
//		address.setBilling(true);
//		
//		//attach the user to the address
//		address.setUser(user);
//		
//		//add address 
//		assertEquals("Failed to add the address!", true,userDAO.addAddress(address));
//		
//		//we are going to add the shipping address
//		address = new Address();
//		address.setAddressLineOne("888 Bedford Texas");
//		address.setAddressLineTwo("Euless Texas");
//		address.setCity("Euless");
//		address.setState("Texas");
//		address.setCountry("USA");
//		address.setPostalCode("999");
//		//set shipping address true
//		address.setShipping(true);
//		
//		//attach the user to the address
//				address.setUser(user);
//				
//				//add shipping address 
//		assertEquals("Failed to add the shipping address!", true,userDAO.addAddress(address));
//		
//	}
	
//	@Test
//	public void testAddAddress() {
//		user = userDAO.getByEmail("nabinthapant@hotmail.com");
//		
//		//we are going to add the shipping address
//				address = new Address();
//				address.setAddressLineOne("999 SanJose California");
//				address.setAddressLineTwo("Los Angels California");
//				address.setCity("Los Angels");
//				address.setState("California");
//				address.setCountry("USA");
//				address.setPostalCode("777");
//				//set shipping address true
//				address.setShipping(true);
//				
//				//attach the user to the address
//						address.setUser(user);
//						
//						//add shipping address 
//				assertEquals("Failed to add the shipping address!", true,userDAO.addAddress(address));
//		
//	}
	@Test
	public void testGetAddresses() {
		
		user = userDAO.getByEmail("nabinthapant@hotmail.com");
		
		assertEquals("Failed to fetch the list of address and size  does not match!", 2,userDAO.listShippingAddresses(user).size());
		
		assertEquals("Failed to fetch the billing address ", "Baglung",userDAO.getBillingAddress(user).getCity());
	}
	
	

}
