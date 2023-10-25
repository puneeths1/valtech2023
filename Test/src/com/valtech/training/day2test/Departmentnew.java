package com.valtech.training.day2test;

public class Departmentnew {
	
	private int d_id;
	private String d_name;
	private String location;
	private int ListOfEmp;
	
	

	public Departmentnew() {
		
	}

	public int getD_id() {
		return d_id;
	}

	public void setD_id(int d_id) {
		this.d_id = d_id;
	}

	public String getD_name() {
		return d_name;
	}

	public void setD_name(String d_name) {
		this.d_name = d_name;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public int getListOfEmp() {
		return ListOfEmp;
	}

	public void setListOfEmp(int listOfEmp) {
		ListOfEmp = listOfEmp;
	}
	

	public Departmentnew(int d_id, String d_name, String location, int listOfEmp) {
		super();
		this.d_id = d_id;
		this.d_name = d_name;
		this.location = location;
		this.ListOfEmp = listOfEmp;
	}

	@Override
	public String toString() {
		return "Department [d_id=" + d_id + ", d_name=" + d_name + ", location=" + location + ", ListOfEmp="
				+ ListOfEmp + "]";
	}

	

}
