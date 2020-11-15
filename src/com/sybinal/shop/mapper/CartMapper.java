package com.sybinal.shop.mapper;

import java.util.List;

import com.sybinal.shop.model.Cart;

public interface CartMapper {

	public Integer addCart(Cart cart);

	public Integer getCartCount(Cart cart);

	public List<Cart> getCart(Cart cart);
	
	public Integer searchCart(Cart cart);
	
	public Integer updateQuantity(Cart cart);
	
	public void removeCart(Cart	cart);
	
	public void removeAllCart(Cart	cart);
}
