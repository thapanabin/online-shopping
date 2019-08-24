package com.nabin.shoppingbackend.dao;

import com.nabin.shoppingbackend.dto.Address;
import com.nabin.shoppingbackend.dto.Cart;
import com.nabin.shoppingbackend.dto.User;

public interface UserDAO {
	
	//add an user
	boolean addUser(User user);
	
	//add an address
	boolean addAddress(Address address);
	
	//add a cart
	boolean addCart(Cart cart);

}
