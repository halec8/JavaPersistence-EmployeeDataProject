
import java.util.List;

import control.EmployeeHelper;
import model.Employee;

/**
 * @author Cody Hale - chale
 * CIS175 - Fall 2021
 * Oct 4, 2021
 */
public class EmployeeTester {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Employee tyler = new Employee("Tyler");
		Employee cody = new Employee("Cody");
		Employee fernando = new Employee("Fernando");
		
		EmployeeHelper et = new EmployeeHelper();
		
		et.insertEmployee(tyler);
		et.insertEmployee(cody);
		et.insertEmployee(fernando);
		
		List<Employee> allEmployees = et.showAllEmployees();
		for (Employee a : allEmployees) {
			
			System.out.println(a.toString());
			
		}
	}

}
