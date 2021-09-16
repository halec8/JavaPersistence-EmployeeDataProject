package model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author Cody Hale - chale
 * CIS175 - Fall 2021
 * Sep 10, 2021
 */

//Creates an entity out of the EmployeeInformation class to be used throughout the program
//Creates a table called Employee_Data
//POJO for EmployeeInformation

@Entity
@Table (name = "Employee_Data")
public class EmployeeInformation {
	
	//Instance variables for POJO
	//Sets the employeeID as the primary key
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "employeeID")
	private int employeeID;
	
	@Column(name = "CompanyName")
	private String employer;
	
	@Column(name = "FirstName")
	private String employeeFirstName;
	
	@Column(name = "LastName")
	private String employeeLastName;
	
	@Column(name = "YearsWorked")
	private int yearsEmployed;
	
	public EmployeeInformation() {
		
		super();
	}
	public EmployeeInformation(String employer, String employeeFirstName, String
			employeeLastName, int yearsEmployed) {
	
		super();

		this.employer = employer;
		this.employeeFirstName = employeeFirstName;
		this.employeeLastName = employeeLastName;
		this.yearsEmployed = yearsEmployed;
	
	}
	
	
	/**
	 * @return the employeeID
	 */
	public int getEmployeeID() {
		return employeeID;
	}
	/**
	 * @param employeeID the employeeID to set
	 */
	public void setEmployeeID(int employeeID) {
		this.employeeID = employeeID;
	}
	/**
	 * @return the employer
	 */
	public String getEmployer() {
		return employer;
	}
	/**
	 * @param employer the employer to set
	 */
	public void setEmployer(String employer) {
		this.employer = employer;
	}
	/**
	 * @return the employeeFirstName
	 */
	public String getEmployeeFirstName() {
		return employeeFirstName;
	}
	/**
	 * @param employeeFirstName the employeeFirstName to set
	 */
	public void setEmployeeFirstName(String employeeFirstName) {
		this.employeeFirstName = employeeFirstName;
	}
	/**
	 * @return the employeeLastName
	 */
	public String getEmployeeLastName() {
		return employeeLastName;
	}
	/**
	 * @param employeeLastName the employeeLastName to set
	 */
	public void setEmployeeLastName(String employeeLastName) {
		this.employeeLastName = employeeLastName;
	}
	/**
	 * @return the yearsEmployed
	 */
	public int getYearsEmployed() {
		return yearsEmployed;
	}
	/**
	 * @param yearsEmployed the yearsEmployed to set
	 */
	public void setYearsEmployed(int yearsEmployeed) {
		this.yearsEmployed = yearsEmployeed;
	}
	
	public String returnEmployeeDetails() {
		
		return  "Employer: " + this.employer + " || " + "First and Last Name: " + this.employeeFirstName + " " + this.employeeLastName + " || " +
		"Years worked: " + this.yearsEmployed;
	}

}
