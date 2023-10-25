package com.valtech.training.day2test;

import java.sql.SQLException;
import java.util.List;

public interface DepartmentDAO {
	
	Departmentnew getDept(int dept_id) throws SQLException;
	
	List<Departmentnew>  getAllDept() throws SQLException;
	
	void createDept(Departmentnew d) throws SQLException;
	void updateDept(Departmentnew d) throws SQLException;
	void deleteDept(int dept_id) throws SQLException;

//	void close();
	
	}
