package firstWeb;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;



public class EmployeeDAOImpl implements EmployeeDAO {
	
	static {
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public int firstID() throws SQLException {
		// TODO Auto-generated method stub
		Connection con = getConnection();
		PreparedStatement ps = con.prepareStatement("select min(id) from employee");
		ResultSet rs = ps.executeQuery();
		if(rs.next()) {
			int id= rs.getInt(1);
			con.close();
			return id;
		}
		return 0;
	}

	
	private Connection getConnection() throws SQLException {
			// TODO Auto-generated method stub
			return DriverManager.getConnection("jdbc:mysql://localhost:3306/valtech2023", "root", "root");
		}
	

	@Override
	public int lastID() throws SQLException {
		// TODO Auto-generated method stub
		Connection con = getConnection();
		PreparedStatement ps = con.prepareStatement("select max(id) from employee");
		ResultSet rs = ps.executeQuery();
		if(rs.next()) {
			int id= rs.getInt(1);
			con.close();
			return id;
		}
//		con.close();
		return 0;
	}
	

	@Override
	public int nextID(int id) throws SQLException {
		// TODO Auto-generated method stub
		Connection con = getConnection();
		PreparedStatement ps = con.prepareStatement("select min(id) from employee where id > ?");
		ps.setInt(1, id);
		ResultSet rs = ps.executeQuery();
		if(rs.next()) {
			id= rs.getInt(1);
			con.close();
//			return id;
		}
		con.close();
		return id==0?lastID():id;
	}

	@Override
	public int previousID(int id) throws SQLException {
		// TODO Auto-generated method stub
		Connection con = getConnection();
		PreparedStatement ps = con.prepareStatement("select max(id) from employee where id < ?");
		ps.setInt(1, id);
		ResultSet rs = ps.executeQuery();
		if(rs.next()) {
			id= rs.getInt(1);
			con.close();
//			return id;
		}
		con.close();
		return id == 0 ? firstID():id;
	
	}

	public Employee getEmployee(int id) throws SQLException {
		Connection conn = getConnection();
		PreparedStatement ps = conn.prepareStatement("SELECT * FROM EMPLOYEE WHERE ID=?");
		ps.setInt(1, id);
		ResultSet rs = ps.executeQuery();
		if(rs.next()) {
			Employee e = MapRowToEmployee(rs);
			conn.close();
			return e;
		}
			
		else{System.out.println("No row with id  = "+id+" found..");
		return null;
		}
	}

	private Employee MapRowToEmployee(ResultSet rs) throws SQLException {
		Employee e = new Employee();
		e.setId(rs.getInt(1));
		e.setName(rs.getString(2));
		e.setAge(rs.getInt(3));
		e.setExperience(rs.getInt(4));
		e.setSeniority(rs.getInt(5));
		e.setSalary(rs.getInt(6));
		return e;
	}

	@Override
	public List<Employee> getAllEmployees() throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteEmployees(int id) throws SQLException {
		// TODO Auto-generated method stub

	}

	@Override
	public void UpdateEmployee(Employee emp) throws SQLException {
		// TODO Auto-generated method stub

	}

	@Override
	public void createEmployee(Employee emp) throws SQLException {
		// TODO Auto-generated method stub

	}

	@Override
	public long count() throws SQLException {
		// TODO Auto-generated method stub
		return 0;
	}

}
