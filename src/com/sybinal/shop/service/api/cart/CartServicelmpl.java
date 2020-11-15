package com.sybinal.shop.service.api.cart;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sybinal.shop.mapper.CartMapper;
import com.sybinal.shop.model.Cart;
import com.sybinal.shop.model.Product;

@Service
public class CartServicelmpl implements CartService{

	@Autowired 
	CartMapper cartMapper;
	
	@Override
	public Integer addCart(Cart cart) {
		// TODO Auto-generated method stub
		return cartMapper.addCart(cart);
	}

	@Override
	public Integer getCartCount(Cart cart) {
		// TODO Auto-generated method stub
		return cartMapper.getCartCount(cart);
	}

	@Override
	public Map<String, Object> getCart(Cart cart) {
		List<Product> products = new ArrayList<Product>();
		List<Cart> carts = cartMapper.getCart(cart);
		int price = 0;
		int quantity = 0;
		for (Cart c : carts) {
			products.add(c.getProduct());
			price+=c.getPrice();
			quantity+=c.getQuantity();
		}
		Map<String, Object> reqMap=new LinkedHashMap<>();
		reqMap.put("userId", cart.getUserId());
		reqMap.put("price", price);
		reqMap.put("quantity", quantity);
		reqMap.put("skuId", cart.getSkuId());
		reqMap.put("jsonData",cart.getJsonData());
		reqMap.put("optionValueKeyGroup",cart.getOptionValueKeyGroup());
		reqMap.put("productList", products);
		return reqMap;
	}

	@Override
	public Integer searchCart(Cart cart) {
		// TODO Auto-generated method stub
		return cartMapper.searchCart(cart);
	}

	@Override
	public Integer updateQuantity(Cart cart) {
		// TODO Auto-generated method stub
		return cartMapper.updateQuantity(cart);
	}

	@Override
	public void removeCart(Cart cart) {
		cartMapper.removeCart(cart);
	}

	@Override
	public void removeAllCart(Cart cart) {
		cartMapper.removeAllCart(cart);
		
	}

}
