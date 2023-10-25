package com.valtech.training.day2test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Employee implements Comparable<Employee>{
	private int seniority;
	private int experience;
	private String name;
	private int age;
	private int salary;
	
	public Employee(int seniority,int experience,String name,int age,int salary) {
		this.seniority = seniority;
		this.experience = experience;
		this.name = name;
		this.age = age;
		this.salary = salary;
	}
	
	public int getSeniority() {
		return seniority;
	}
	public int getExperience() {
		return experience;
	}
	public String getName() {
		return name;
	}
	public int getAge() {
		return age;
	}
	public int getSalary() {
		return salary;
	}

	@Override
	public int compareTo(Employee otherEmployee) {
		// TODO Auto-generated method stub
		int seniorityComparison = Integer.compare(this.seniority,otherEmployee.seniority);
		if(seniorityComparison!=0) {
			return seniorityComparison;
		}
		
		int experienceComparison = Integer.compare(this.experience, otherEmployee.experience);
		if(experienceComparison!=0) {
			return experienceComparison;
		}
		
		return this.name.compareTo(otherEmployee.name);
		
	}
	
	@Override
	public String toString() {
		
		return "Employee\n"+"seniority="+seniority+",Experience="+experience+",Name="+name+",Age="+age+",Salary="+salary;
		
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<Employee> e = new ArrayList<>();
		e.add(new Employee(3,5,"ABC",27,75000));
		e.add(new Employee(2,4,"PQR",24,56000));
		e.add(new Employee(1,2,"XYZ",50,98000));
		
		Collections.sort(e);
		
		for(Employee ee:e) {
			System.out.println(ee);
		}

	}
	
	

}
