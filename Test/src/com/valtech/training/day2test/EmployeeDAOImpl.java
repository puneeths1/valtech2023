package com.valtech.training.day2test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class EmployeeDAOImpl implements EmployeeDAO {
	
	@Override
	public Employeenew getEmployee(int id) throws SQLException {
		Connection conn = getConnection();
		PreparedStatement ps = conn.prepareStatement("SELECT * FROM EMPLOYEE WHERE ID=?");
		ps.setInt(1, id);
		ResultSet rs = ps.executeQuery();
		if(rs.next()) {
			Employeenew e = MapRowToEmployee(rs);
			conn.close();
			return e;
		}
			
		else{System.out.println("No row with id  = "+id+" found..");
		return null;
		}
	}

	private Employeenew MapRowToEmployee(ResultSet rs) throws SQLException {
		Employeenew e = new Employeenew();
		e.setId(rs.getInt(1));
		e.setName(rs.getString(2));
		e.setAge(rs.getInt(3));
		e.setExperience(rs.getInt(4));
		e.setSeniority(rs.getInt(5));
		e.setSalary(rs.getInt(6));
		return e;
	}
	static {
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	private Connection getConnection() throws SQLException {
		// TODO Auto-generated method stub
		return DriverManager.getConnection("jdbc:mysql://localhost:3306/valtech2023?useSSL=false", "root", "root");
	}

	@Override
	public List<Employeenew> getAllEmployees() throws SQLException{
		Connection conn = getConnection();
		PreparedStatement ps = conn.prepareStatement("SELECT ID,NAME,AGE,EXPERIENCE,SENIORITY,SALARY FROM EMPLOYEE;");
		ResultSet rs = ps.executeQuery();
		List<Employeenew> emps = new ArrayList<>();
		while(rs.next()) {
			emps.add(MapRowToEmployee(rs));
		}
		conn.close();
		return emps;
	}
	
	@Override
	public void deleteEmployees(int id) throws SQLException {
		Connection conn = getConnection();
		PreparedStatement ps = conn.prepareStatement("DELETE FROM EMPLOYEE WHERE ID = ?");
		ps.setInt(1, id);
		int rowsUpdated = ps.executeUpdate();
		System.out.println("Rows Updated"+rowsUpdated);
		conn.close();
	}
	@Override
	public void UpdateEmployee(Employeenew emp) throws SQLException {
		Connection conn = getConnection();
		PreparedStatement ps = conn.prepareStatement("UPDATE EMPLOYEE SET NAME = ?,AGE=?,EXPERIENCE=?,SENIORITY=?,SALARY=? WHERE ID =?");
		populatePreparedStatementFromEmployee(emp,ps);
		ps.setInt(6, emp.getId());
		int rowsUpdated = ps.executeUpdate();
		System.out.println("Rows Updated"+rowsUpdated);
		conn.close();
	}
	@Override
	public void createEmployee(Employeenew emp) throws SQLException {
		Connection conn = getConnection();
		PreparedStatement ps = conn.prepareStatement("INSERT INTO EMPLOYEE (NAME,AGE,EXPERIENCE,SENIORITY,SALARY) VALUES (?,?,?,?,?);");
		populatePreparedStatementFromEmployee(emp, ps);
		int rowsUpdated = ps.executeUpdate();
	System.out.println("Rows Updated"+rowsUpdated);
	conn.close();
	}

	private void populatePreparedStatementFromEmployee(Employeenew emp, PreparedStatement ps) throws SQLException {
		ps.setString(1, emp.getName());
		ps.setInt(2, emp.getAge());
		ps.setInt(3,emp.getExperience());
		ps.setInt(4, emp.getSeniority());
		ps.setInt(5, emp.getSalary());
	}
	
	public long count() throws SQLException{
		
		Connection conn = getConnection();
		PreparedStatement ps = conn.prepareStatement("SELECT COUNT(ID) FROM EMPLOYEE;");
		ResultSet rs = ps.executeQuery();
		rs.next();
//			return rs.getLong(1);
			
		
		conn.close();
		return rs.getLong(1);
	}
	
	
	public List<Employeenew> getEmployeesByDept(String department) throws SQLException {
	    Connection conn = getConnection();
	    PreparedStatement ps = conn.prepareStatement("SELECT * FROM EMPLOYEE WHERE DEPT_ID IN (SELECT DEPT_ID FROM DEPARTMENT WHERE DEPT_NAME =?)");
	    ps.setString(1, department);
	    ResultSet rs = ps.executeQuery();
	    List<Employeenew> emps = new ArrayList<>();
	    while (rs.next()) {
	        emps.add(MapRowToEmployee(rs));
	    }
	    conn.close();
	    return emps;
	}
	
	
	public List<Employeenew> getEmpSalaryGreaterThanBySeniority(int salary, int seniority) throws SQLException {
	    Connection conn = getConnection();
	    PreparedStatement ps = conn.prepareStatement("SELECT * FROM EMPLOYEE WHERE SALARY > ? AND SENIORITY = ?");
	    ps.setInt(1, salary);
	    ps.setInt(2, seniority);
	    ResultSet rs = ps.executeQuery();
	    List<Employeenew> emps = new ArrayList<>();
	    while (rs.next()) {
	        emps.add(MapRowToEmployee(rs));
	    }
	    conn.close();
	    return emps;
	}
	
	
	public List<Employeenew> getEmpSalaryLessThanBySeniority(int salary, int seniority) throws SQLException {
	    Connection conn = getConnection();
	    PreparedStatement ps = conn.prepareStatement("SELECT * FROM EMPLOYEE WHERE SALARY < ? AND SENIORITY = ?");
	    ps.setInt(1, salary);
	    ps.setInt(2, seniority);
	    ResultSet rs = ps.executeQuery();
	    List<Employeenew> emps = new ArrayList<>();
	    while (rs.next()) {
	        emps.add(MapRowToEmployee(rs));
	    }
	    conn.close();
	    return emps;
	}
	
	
	public List<Employeenew> getEmpByAge(int minage,int maxage) throws SQLException {
	    Connection conn = getConnection();
	    PreparedStatement ps = conn.prepareStatement("SELECT * FROM EMPLOYEE WHERE AGE = ? AND ?");
	    ps.setInt(1, minage);
	    ps.setInt(2, maxage);
	    ResultSet rs = ps.executeQuery();
	    List<Employeenew> emps = new ArrayList<>();
	    while (rs.next()) {
	        emps.add(MapRowToEmployee(rs));
	    }
	    conn.close();
	    return emps;
	}
	
	
	public List<Employeenew> getEmpByLocation(String location) throws SQLException {
	    Connection conn = getConnection();
	    PreparedStatement ps = conn.prepareStatement("SELECT * FROM EMPLOYEE WHERE DEPT_ID IN (SELECT DEPT_ID FROM DEPARTMENT WHERE  LOCATION = ?)");
	    ps.setString(1, location);
	    ResultSet rs = ps.executeQuery();
	    List<Employeenew> emps = new ArrayList<>();
	    while (rs.next()) {
	        emps.add(MapRowToEmployee(rs));
	    }
	    conn.close();
	    return emps;
	}





	
	public static void main(String[] args) throws SQLException {
		EmployeeDAO dao = new EmployeeDAOImpl();
//		System.out.println(dao.getEmployee(1));
//		System.out.println(dao.getEmployee(2));
//		dao.createEmployee(new Employeenew("uio",45,15,4,55000));
//		Employeenew ee = dao.getEmployee(3);
//		ee.setSeniority(5);
//		dao.UpdateEmployee(ee);
		
//		dao.deleteEmployees(3);
		System.out.println(dao.getEmployeesByDept("Development"));
		System.out.println(dao.getEmpByAge(20, 30));
//		System.out.println(dao.getEmpByLocation("Pune"));
//		System.out.println(dao.getAllEmployees());
//		System.out.println(dao.count());
	}
	
}
