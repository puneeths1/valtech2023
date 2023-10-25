package com.valtech.training.day2test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class DepartmentDAOImpl implements DepartmentDAO{		

	public static void main(String[] args) throws SQLException {
		// TODO Auto-generated method stub
//		DepartmentDAO dao = new DepartmentDAOImpl();
//		System.out.println(dao.getAllDept());
		DepartmentDAO dao = new DepartmentDAOImpl();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Choose an operation:");
            System.out.println("1. Insert Department");
            System.out.println("2. Delete Department");
            System.out.println("3. Update Department");
            System.out.println("4. View All Departments");
            System.out.println("5. Exit");

            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    // Insert data into the "Department" table
                    Departmentnew departmentToInsert = new Departmentnew();
                    scanner.nextLine(); // Consume the newline character
                    System.out.println("Enter Department Name:");
                    departmentToInsert.setD_name(scanner.nextLine());
                    System.out.println("Enter Location:");
                    departmentToInsert.setLocation(scanner.nextLine());
                    System.out.println("Enter List of Employees:");
                    departmentToInsert.setListOfEmp(scanner.nextInt());

                    try {
                        dao.createDept(departmentToInsert);
                        System.out.println("Department inserted successfully.");
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }
                    break;

                case 2:
                    // Delete data from the "Department" table
                    System.out.println("Enter the Department ID to delete:");
                    int departmentIdToDelete = scanner.nextInt();

                    try {
                        dao.deleteDept(departmentIdToDelete);
                        System.out.println("Department deleted successfully.");
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }
                    break;

                case 3:
                    // Update data in the "Department" table
                    Departmentnew departmentToUpdate = new Departmentnew();
                    System.out.println("Enter the Department ID to update:");
                    departmentToUpdate.setD_id(scanner.nextInt());
                    scanner.nextLine(); // Consume the newline character
                    System.out.println("Enter Updated Department Name:");
                    departmentToUpdate.setD_name(scanner.nextLine());
                    System.out.println("Enter Updated Location:");
                    departmentToUpdate.setLocation(scanner.nextLine());
                    System.out.println("Enter Updated List of Employees:");
                    departmentToUpdate.setListOfEmp(scanner.nextInt());

                    try {
                        dao.updateDept(departmentToUpdate);
                        System.out.println("Department updated successfully.");
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }
                    break;

                case 4:
                
                    try {
                        List<Departmentnew> departments = dao.getAllDept();
                        for (Departmentnew department : departments) {
                            System.out.println("Department ID: " + department.getD_id());
                            System.out.println("Department Name: " + department.getD_name());
                            System.out.println("Location: " + department.getLocation());
                            System.out.println("List of Employees: " + department.getListOfEmp());
                            System.out.println("--------------------------");
                        }
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }
                    break;

                case 5:
                    // Exit the program
//                    dao.close();
                    System.out.println("Exiting program.");
                    System.exit(0);

                default:
                    System.out.println("Invalid choice. Please enter a valid option.");
                    break;
            }
        }
		

	}
//	public void close() {
//		try {
//			if(con!=null) {
//				con.close();
//			}
//		}
//	}

	@Override
	public Departmentnew getDept(int dept_id) throws SQLException {
		// TODO Auto-generated method stub
		Connection con=getConnection();
		PreparedStatement ps = con.prepareStatement("SELECT * FROM DEPARTMENT WHERE ID = ?");
		ps.setInt(101,dept_id);
		ResultSet rs = ps.executeQuery();
		if(rs.next()) {
			Departmentnew d = MapRowToDepartment(rs);
			con.close();
			return d;
		}else {
			System.out.println("No row with id = "+dept_id+" found..");
			return null;
		}
		
	}

	private Departmentnew MapRowToDepartment(ResultSet rs) throws SQLException {
		// TODO Auto-generated method stub
		Departmentnew d = new Departmentnew();
		d.setD_id(rs.getInt(1));
		d.setD_name(rs.getString(2));
		d.setLocation(rs.getString(3));
		d.setListOfEmp(rs.getInt(4));
		return d;
	}
	static {
		try {
			Class.forName("com.mysql.jdbc.Driver");
		}catch(ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	private Connection getConnection() throws SQLException{
		// TODO Auto-generated method stub
		return DriverManager.getConnection("jdbc:mysql://localhost:3306/valtech2023?useSSL=false", "root", "root");
	}

	@Override
	public List<Departmentnew> getAllDept() throws SQLException {
		// TODO Auto-generated method stub
		Connection con = getConnection();
		PreparedStatement ps = con.prepareStatement("SELECT Dept_id,dept_name,location,listofemp FROM DEPARTMENT");
		ResultSet rs = ps.executeQuery();
		List<Departmentnew> depts = new ArrayList<>();
		while(rs.next()) {
			depts.add(MapRowToDepartment(rs));
		}
		con.close();
		return depts;
	}

	@Override
	public void createDept(Departmentnew d) throws SQLException {
		// TODO Auto-generated method stub
		Connection con = getConnection();
        PreparedStatement ps = con.prepareStatement("INSERT INTO DEPARTMENT (dept_name, location, listofemp) VALUES (?, ?, ?)");
        ps.setString(1, d.getD_name());
        ps.setString(2, d.getLocation());
        ps.setInt(3, d.getListOfEmp());
        ps.executeUpdate();
        con.close();
		
	}

	@Override
	public void updateDept(Departmentnew d) throws SQLException {
		// TODO Auto-generated method stub
		Connection con = getConnection();
        PreparedStatement ps = con.prepareStatement("UPDATE DEPARTMENT SET dept_name = ?, location = ?, listofemp = ? WHERE dept_id = ?");
        ps.setString(1, d.getD_name());
        ps.setString(2, d.getLocation());
        ps.setInt(3, d.getListOfEmp());
        ps.setInt(4, d.getD_id());
        ps.executeUpdate();
        con.close();
		
	}

	@Override
	public void deleteDept(int dept_id) throws SQLException {
		// TODO Auto-generated method stub
		Connection con = getConnection();
        PreparedStatement ps = con.prepareStatement("DELETE FROM DEPARTMENT WHERE dept_id = ?");
        ps.setInt(1, dept_id);
        ps.executeUpdate();
        con.close();
		
	}

}
