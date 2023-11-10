package com.valtech.training.invoice;

import java.time.LocalDate;

public class Order {
	private int orderID;
	private int customerID;
	private LocalDate orderDate;
	public int getOrderID() {
		return orderID;
	}
	public void setOrderID(int orderID) {
		this.orderID = orderID;
	}
	public int getCustomerID() {
		return customerID;
	}
	public void setCustomerID(int customerID) {
		this.customerID = customerID;
	}
	public LocalDate getOrderDate() {
		return orderDate;
	}
	public void setOrderDate(LocalDate orderDate) {
		this.orderDate = orderDate;
	}
	public Order(int orderID, int customerID, LocalDate orderDate) {
		super();
		this.orderID = orderID;
		this.customerID = customerID;
		this.orderDate = orderDate;
	}
}
