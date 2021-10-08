import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import control.EmployeeHelper;
import control.EmployeeListDetailsHelper;
import model.Employee;
import model.EmployeeInformation;
import model.EmployeeListDetails;

/**
 * @author Cody Hale - chale
 * CIS175 - Fall 2021
 * Oct 4, 2021
 */
public class EmployeeListDetailsTester {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Employee granular = new Employee("Granular");
		
		EmployeeListDetailsHelper eldh = new EmployeeListDetailsHelper();
		
		EmployeeInformation newEmployeeOne = new EmployeeInformation("Granular", "Jay", "Acuna", 3);
		EmployeeInformation newEmployeeTwo = new EmployeeInformation("Granular", "Chase", "Hardin", 5);
		
		List<EmployeeInformation> granularsNewEmployee = new ArrayList<EmployeeInformation>();
		granularsNewEmployee.add(newEmployeeOne);
		granularsNewEmployee.add(newEmployeeTwo);
		
		EmployeeListDetails granularsEmployeeList = new EmployeeListDetails("Granular's Employee List", LocalDate.now(), granular);
		
		eldh.insertNewEmployeeListDetails(granularsEmployeeList);
		
		List<EmployeeListDetails> allLists = eldh.getLists();
		
		for (EmployeeListDetails a : allLists) {
			
			System.out.println(a.toString());
			
		}

	}
}
