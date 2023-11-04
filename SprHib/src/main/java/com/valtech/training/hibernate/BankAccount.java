package com.valtech.training.hibernate;


import javax.persistence.EmbeddedId;
import javax.persistence.Entity;

@Entity
public class BankAccount {
	
	@EmbeddedId
	private BankAccountID   id;
	private double balance;
	public BankAccountID getId() {
		return id;
	}
	public void setId(BankAccountID id) {
		this.id = id;
	}
	public double getBalance() {
		return balance;
	}
	public void setBalance(double balance) {
		this.balance = balance;
	}
	public BankAccount(BankAccountID id, double balance) {
		super();
		this.id = id;
		this.balance = balance;
	}
	public BankAccount() {
		super();
		// TODO Auto-generated constructor stub
	}
}
