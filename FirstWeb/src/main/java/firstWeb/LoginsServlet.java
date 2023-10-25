package firstWeb;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LoginsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
  
    public LoginsServlet() {
        super();
        
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.getWriter().print("Username="+request.getParameter("name")+"Password="+request.getParameter("pass"));
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 * TODO if name and pass is wrong show login page again with msg
	 * if name is less than 4 chars then add msg and login page
	 * if pass is less than 8 chars then add msg and login page
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String name = request.getParameter("name");
        String pass = request.getParameter("pass");
        
        if ("scott".equals(name) && "rootroot".equals(pass)) {
            request.setAttribute("message", "Hi Scott, Welcome...!");
        } else {
            if (!"scott".equals(name)) {
                request.setAttribute("message", "Invalid username. Please try again.");
                request.getRequestDispatcher("LoginsResult.jsp").forward(request, response);
//                request.getRequestDispatcher("Login.jsp").forward(request, response);
                
            }else if (name.length() < 4) {
                request.setAttribute("message", "Name must be at least 4 characters long. Please try again.");
                request.getRequestDispatcher("LoginsResult.jsp").forward(request, response);
                
                
            } else if (pass.length() < 8) {
                request.setAttribute("message", "Password must be at least 8 characters long. Please try again.");
                request.getRequestDispatcher("LoginsResult.jsp").forward(request, response);
            } else {
                request.setAttribute("message", "Login failed. Please try again.");
                request.getRequestDispatcher("LoginsResult.jsp").forward(request, response);
            }
        }
        
        request.getRequestDispatcher("LoginsResult.jsp").forward(request, response);
        try {
			request.wait(1000);
			request.getRequestDispatcher("Login.jsp").forward(request, response);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }

}
