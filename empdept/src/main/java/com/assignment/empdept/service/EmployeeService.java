<<<<<<< HEAD
package com.assignment.empdept.service;

import java.util.List;

import com.assignment.empdept.entities.Department;
import com.assignment.empdept.entities.Employee;



public interface EmployeeService {

	Employee createEmployee(Employee emp);

	Employee updateEmployee(Employee emp);
	
	void deleteEmployee(int id);

	List<Employee> getAllEmployees();
	
	Employee getEmployee(int id);

	Department createDepartment(Department dep);

	Department updateDepartment(Department dep);

	List<Department> getAllDepartments();

	Department getDepartment(int id);
	
	int getFirstId();
	
	int getLastId();
	
	int getPreviousId(int id);
	
	int getNextId(int id);

	List<Employee> getAllEmployeesByDepartmentId(int did);

=======
package com.assignment.empdept.service;

import java.util.List;

import com.assignment.empdept.entities.Department;
import com.assignment.empdept.entities.Employee;



public interface EmployeeService {

	Employee createEmployee(Employee emp);

	Employee updateEmployee(Employee emp);
	
	void deleteEmployee(int id);

	List<Employee> getAllEmployees();
	
	Employee getEmployee(int id);

	Department createDepartment(Department dep);

	Department updateDepartment(Department dep);

	List<Department> getAllDepartments();

	Department getDepartment(int id);
	
	int getFirstId();
	
	int getLastId();
	
	int getPreviousId(int id);
	
	int getNextId(int id);

	List<Employee> getAllEmployeesByDepartmentId(int did);

>>>>>>> a091cbc497545d2386e9d4fc16d86297b673537d
}