package EmployeeManagement;

import java.sql.*;
import java.util.*;

public class DepartmentTable implements DepartmentDAO{
	
	static Scanner scn = new Scanner(System.in);
	
	
	@Override
	public int firstDept() throws SQLException {
		Connection conn = getConnection();
		PreparedStatement ps = conn.prepareStatement("SELECT MIN(DID) FROM DEPARTMENT");
		ResultSet rs = ps.executeQuery();
		if (rs.next()) {
			int id = rs.getInt(1);
			conn.close();
			return id;
		}
		return 0;
	}

	@Override
	public int lastDept() throws SQLException {
		Connection conn = getConnection();
		PreparedStatement ps = conn.prepareStatement("SELECT MAX(DID) FROM DEPARTMENT");
		ResultSet rs = ps.executeQuery();
		if (rs.next()) {
			int deptId = rs.getInt(1);
			conn.close();
			return deptId;
		}
		conn.close();
		return 0;
	}

	@Override
	public int nextDept(int did) throws SQLException {
		Connection conn = getConnection();
		PreparedStatement ps = conn.prepareStatement("SELECT MIN(DID) FROM DEPARTMENT WHERE DID > ?");
		ps.setInt(1, did);
		ResultSet rs = ps.executeQuery();
		if (rs.next()) {
			int id = rs.getInt(1);
			conn.close();
			return id == 0 ? firstDept() : id;
		}
		return 0;
	}

	@Override
	public int previousDept(int did) throws SQLException {
		Connection conn = getConnection();
		PreparedStatement ps = conn.prepareStatement("SELECT MAX(DID) FROM DEPARTMENT WHERE DID < ?");
		ps.setInt(1, did);
		ResultSet rs = ps.executeQuery();
		if (rs.next()) {
			did = rs.getInt(1);
			conn.close();
			return did == 0 ? lastDept() : did;
		}
		return 0;
	}

	public void deleteDepartment(int did) throws SQLException {

		Connection con = getConnection();
		PreparedStatement ps = con
				.prepareStatement("DELETE FROM DEPARTMENT WHERE ID=?");
		ps.setInt(1, did);
		int rowsUpdated = ps.executeUpdate();
		System.out.println("Rows Updated:" + rowsUpdated);
		con.close();

	}

	public void updateDepartment(Department dep) throws SQLException {

		Connection con = getConnection();
		PreparedStatement ps = con
				.prepareStatement("UPDATE EMPLOYEE SET DNAME = ?, DLOCATION = ? WHERE DID = ?");
		populatePreparedStatmentFromDepartment(dep, ps);
		ps.setInt(3, dep.getDid());
		int rowsUpdated = ps.executeUpdate();
		System.out.println("Rows update:" + rowsUpdated);
		con.close();

	}

	public void createDepartment(Department dep) throws SQLException {
		Connection con = getConnection();
		PreparedStatement ps = con
				.prepareStatement("INSERT INTO DEPARTMENT (DID,DNAME,DLOCATION) VALUES(?,?,?)");
		populatePreparedStatmentFromDepartment(dep, ps);
		int rowsUpdated = ps.executeUpdate();
		System.out.println("Rows update:" + rowsUpdated);
		con.close();

	}

	private void populatePreparedStatmentFromDepartment(Department dep, PreparedStatement ps) throws SQLException {
		ps.setInt(1, dep.getDid());
		ps.setString(2, dep.getDname());
		ps.setString(3, dep.getDlocation());
	
	}

	public List<Department> getAllDepartment() throws SQLException {

		Connection con = getConnection();
		PreparedStatement ps = con
				.prepareStatement("SELECT * FROM DEPARTMENT");
		ResultSet rs = ps.executeQuery();
		List<Department> deps = new ArrayList<>();
		while (rs.next()) {

			deps.add(mapRowToDepartment(rs));
		
		}

		con.close();
		return deps;

	}

	public Department getDepartment(int did) throws SQLException {

		Connection con = getConnection();
		PreparedStatement ps = con.prepareStatement("SELECT DID, DNAME,DLOCATION FROM DEPARTMENT WHERE DID=?");
		ps.setInt(1, did);
		ResultSet rs = ps.executeQuery();
		if (rs.next()) {

			Department d = mapRowToDepartment(rs);
			con.close();
			return d;

		} 
		else {

			System.out.println("No row with Id " + did + " found.");
			return null;

		}

	}
	
	public DepartmentJoin getEmployeeByDepartment(int did) throws SQLException {
		//"SELECT EID, NAME, AGE, EXPERIENCE, SENIORITY, SALARY, DID, DNAME,DLOCATION FROM EMPLOYEE JOIN DEPARTMENT USING (DID) WHERE DID=?"
		Connection con = getConnection();
		PreparedStatement ps = con
				.prepareStatement("SELECT EID, NAME, AGE, EXPERIENCE, SENIORITY, SALARY, DID, DNAME,DLOCATION FROM EMPLOYEE JOIN DEPARTMENT USING (DID) WHERE DID=?");
		ps.setInt(1, did);
		ResultSet rs = ps.executeQuery();
		if (rs.next()) {

			DepartmentJoin dj = mapRowToDepartmentEmp(rs);
			con.close();
			return dj;

		} 
		else {

			System.out.println("No row with Id " + did + " found.");
			return null;

		}

	}
	
	
	
	public List<GroupBy> getListofEmployeeinEachDepartment() throws SQLException {

		Connection con = getConnection();
		PreparedStatement ps = con
				.prepareStatement("SELECT DNAME, GROUP_CONCAT(NAME) FROM EMPLOYEE JOIN DEPARTMENT USING (DID) GROUP BY DNAME");
		ResultSet rs = ps.executeQuery();
		List<GroupBy> gb = new ArrayList<>();
		while (rs.next()) {

			gb.add(mapRowToDepartmentEachEmp(rs));
		
		}

		con.close();
		return gb;

	}


	private DepartmentJoin mapRowToDepartmentEmp(ResultSet rs) throws SQLException {

		DepartmentJoin dj = new DepartmentJoin();
		dj.setEid(rs.getInt(1));
		dj.setName(rs.getString(2));
		dj.setAge(rs.getInt(3));
		dj.setExperience(rs.getInt(4));
		dj.setSeniority(rs.getInt(5));
		dj.setSalary(rs.getInt(6));
		dj.setDid(rs.getInt(7));
		dj.setDname(rs.getString(8));
		dj.setDlocation(rs.getString(9));
		return dj;

	}
	
	private GroupBy mapRowToDepartmentEachEmp(ResultSet rs) throws SQLException {

		GroupBy g = new GroupBy();
		g.setDname(rs.getString(1));
		g.setName(rs.getString(2));
		return g;

	}
	
	private Department mapRowToDepartment(ResultSet rs) throws SQLException {

		Department d = new Department();
		d.setDid(rs.getInt(1));
		d.setDname(rs.getString(2));
		d.setDlocation(rs.getString(3));
		return d;

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

		return DriverManager.getConnection("jdbc:mysql://localhost:3306/valtech_2023", "root", "root");

	}

	public static void main(String[] args) throws SQLException {

		DepartmentDAO dao = new DepartmentTable();
		
	}

}