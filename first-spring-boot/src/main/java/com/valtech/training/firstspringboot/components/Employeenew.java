package com.valtech.training.firstspringboot.components;

public class Employeenew {
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getSeniority() {
		return seniority;
	}
	public void setSeniority(int seniority) {
		this.seniority = seniority;
	}
	public int getExperience() {
		return experience;
	}
	public void setExperience(int experience) {
		this.experience = experience;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public int getSalary() {
		return salary;
	}
	public void setSalary(int salary) {
		this.salary = salary;
	}
	private int id;
	private int seniority;
	private int experience;
	private String name;
	private int age;
	private int salary;
	public Employeenew() {
		
	}
	public Employeenew(int id,String name, int age,int experience,int seniority,int salary) {
		
		this.id = id;
		this.seniority = seniority;
		this.experience = experience;
		this.name = name;
		this.age = age;
		this.salary = salary;
	}
	
public Employeenew(String name, int age,int experience,int seniority,int salary) {
		
		
		this.seniority = seniority;
		this.experience = experience;
		this.name = name;
		this.age = age;
		this.salary = salary;
	}
	@Override
	public String toString() {
		return "Employeenew [id=" + id + ", seniority=" + seniority + ", experience=" + experience + ", name=" + name
				+ ", age=" + age + ", salary=" + salary + "]";
	}

}
