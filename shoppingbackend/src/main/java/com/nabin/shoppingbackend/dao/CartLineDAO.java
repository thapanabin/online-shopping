package com.nabin.shoppingbackend.dao;

import java.util.List;

import com.nabin.shoppingbackend.dto.Cart;
import com.nabin.shoppingbackend.dto.CartLine;

public interface CartLineDAO {
	public CartLine get(int id);
	public boolean add(CartLine cartLine);
	public boolean update(CartLine cartLine);
	public boolean delete(CartLine cartLine);
	public List<CartLine> list(int cartId);
	
	//other business method related to the cart lines
	public List<CartLine> listAvaiable(int cartId);
	public CartLine getByCartAndProduct(int cartId, int productId);
	
	//update  a cart
	boolean updateCart(Cart cart);
	

}
