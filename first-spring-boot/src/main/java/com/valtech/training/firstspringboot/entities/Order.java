package com.valtech.training.firstspringboot.entities;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "Orders")

public class Order {
	
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	private String item;
	private int itemCount;
	private String description;
	private LocalDate orderDate;
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getItem() {
		return item;
	}
	public void setItem(String item) {
		this.item = item;
	}
	public int getItemCount() {
		return itemCount;
	}
	public void setItemCount(int count) {
		this.itemCount = count;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public LocalDate getOrderDate() {
		return orderDate;
	}
	public void setOrderDate(LocalDate orderDate) {
		this.orderDate = orderDate;
	}
	public Order() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Order(String item, int count, String description, LocalDate orderDate) {
		super();
		this.item = item;
		this.itemCount = count;
		this.description = description;
		this.orderDate = orderDate;
	}
	public Order(long id, String item, int count, String description, LocalDate orderDate) {
		super();
		this.id = id;
		this.item = item;
		this.itemCount = count;
		this.description = description;
		this.orderDate = orderDate;
	}

}
