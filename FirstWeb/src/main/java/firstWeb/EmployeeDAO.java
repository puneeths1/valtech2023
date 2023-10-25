package firstWeb;

import java.sql.SQLException;
import java.util.List;

public interface EmployeeDAO {
	
	int firstID() throws SQLException;
	
	int lastID() throws SQLException;

	int nextID(int id) throws SQLException;
	
	int previousID(int id) throws SQLException;

	Employee getEmployee(int id) throws SQLException;

	List<Employee> getAllEmployees() throws SQLException;

	void deleteEmployees(int id) throws SQLException;

	void UpdateEmployee(Employee emp) throws SQLException;

	void createEmployee(Employee emp) throws SQLException;
	
	public long count() throws SQLException;
}
