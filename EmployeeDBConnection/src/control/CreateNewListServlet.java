package control;

import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Employee;
import model.EmployeeInformation;
import model.EmployeeListDetails;

/**
 * Servlet implementation class CreateNewListServlet
 */
@WebServlet("/createNewListServlet")
public class CreateNewListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CreateNewListServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		EmployeeDataHelper edh = new EmployeeDataHelper();
		String listName = request.getParameter("listName");
		System.out.println("List Name: " + listName);
		
		String month = request.getParameter("month");
		String day = request.getParameter("day");
		String year = request.getParameter("year");
		String employeeName = request.getParameter("employeeName");
		
		LocalDate ld;
		try {
			ld = LocalDate.of(Integer.parseInt(year), Integer.parseInt(month), Integer.parseInt(day));
		} catch (Exception e) {
			// TODO: handle exception
			
			ld = LocalDate.now();
		}
		
		String[] selectedEmployees = request.getParameterValues("allEmployeesToAdd");
		List<EmployeeInformation> selectedItemsInList = new ArrayList<EmployeeInformation>();
		
		if (selectedEmployees != null && selectedEmployees.length > 0) {
			
			for (int i = 0; i < selectedEmployees.length; i++) {
				System.out.println(selectedEmployees[i]);
				EmployeeInformation c = edh.searchForEmployeeByID(Integer.parseInt(selectedEmployees[i]));
				selectedItemsInList.add(c);
			}
			
		}
		
		Employee employee = new Employee(employeeName);
		EmployeeListDetails eld = new EmployeeListDetails(listName, ld, employee);
		
		eld.setListOfEmployees(selectedItemsInList);
		EmployeeListDetailsHelper eldh = new EmployeeListDetailsHelper();
		eldh.insertNewEmployeeListDetails(eld);
		
		System.out.println("Success!");
		System.out.println(eld.toString());
		
		getServletContext().getRequestDispatcher("/viewAllListsServlet").forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
