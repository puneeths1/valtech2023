package com.valtech.training.invoice;

public class Customer {
	private int customerID;
	private String customerName;
	private int customerPhone;
	private String customerAddress;
	public Customer() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Customer(int customerID, String customerName, int customerPhone, String customerAddress) {
		super();
		this.customerID = customerID;
		this.customerName = customerName;
		this.customerPhone = customerPhone;
		this.customerAddress = customerAddress;
	}
	public int getCustomerID() {
		return customerID;
	}
	public void setCustomerID(int customerID) {
		this.customerID = customerID;
	}
	public String getCustomerName() {
		return customerName;
	}
	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}
	public int getCustomerPhone() {
		return customerPhone;
	}
	public void setCustomerPhone(int customerPhone) {
		this.customerPhone = customerPhone;
	}
	public String getCustomerAddress() {
		return customerAddress;
	}
	public void setCustomerAddress(String customerAddress) {
		this.customerAddress = customerAddress;
	} 
	
}
