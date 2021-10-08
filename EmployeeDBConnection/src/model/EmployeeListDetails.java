package model;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

/**
 * @author Cody Hale - chale
 * CIS175 - Fall 2021
 * Oct 4, 2021
 * @param <ListEmployee>
 */

@Entity
public class EmployeeListDetails {
	
	@Id
	@GeneratedValue
	private int id;
	private String listName;
	private LocalDate listDate;
	@ManyToOne(cascade = CascadeType.PERSIST)
	private Employee employee;
	@OneToMany(cascade = CascadeType.MERGE, fetch=FetchType.EAGER)
	private List<EmployeeInformation> listOfEmployees;
	
	public EmployeeListDetails() {
		super();
	}
	
	
	public EmployeeListDetails(int id, String listName, LocalDate listDate, Employee employee, List<EmployeeInformation> listOfEmployees) {
		
		super();
		
		this.id = id;
		this.listName = listName;
		this.listDate = listDate;
		this.employee = employee;
		this.listOfEmployees = listOfEmployees;
	}
	
	public EmployeeListDetails(String listName, LocalDate listDate, Employee employee, List<EmployeeInformation> listOfEmployees) {
		
		super();
		
		this.listName = listName;
		this.listDate = listDate;
		this.employee = employee;
		this.listOfEmployees = listOfEmployees;
		
	}
	
	public EmployeeListDetails(String listName, LocalDate listDate, Employee employee) {
		super();
		
		this.listName = listName;
		this.listDate = listDate;
		this.employee = employee;
	}
	
	
	
	
	
	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}
	/**
	 * @return the listName
	 */
	public String getListName() {
		return listName;
	}
	/**
	 * @param listName the listName to set
	 */
	public void setListName(String listName) {
		this.listName = listName;
	}
	/**
	 * @return the listDate
	 */
	public LocalDate getListDate() {
		return listDate;
	}
	/**
	 * @param listDate the listDate to set
	 */
	public void setListDate(LocalDate listDate) {
		this.listDate = listDate;
	}
	/**
	 * @return the employee
	 */
	public Employee getEmployee() {
		return employee;
	}
	/**
	 * @param employee the employee to set
	 */
	public void setEmployee(Employee employee) {
		this.employee = employee;
	}
	/**
	 * @return the listOfEmployees
	 */
	public List<EmployeeInformation> getListOfEmployees() {
		return listOfEmployees;
	}
	/**
	 * @param listOfEmployees the listOfEmployees to set
	 */
	public void setListOfEmployees(List<EmployeeInformation> listOfEmployees) {
		this.listOfEmployees = listOfEmployees;
	}

	
}
