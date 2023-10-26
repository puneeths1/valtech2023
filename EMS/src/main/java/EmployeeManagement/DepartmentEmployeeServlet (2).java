package EmployeeManagement;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/DepartmentEmployeeServlet")
public class DepartmentEmployeeServlet extends HttpServlet {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            DepartmentTable departmentTable = new DepartmentTable();
            
            String action = request.getParameter("action");
            String deptIdParam = request.getParameter("deptId");
            int currentDepartmentId = 0;  // Initialize with a default value

            // Check if deptIdParam is not null and is a valid integer
            if (deptIdParam != null && !deptIdParam.isEmpty()) {
                try {
                    currentDepartmentId = Integer.parseInt(deptIdParam);
                } catch (NumberFormatException e) {
                    // Handle the NumberFormatException, perhaps by showing an error message
                    request.setAttribute("error", "Invalid department ID.");
                }
            }

            if (action != null) {
                if (action.equals("first")) {
                    currentDepartmentId = departmentTable.firstDept();
                } else if (action.equals("next")) {
                    currentDepartmentId = departmentTable.nextDept(currentDepartmentId);
                } else if (action.equals("previous")) {
                    currentDepartmentId = departmentTable.previousDept(currentDepartmentId);
                } else if (action.equals("last")) {
                    currentDepartmentId = departmentTable.lastDept();
                }
            }
            
            List<Department> departments = departmentTable.getAllDepartment();
            Department currentDepartment = departmentTable.getDepartment(currentDepartmentId);
            
            // Retrieve employee details by department
            DepartmentJoin employeeByDepartment = departmentTable.getEmployeeByDepartment(currentDepartmentId);

            request.setAttribute("departments", departments);
            request.setAttribute("currentDepartment", currentDepartment);
            request.setAttribute("employeeByDepartment", employeeByDepartment);
            
            request.getRequestDispatcher("department_employee.jsp").forward(request, response);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
