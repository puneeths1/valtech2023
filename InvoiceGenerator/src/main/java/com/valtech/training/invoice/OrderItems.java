package com.valtech.training.invoice;

public class OrderItems {
	private int orderID;
	private int productID;
	private int productQuantity;
	public OrderItems() {
		super();
		// TODO Auto-generated constructor stub
	}
	public OrderItems(int orderID, int productID, int productQuantity) {
		super();
		this.orderID = orderID;
		this.productID = productID;
		this.productQuantity = productQuantity;
	}
	public int getOrderID() {
		return orderID;
	}
	public void setOrderID(int orderID) {
		this.orderID = orderID;
	}
	public int getProductID() {
		return productID;
	}
	public void setProductID(int productID) {
		this.productID = productID;
	}
	public int getProductQuantity() {
		return productQuantity;
	}
	public void setProductQuantity(int productQuantity) {
		this.productQuantity = productQuantity;
	}
}
