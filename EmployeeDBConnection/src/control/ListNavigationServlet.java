package control;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import model.EmployeeListDetails;

/**
 * Servlet implementation class ListNavigationServlet
 */
@WebServlet("/listnavigationServlet")
public class ListNavigationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ListNavigationServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		EmployeeListDetailsHelper dao = new EmployeeListDetailsHelper();
		String act = request.getParameter("doThisToList");
		
		if (act == null) {
			
			getServletContext().getRequestDispatcher("/viewAllEmployeesServlet").forward(request, response);
		}
		else if (act.equals("delete")) {
			try {
				Integer tempId = Integer.parseInt(request.getParameter("id"));
				EmployeeListDetails listToDelete = dao.searchForEmployeeByID(tempId);
				dao.deleteEmployee(listToDelete);
			} catch (Exception e) {
				// TODO: handle exception
				System.out.println("Forgot to click a button");
			}
			finally {
				getServletContext().getRequestDispatcher("/viewAllEmployeesServlet").forward(request, response);
			}
		}
		else if (act.equals("edit")) {
			
			try {
				Integer tempID = Integer.parseInt(request.getParameter("id"));
			    EmployeeListDetails listToEdit = dao.searchForEmployeeByID(tempID);
			    request.setAttribute("listToEdit", listToEdit);
			    
			    request.setAttribute("month", listToEdit.getListDate().getMonthValue());
			    
			    request.setAttribute("date", listToEdit.getListDate().getDayOfMonth());
			    
			    request.setAttribute("year", listToEdit.getListDate().getYear());
			    
			    EmployeeDataHelper daoForEmployees = new EmployeeDataHelper();
			    
			    request.setAttribute("allItems", daoForEmployees.showAllData());
			    
			   if(daoForEmployees.showAllData().isEmpty()) {
				   
				   request.setAttribute("allItems", " ");
				   
			   }
			    
				getServletContext().getRequestDispatcher("/edit-employee-list.jsp").forward(request, response);
				
			} catch (Exception e) {
				// TODO: handle exception
				getServletContext().getRequestDispatcher("/viewAllEmployeesServlet").forward(request, response);
			}
			
		}
		
		else if (act.equals("add")) {
			getServletContext().getRequestDispatcher("/new-list.jsp").forward(request, response);
			
		}
	}

}
