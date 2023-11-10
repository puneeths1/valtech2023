package com.valtech.training.firstspringboot.components;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowCallbackHandler;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import com.valtech.training.firstspringboot.components.EmployeeDAOImpl.EmployeeRowMapper;

@Component
public class EmployeeDAOImpl implements EmployeeDAO {
	public class EmployeeRowMapper implements RowMapper<Employeenew> {

		@Override
		public Employeenew mapRow(ResultSet rs, int rowNum) throws SQLException {
			// TODO Auto-generated method stub
			Employeenew e = new Employeenew();
			e.setId(rs.getInt(1));
			e.setName(rs.getString(2));
			e.setAge(rs.getInt(3));
			e.setExperience(rs.getInt(4));
			e.setSeniority(rs.getInt(5));
			e.setSalary(rs.getInt(6));
			return e;
		}

	}

	@Autowired
	private DataSource dataSource;

	@Override
	public Employeenew getEmployee(int id) {

		String selectQry = "SELECT * FROM EMPLOYEE WHERE ID=?";
		return new JdbcTemplate(dataSource).queryForObject(selectQry, new EmployeeRowMapper());
	}

	@Override
	public List<Employeenew> getAllEmployees() {

		String selectQry = "SELECT ID,NAME,AGE,EXPERIENCE,SENIORITY,SALARY FROM EMPLOYEE;";
		return new JdbcTemplate(dataSource).query(selectQry, new EmployeeRowMapper());
	}

	@Override
	public void deleteEmployees(int id) {

		String deleteQry = "DELETE FROM EMPLOYEE WHERE ID = ?";
		new JdbcTemplate(dataSource).update(deleteQry, id);
	}

	@Override
	public void UpdateEmployee(Employeenew emp) {

		String updateQry = "UPDATE EMPLOYEE SET NAME = ?,AGE=?,EXPERIENCE=?,SENIORITY=?,SALARY=? WHERE ID =?";
		new JdbcTemplate(dataSource).update(updateQry, emp.getName(), emp.getAge(), emp.getExperience(),
				emp.getSeniority(), emp.getSalary(), emp.getId());
	}

	@Override
	public void createEmployee(Employeenew emp) {

		String createQry = "INSERT INTO EMPLOYEE (NAME,AGE,EXPERIENCE,SENIORITY,SALARY) VALUES (?,?,?,?,?);";
		new JdbcTemplate(dataSource).update(createQry, emp.getName(), emp.getAge(), emp.getExperience(),
				emp.getSeniority(), emp.getSalary());
	}

	public long count() {

		String countQry = "SELECT COUNT(ID) FROM EMPLOYEE";
		return new JdbcTemplate(dataSource).queryForObject(countQry, long.class);
	}

}
