package com.valtech.training.invoice;

public class Company {
	private int companyID;
	private String companyName;
	private String companyAddress;
	public Company() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Company(String companyName, String companyAddress) {
		super();
//		this.companyID = companyID;
		this.companyName = companyName;
		this.companyAddress = companyAddress;
	}
	public int getCompanyID() {
		return companyID;
	}
	public void setCompanyID(int companyID) {
		this.companyID = companyID;
	}
	public String getCompanyName() {
		return companyName;
	}
	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}
	public String getCompanyAddress() {
		return companyAddress;
	}
	public void setCompanyAddress(String companyAddress) {
		this.companyAddress = companyAddress;
	}
}
