package com.nabin.onlineshopping.modle;

import java.io.Serializable;

import com.nabin.shoppingbackend.dto.Address;
import com.nabin.shoppingbackend.dto.User;

public class RegisterModle implements Serializable {
/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
private User user;
private Address billing;
public User getUser() {
	return user;
}
public void setUser(User user) {
	this.user = user;
}
public Address getBilling() {
	return billing;
}
public void setBilling(Address billing) {
	this.billing = billing;
}
}
