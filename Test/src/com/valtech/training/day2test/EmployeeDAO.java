package com.valtech.training.day2test;

import java.sql.SQLException;
import java.util.List;

public interface EmployeeDAO {

	Employeenew getEmployee(int id) throws SQLException;

	List<Employeenew> getAllEmployees() throws SQLException;

	void deleteEmployees(int id) throws SQLException;

	void UpdateEmployee(Employeenew emp) throws SQLException;

	void createEmployee(Employeenew emp) throws SQLException;
	
	public long count() throws SQLException;
	
	List<Employeenew> getEmployeesByDept(String department) throws SQLException;

	List<Employeenew> getEmpSalaryGreaterThanBySeniority(int salary, int seniority) throws SQLException;
	
	List<Employeenew> getEmpSalaryLessThanBySeniority(int salary, int seniority) throws SQLException;
	
	List<Employeenew> getEmpByAge(int minage,int maxage) throws SQLException;
	
	List<Employeenew> getEmpByLocation(String location) throws SQLException;
}