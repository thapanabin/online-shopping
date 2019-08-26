package com.nabin.onlineshopping.handler;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.nabin.onlineshopping.modle.RegisterModle;
import com.nabin.shoppingbackend.dao.UserDAO;
import com.nabin.shoppingbackend.dto.Address;
import com.nabin.shoppingbackend.dto.Cart;
import com.nabin.shoppingbackend.dto.User;

@Component
public class RegisterHandler {
	
	@Autowired
	private UserDAO userDAO;
	
public RegisterModle init() {
	return new RegisterModle();
}

public void addUser(RegisterModle registerModel,User user) {
	registerModel.setUser(user);
}

public void addBilling(RegisterModle registerModle,Address billing) {
	registerModle.setBilling(billing);
}

public String saveAll(RegisterModle registerModle) {
String transitionValue = "success";

//fetch the user
User user = registerModle.getUser();

if(user.getRole().equals("USER")) {
	Cart cart = new Cart();
	cart.setUser(user);
	user.setCart(cart);
}
//save the user
userDAO.addUser(user);

//get the address
Address billing = registerModle.getBilling();
billing.setUserId(user.getId());
billing.setBilling(true);

//save the address
userDAO.addAddress(billing);


return transitionValue;
}
}
