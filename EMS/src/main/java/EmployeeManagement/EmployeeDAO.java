package EmployeeManagement;

import java.sql.*;

import java.util.List;

public interface EmployeeDAO {

	void deleteEmployee(int eid) throws SQLException;

	void updateEmployee(Employee emp) throws SQLException;

	void createEmployee(Employee emp) throws SQLException;

	List<Employee> getAllEmployees() throws SQLException;

	Employee getEmployee(int eid) throws SQLException;

}