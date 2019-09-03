package com.nabin.onlineshopping.handler;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.binding.message.MessageBuilder;
import org.springframework.binding.message.MessageContext;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
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
	
	@Autowired
	private BCryptPasswordEncoder passwordEncoder;
	
public RegisterModle init() {
	return new RegisterModle();
}

public void addUser(RegisterModle registerModel,User user) {
	registerModel.setUser(user);
}

public void addBilling(RegisterModle registerModle,Address billing) {
	registerModle.setBilling(billing);
}

public String validateUser(User user, MessageContext error) {
	
	String transitionValue = "success";
	if(!(user.getPassword().equals(user.getConfirmPassword()))) {
		
		
		//checking if password matches confirm password
		error.addMessage(new MessageBuilder().error()
				.source("confirmPassword")
				.defaultText("Password does not match the Confirm Password")
				.build()
				);
		transitionValue = "failure";
	}
	
	//checking uniqueness of the email id
	
	if(userDAO.getByEmail(user.getEmail())!=null) {
		
		error.addMessage(new MessageBuilder()
				.error()
				.source("email")
				.defaultText("Email address already used!")
				.build()
				
				);
		
		transitionValue = "failure";
	}
	
	
	return transitionValue;
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
//encode the password
user.setPassword(passwordEncoder.encode(user.getPassword()));

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
