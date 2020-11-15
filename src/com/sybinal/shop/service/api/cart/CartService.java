package com.sybinal.shop.service.api.cart;

import java.util.Map;

import com.sybinal.shop.model.Cart;

public interface CartService {

	public Integer addCart(Cart cart);

	public Integer getCartCount(Cart cart);

	public Map<String, Object> getCart(Cart cart);
	
	public Integer searchCart(Cart cart);
	
	public Integer updateQuantity(Cart cart);
	
	public void removeCart(Cart cart);
	
	public void removeAllCart(Cart cart);
}
