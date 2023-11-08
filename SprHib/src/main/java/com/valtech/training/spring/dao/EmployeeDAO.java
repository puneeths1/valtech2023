package com.valtech.training.spring.dao;

import java.util.List;

import com.valtech.training.hibernate.Employee;

public interface EmployeeDAO {

	Employee saveEmployee(Employee emp);

	Employee loadEmployee(int empid);

	Employee updateEmployee(Employee emp);

	List<Employee> getAllEmployees();

	void deleteEmployee(Employee emp);

}