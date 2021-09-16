import java.util.List;
import java.util.Scanner;

import control.EmployeeDataHelper;
import model.EmployeeInformation;

/**
 * @author Cody Hale - chale
 * CIS175 - Fall 2021
 * Sep 10, 2021
 */
public class StartProgram {
	
	static Scanner in = new Scanner(System.in);
	static EmployeeDataHelper edh = new EmployeeDataHelper();
	
	

	
	private static void addAnEmployee() {

		
		System.out.println("Enter the company the employee works for: ");
		String employer = in.nextLine();
		
		System.out.println("Enter an employees first name: ");
		String firstName = in.nextLine();
		
		System.out.println("Enter an employees last name: ");
		String lastName = in.nextLine();
		
		System.out.println("How many years have they worked for their employer?: ");
		int years = in.nextInt();
		
		EmployeeInformation toAdd = new EmployeeInformation(employer, firstName, lastName, years);
		edh.addEmployee(toAdd);
		
	}
	
	private static void editAnEmployee() {
		
		System.out.println("How would you like to search? ");
		System.out.println("1 : Search by first name");
		System.out.println("2 : Search by last name");
		System.out.println("3: Search by employer");
		System.out.println("4: Search by tenure");
		int searchBy = in.nextInt();
		in.nextLine();
		
		List<EmployeeInformation> foundEmployee;
		if (searchBy == 1) {
			System.out.print("Enter the first name: ");
			String firstName = in.nextLine();
			foundEmployee = edh.searchForEmployeeByFirstName(firstName);
			
		} else if(searchBy == 2){
			System.out.print("Enter the last name: ");
			String lastName = in.nextLine();
			foundEmployee = edh.searchForEmployeeByLastName(lastName);

		}
		else if (searchBy == 3) {
			System.out.println("Enter the employer's name: ");
			String employer = in.nextLine();
			foundEmployee = edh.searchForEmployeeByEmployerName(employer);
		}
		else {
			System.out.println("Enter the tenure (number of years worked) for the employee your searching: ");
			int tenure = in.nextInt();
			foundEmployee = edh.searchForEmployeeByTenure(tenure);
		}

		if (!foundEmployee.isEmpty()) {
			System.out.println("Found Results.");
			for (EmployeeInformation l : foundEmployee) {
				System.out.println(l.getEmployeeID() + " : " + l.toString());
			}
			System.out.print("Which ID to edit: ");
			int idToEdit = in.nextInt();

			
			// review this before moving forward
			
			EmployeeInformation toEdit = edh.searchForEmployeeByID(idToEdit);
			System.out.println("Retrieved " + toEdit.getEmployeeFirstName() + " from " + toEdit.getEmployeeLastName());
			System.out.println("1 : Update first name");
			System.out.println("2 : Update last name");
			System.out.println("3 : Updated employer");
			System.out.println("4 : Update tenure (years employed)");
			int update = in.nextInt();
			in.nextLine();

			if (update == 1) {
				System.out.print("New first name: ");
				String newFirstName = in.nextLine();
				toEdit.setEmployeeFirstName(newFirstName);
			} else if (update == 2) {
				System.out.print("New last name: ");
				String newLastName = in.nextLine();
				toEdit.setEmployeeLastName(newLastName);
			}
			else if (update == 3) {
				System.out.println("New employer: ");
				String newEmployer = in.nextLine();
				toEdit.setEmployer(newEmployer);
			}
			else if (update == 4) {
				System.out.println("Updated tenure (years employeed): ");
				int newTenure = in.nextInt();
				toEdit.setYearsEmployed(newTenure);
				
			}

			edh.updateEmployee(toEdit);

		} else {
			System.out.println("---- No results found for your query");
		}

	}

		

	private static void deleteAnEmployee() {
		
		
		System.out.println("Enter the employer: ");
		String employer = in.nextLine();
		System.out.println("Enter the first name: ");
		String firstName = in.nextLine();
		System.out.println("Enter the last name: ");
		String lastName = in.nextLine();
		System.out.println("Enter the tenure: ");
		int years = in.nextInt();
		
		EmployeeInformation toDelete = new EmployeeInformation(employer, firstName, lastName, years);
		edh.deleteEmployee(toDelete);
		
	}
	

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		runMenu();

	}
	
	public static void runMenu() {
		boolean menuGo = true;
		System.out.println("--- Create, Add, Delete, Update or View Employees! ---");
		while (menuGo) {
			System.out.println("*  Select an option:");
			System.out.println("*  1 -- Add an employee");
			System.out.println("*  2 -- Edit an employee");
			System.out.println("*  3 -- Delete an employee");
			System.out.println("*  4 -- View the list of employees");
			System.out.println("*  5 -- Exit");
			System.out.print("*  Your selection: ");
			int selection = in.nextInt();
			in.nextLine();

			if (selection == 1) {
				addAnEmployee();
			} else if (selection == 2) {
				editAnEmployee();
			} else if (selection == 3) {
				deleteAnEmployee();
			} else if (selection == 4) {
				viewTheListOfEmployees();
			} else {
			
				System.out.println("   Bye!   ");
				menuGo = false;
			}

		}

	}
	
	private static void viewTheListOfEmployees() {
		
		List<EmployeeInformation> allItems = edh.showAllData();
		
		for(EmployeeInformation singleItem : allItems) {
			System.out.println(singleItem.returnEmployeeDetails());
		}
	}
}
