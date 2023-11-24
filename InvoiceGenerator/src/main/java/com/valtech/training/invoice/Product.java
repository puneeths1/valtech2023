package com.valtech.training.invoice;

import javax.persistence.*;

@Entity
@Table(name = "products")
public class Product {

    @Id
    @Column(name = "product_id")
    private int productId;

    private String name;

    private double cost;

    private double price;

    // Add any other necessary fields and methods

    public Product() {
        // Default constructor required by Hibernate
    }

    public Product(String name, double cost, double price) {
        this.name = name;
        this.cost = cost;
        this.price = price;
    }

	public int getProductId() {
		return productId;
	}

	public void setProductId(int productId) {
		this.productId = productId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getCost() {
		return cost;
	}

	public void setCost(double cost) {
		this.cost = cost;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public Product(int productId, String name, double cost, double price) {
		super();
		this.productId = productId;
		this.name = name;
		this.cost = cost;
		this.price = price;
	}

	 
}