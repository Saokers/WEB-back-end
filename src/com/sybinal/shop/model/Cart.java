package com.sybinal.shop.model;

import java.util.Date;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;

public class Cart {

	private String id;
	
	private int productId;
	
	private int userId;
	
	@DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss") 
	private Date createTime;
	
	@DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss") 
	private Date updateTime;

	private int quantity;
	
	private String optionValueKeyGroup;
		
	private int skuId;
	
	private int count;
	
	private int price;
	
	private Product product;
	
	private List<Cart>cartItemList;
	
	private String jsonData;
	
	
	public String getJsonData() {
		return jsonData;
	}
	public void setJsonData(String jsonData) {
		this.jsonData = jsonData;
	}
	public List<Cart> getCartItemList() {
		return cartItemList;
	}
	public void setCartItemList(List<Cart> cartItemList) {
		this.cartItemList = cartItemList;
	}
	
	public Product getProduct() {
		return product;
	}
	public void setProduct(Product product) {
		this.product = product;
	}
	public Date getUpdateTime() {
		return updateTime;
	}
	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}
	
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	public int getSkuId() {
		return skuId;
	}
	public void setSkuId(int skuId) {
		this.skuId = skuId;
	}
	public String getOptionValueKeyGroup() {
		return optionValueKeyGroup;
	}
	public void setOptionValueKeyGroup(String optionValueKeyGroup) {
		this.optionValueKeyGroup = optionValueKeyGroup;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public int getProductId() {
		return productId;
	}
	public void setProductId(int productId) {
		this.productId = productId;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public Date getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	@Override
	public String toString() {
		return "Cart [id=" + id + ", productId=" + productId + ", userId=" + userId + ", createTime=" + createTime
				+ ", updateTime=" + updateTime + ", quantity=" + quantity + ", optionValueKeyGroup="
				+ optionValueKeyGroup + ", skuId=" + skuId + ", count=" + count + ", price=" + price + ", product="
				+ product + ", cartItemList=" + cartItemList + "]";
	}
	
	
}
