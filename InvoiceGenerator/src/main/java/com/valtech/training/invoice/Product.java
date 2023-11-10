package com.valtech.training.invoice;

public class Product {
	private int productID;
	private String productName;
	private int manufacturerID;
	private float productAmount;
	public Product() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Product(String productName, int manufacturerID, float productAmount) {
		super();
		this.productName = productName;
		this.manufacturerID = manufacturerID;
		this.productAmount = productAmount;
	}
	public int getProductID() {
		return productID;
	}
	public void setProductID(int productID) {
		this.productID = productID;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public int getManufacturerID() {
		return manufacturerID;
	}
	public void setManufacturerID(int manufacturerID) {
		this.manufacturerID = manufacturerID;
	}
	public float getProductAmount() {
		return productAmount;
	}
	public void setProductAmount(float productAmount) {
		this.productAmount = productAmount;
	}
	
}
