package control;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.EmployeeInformation;

/**
 * Servlet implementation class NavigationServlet
 */
@WebServlet("/navigationServlet")
public class NavigationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public NavigationServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	
		String act = request.getParameter("doThisToEmployee");
		
		String path = "/viewAllEmployeesServlet";
		
		EmployeeDataHelper edh = new EmployeeDataHelper();
		
		if (act.equals("Delete")) {
			
			try {
				Integer tempId = Integer.parseInt(request.getParameter("id"));
				EmployeeInformation employeeToDelete = edh.searchForEmployeeByID(tempId);
				edh.deleteEmployee(employeeToDelete);
			} catch (NumberFormatException e) {
				// TODO Auto-generated catch block
				System.out.println("You did not select an employee!");
			
			}
		}
		
		else if (act.equals("Edit")) {
			
			try {
				Integer tempId = Integer.parseInt(request.getParameter("id"));
				EmployeeInformation employeeToEdit = edh.searchForEmployeeByID(tempId);
				request.setAttribute("employeeToEdit", employeeToEdit);
				path = "/edit-employee.jsp";
			} catch (NumberFormatException e) {
				// TODO Auto-generated catch block
				System.out.println("You did not select an employee!");
			}
			
		}
		
		else if (act.equals("Add")) {
			
			path = "/index.html";
			
		}
		
		getServletContext().getRequestDispatcher(path).forward(request, response);
		
	}

}
