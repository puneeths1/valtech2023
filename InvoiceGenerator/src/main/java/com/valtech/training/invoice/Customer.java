package com.valtech.training.invoice;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "customers")
public class Customer {

    @Id
    @Column(name = "customer_id")
    private int customerId;

    private String name;

    private String phone;

    private String address;

    @OneToMany(mappedBy = "customer")
    private List<Order> orders = new ArrayList<>();

    // Add any other necessary fields and methods

    public Customer() {
        // Default constructor required by Hibernate
    }

    public Customer(int customerId, String name, String phone, String address) {
        this.customerId = customerId;
        this.name = name;
        this.phone = phone;
        this.address = address;
    }

	public int getCustomerId() {
		return customerId;
	}

	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public List<Order> getOrders() {
		return orders;
	}

	public void setOrders(List<Order> orders) {
		this.orders = orders;
	}

}
