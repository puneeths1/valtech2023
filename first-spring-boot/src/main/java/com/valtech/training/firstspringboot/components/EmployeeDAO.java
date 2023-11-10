package com.valtech.training.firstspringboot.components;

import java.sql.SQLException;
import java.util.List;

public interface EmployeeDAO {

	Employeenew getEmployee(int id) ;

	List<Employeenew> getAllEmployees();

	void deleteEmployees(int id);

	void UpdateEmployee(Employeenew emp);

	void createEmployee(Employeenew emp) ;
	
	public long count();
	
//	List<Employeenew> getEmployeesByDept(String department) throws SQLException;
//
//	List<Employeenew> getEmpSalaryGreaterThanBySeniority(int salary, int seniority) throws SQLException;
//	
//	List<Employeenew> getEmpSalaryLessThanBySeniority(int salary, int seniority) throws SQLException;
//	
//	List<Employeenew> getEmpByAge(int minage,int maxage) throws SQLException;
//	
//	List<Employeenew> getEmpByLocation(String location) throws SQLException;
}