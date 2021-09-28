package control;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.EmployeeInformation;

/**
 * Servlet implementation class AddEmployeeServlet
 */
@WebServlet("/addEmployeeServlet")
public class AddEmployeeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddEmployeeServlet() {
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
		
		String company = request.getParameter("company");
		String firstName = request.getParameter("firstName");
		String lastName = request.getParameter("lastName");
		String yearsEmployeed = request.getParameter("yearsEmployeed");
		int tenure = Integer.parseInt(yearsEmployeed);

		
		EmployeeInformation ei = new EmployeeInformation(company, firstName, lastName, tenure);
		EmployeeDataHelper edh = new EmployeeDataHelper();
		
		edh.addEmployee(ei);
		
		getServletContext().getRequestDispatcher("/index.html").forward(request, response);
		
	}

}
