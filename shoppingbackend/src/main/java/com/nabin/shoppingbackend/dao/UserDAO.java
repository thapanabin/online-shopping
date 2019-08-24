package com.nabin.shoppingbackend.dao;

import java.util.List;

import com.nabin.shoppingbackend.dto.Address;
import com.nabin.shoppingbackend.dto.Cart;
import com.nabin.shoppingbackend.dto.User;

public interface UserDAO {
	
	//add an user
	boolean addUser(User user);
	
	User getByEmail(String email);
	
	//add an address
	boolean addAddress(Address address);
	//Alternative
	// Address getBillingAddress(int userId)
	//List<Address> listShippingAddresses(int userId) when we pass User it will generate a lot of query so it will reduce the performance so 
	Address getBillingAddress(User user);
	List<Address> listShippingAddresses(User user);
	
	//add a cart
	boolean updateCart(Cart cart);

}
