package control;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.EmployeeInformation;

/**
 * Servlet implementation class EditEmployeeServlet
 */
@WebServlet("/editEmployeeServlet")
public class EditEmployeeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EditEmployeeServlet() {
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
		
		EmployeeDataHelper edh = new EmployeeDataHelper();
		
		String company = request.getParameter("company");
		
		String firstName = request.getParameter("firstName");
		
		String lastName = request.getParameter("lastName");
		
		String yearsWorked = request.getParameter("yearsWorked");
		
		Integer tenure = Integer.parseInt(yearsWorked);
		
		Integer tempID = Integer.parseInt(request.getParameter("id"));
		
		EmployeeInformation employeeToUpdate = edh.searchForEmployeeByID(tempID);
		
		employeeToUpdate.setEmployer(company);
		employeeToUpdate.setEmployeeFirstName(firstName);
		employeeToUpdate.setEmployeeLastName(lastName);
		employeeToUpdate.setYearsEmployed(tenure);
		
		edh.updateEmployee(employeeToUpdate);
		
		getServletContext().getRequestDispatcher("/viewAllEmployeesServlet").forward(request, response);
		
	}

}
