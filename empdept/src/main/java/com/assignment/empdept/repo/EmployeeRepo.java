<<<<<<< HEAD
package com.assignment.empdept.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.assignment.empdept.entities.Employee;



@Repository
public interface EmployeeRepo extends JpaRepository<Employee, Integer>{
	
	@Query(value = "SELECT E FROM Employee E WHERE did = ?1")
	List<Employee> findEmployeeByDepartmentId(int did);
	
}
=======
package com.assignment.empdept.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.assignment.empdept.entities.Employee;



@Repository
public interface EmployeeRepo extends JpaRepository<Employee, Integer>{
	
	@Query(value = "SELECT E FROM Employee E WHERE did = ?1")
	List<Employee> findEmployeeByDepartmentId(int did);
	
}
>>>>>>> a091cbc497545d2386e9d4fc16d86297b673537d
