package firstWeb;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


public class EmployeeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private EmployeeDAO dao = new EmployeeDAOImpl();
 
    public EmployeeServlet() {
        super();
    
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			HttpSession sess = request.getSession(true);
			sess.setAttribute("current", dao.firstID());
//			request.setAttribute("emp", dao.getEmployee(dao.firstID()));
//			request.setAttribute(getServletInfo(), sess);
			request.setAttribute("emp", dao.getEmployee(dao.firstID()));
			request.getRequestDispatcher("employee.jsp").forward(request, response);
		} catch (SQLException e) {
		
			e.printStackTrace();
		}
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession sess = request.getSession();
		int current = (Integer)sess.getAttribute("current");
		String submit = request.getParameter("submit");
		try{if("First".equals(submit)) {
			current = dao.firstID()	;
			
		}else if("Last".equals(submit)) {
			current = dao.lastID()	;
			
		}else if("Next".equals(submit)) {
			current  = dao.nextID(current);
		}else if("Previous".equals(submit)) {
			current = dao.previousID(current);
		}
		sess.setAttribute("current", current);
		
			request.setAttribute("emp", dao.getEmployee(current));
		
		request.getRequestDispatcher("employee.jsp").forward(request, response);
//			response.sendRedirect("employee.jsp");
	
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
