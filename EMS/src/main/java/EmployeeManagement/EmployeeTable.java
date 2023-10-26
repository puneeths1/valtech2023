package EmployeeManagement;

import java.sql.*;
import java.util.*;

public class EmployeeTable implements EmployeeDAO {
	
	static Scanner scn = new Scanner(System.in);
	
	

	@Override
	public void deleteEmployee(int eid) throws SQLException {

		Connection con = getConnection();
		PreparedStatement ps = con.prepareStatement("DELETE FROM EMPLOYEE WHERE EID=?");
		ps.setInt(1, eid);
		int rowsUpdated = ps.executeUpdate();
		System.out.println("Rows Updated:" + rowsUpdated);
		con.close();

	}

	@Override
	public void updateEmployee(Employee emp) throws SQLException {

		Connection con = getConnection();
		PreparedStatement ps = con
				.prepareStatement("UPDATE EMPLOYEE SET NAME = ?, AGE = ?, EXPERIENCE = ?, SENIORITY = ?, SALARY = ?, DID = ? WHERE EID = ?");
		populatePreparedStatmentFromEmployee(emp, ps);
		ps.setInt(7, emp.getEid());
		int rowsUpdated = ps.executeUpdate();
		System.out.println("Rows update:" + rowsUpdated);
		con.close();

	}

	@Override
	public void createEmployee(Employee emp) throws SQLException {
		Connection con = getConnection();
		PreparedStatement ps = con.
				prepareStatement("INSERT INTO EMPLOYEE (NAME, AGE, EXPERIENCE, SENIORITY, SALARY, DID, EID) VALUES (?, ?, ?, ?, ?, ?, ?)");
		populatePreparedStatmentFromEmployee(emp, ps);
		int rowsUpdated = ps.executeUpdate();
		System.out.println("Rows update:" + rowsUpdated);
		con.close();

	}

	private void populatePreparedStatmentFromEmployee(Employee emp, PreparedStatement ps) throws SQLException {
		ps.setString(1, emp.getName());
		ps.setInt(2, emp.getAge());
		ps.setInt(3, emp.getExperience());
		ps.setInt(4, emp.getSeniority());
		ps.setInt(5, emp.getSalary());
		ps.setInt(6, emp.getDid());
		ps.setInt(7, emp.getEid());
	
	}

	public List<Employee> getAllEmployees() throws SQLException {

		Connection con = getConnection();
		PreparedStatement ps = con.prepareStatement("SELECT * FROM EMPLOYEE");
		ResultSet rs = ps.executeQuery();
		List<Employee> emps = new ArrayList<>();
		while (rs.next()) {

			emps.add(mapRowToEmployee(rs));
		
		}

		con.close();
		return emps;

	}

	public Employee getEmployee(int eid) throws SQLException {

		Connection con = getConnection();
		PreparedStatement ps = con.prepareStatement("SELECT EID,NAME,AGE,EXPERIENCE,SENIORITY,SALARY,DID FROM EMPLOYEE WHERE EID=?");
		ps.setInt(1, eid);
		ResultSet rs = ps.executeQuery();
		if (rs.next()) {

			Employee e = mapRowToEmployee(rs);
			con.close();
			return e;

		} 
		else {

			System.out.println("No row with Id " + eid + " found.");
			return null;

		}

	}
	
	

	private Employee mapRowToEmployee(ResultSet rs) throws SQLException {

		Employee e = new Employee();
		e.setEid(rs.getInt(1));
		e.setName(rs.getString(2));
		e.setAge(rs.getInt(3));
		e.setExperience(rs.getInt(4));
		e.setSeniority(rs.getInt(5));
		e.setSalary(rs.getInt(6));
		e.setDid(rs.getInt(7));
		return e;

	}

	static {

		try {

			Class.forName("com.mysql.jdbc.Driver");

		} 
		catch (ClassNotFoundException e) {

			e.printStackTrace();

		}

	}

	private Connection getConnection() throws SQLException {

		return DriverManager.getConnection("jdbc:mysql://localhost:3306/valtech_2023?useSSL = false&allowPublicKeyRetrieval=true", "root", "root");

	}

	public static void main(String[] args) throws SQLException {

		EmployeeDAO dao = new EmployeeTable();
		
	}
}