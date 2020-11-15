package com.sybinal.shop.model;

public class InvoiceList {
	
	private Integer id;
	
	private String orderNum;
	
	private Integer receivingId;

	public Integer getReceivingId() {
		return receivingId;
	}

	public void setReceivingId(Integer receivingId) {
		this.receivingId = receivingId;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getOrderNum() {
		return orderNum;
	}

	public void setOrderNum(String orderNum) {
		this.orderNum = orderNum;
	}


	
	
}
