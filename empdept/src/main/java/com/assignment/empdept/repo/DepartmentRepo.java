<<<<<<< HEAD
package com.assignment.empdept.repo;

import org.springframework.stereotype.Repository;

import com.assignment.empdept.entities.Department;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

@Repository
public interface DepartmentRepo extends JpaRepository<Department, Integer>{
	
	@Query(value = "SELECT MIN(id) FROM Department")
    int findMinId();

	@Query(value = "SELECT MAX(id) FROM Department")
	int findMaxId();
	
	@Query(value = "SELECT MIN(id) FROM Department WHERE id > ?1")
	int findNextId(int id);
	
	@Query(value = "SELECT MAX(id) FROM Department WHERE id < ?1")
	int findPreviousId(int id);
}
=======
package com.assignment.empdept.repo;

import org.springframework.stereotype.Repository;

import com.assignment.empdept.entities.Department;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

@Repository
public interface DepartmentRepo extends JpaRepository<Department, Integer>{
	
	@Query(value = "SELECT MIN(id) FROM Department")
    int findMinId();

	@Query(value = "SELECT MAX(id) FROM Department")
	int findMaxId();
	
	@Query(value = "SELECT MIN(id) FROM Department WHERE id > ?1")
	int findNextId(int id);
	
	@Query(value = "SELECT MAX(id) FROM Department WHERE id < ?1")
	int findPreviousId(int id);
}
>>>>>>> a091cbc497545d2386e9d4fc16d86297b673537d
