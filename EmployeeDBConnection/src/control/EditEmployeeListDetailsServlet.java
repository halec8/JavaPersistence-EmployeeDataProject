package control;

import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Iterator;
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
 * Servlet implementation class EditEmployeeListDetailsServlet
 */
@WebServlet("/editEmployeeListDetailsServlet")
public class EditEmployeeListDetailsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EditEmployeeListDetailsServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		EmployeeListDetailsHelper dao = new EmployeeListDetailsHelper();
		EmployeeDataHelper edh = new EmployeeDataHelper();
		EmployeeHelper eh = new EmployeeHelper();
		
		Integer tempId = Integer.parseInt(request.getParameter("id"));
		EmployeeListDetails listToUpdate = dao.searchForEmployeeByID(tempId);
		
		String newListName = request.getParameter("listName");
		
		String month = request.getParameter("month");
		String day = request.getParameter("day");
		String year = request.getParameter("year");
		String name = request.getParameter("employeeName");
		Employee newEmployee = eh.findEmployee(name);
		
		LocalDate ld;
		try {
			ld = LocalDate.of(Integer.parseInt(year), Integer.parseInt(month), Integer.parseInt(day));
			
		} catch (Exception e) {
			// TODO: handle exception
			
			ld = LocalDate.now();
		}
		
		try {
			String[] selectedItems = request.getParameterValues("allEmployeesToAdd");
			List<EmployeeInformation> selectedItemsInList = new ArrayList<EmployeeInformation>();
			
		    for (int i = 0; i < selectedItems.length; i++) {
				System.out.println(selectedItems[i]);
				EmployeeInformation e = edh.searchForEmployeeByID(Integer.parseInt(selectedItems[i]));
				selectedItemsInList.add(e);
		    }
		    
		    listToUpdate.setListOfEmployees(selectedItemsInList);
			
		} catch (Exception e) {
			// TODO: handle exception
			List<EmployeeInformation> selectedItemsInList = new ArrayList<EmployeeInformation>();
			listToUpdate.setListOfEmployees(selectedItemsInList);
		}
		listToUpdate.setListName(newListName);
		listToUpdate.setListDate(ld);
		listToUpdate.setEmployee(newEmployee);
		
		dao.updateList(listToUpdate);
		
		getServletContext().getRequestDispatcher("/viewAllEmployeesServlet").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
