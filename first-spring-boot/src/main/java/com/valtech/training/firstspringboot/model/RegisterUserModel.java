package com.valtech.training.firstspringboot.model;

public class RegisterUserModel {
	
	private String username;
	private String password;
	private String confirmPassword;
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getConfirmPassword() {
		return confirmPassword;
	}
	public void setConfirmPassword(String confirmPassword) {
		this.confirmPassword = confirmPassword;
	}
//	public RegisterUserModel() {
//		super();
//		// TODO Auto-generated constructor stub
//	}
//	public RegisterUserModel(String username, String password, String confirmPassword) {
//		super();
//		this.username = username;
//		this.password = password;
//		this.confirmPassword = confirmPassword;
//	}
}
