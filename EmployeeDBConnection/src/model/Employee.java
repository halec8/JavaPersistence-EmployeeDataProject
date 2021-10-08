package model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author Cody Hale - chale
 * CIS175 - Fall 2021
 * Oct 4, 2021
 */
@Entity
@Table(name="employee")
public class Employee {
	
	@Id
	@GeneratedValue
	private int id;
	private String employeeName;
	
public Employee() {
	super();
}

public Employee(int id, String employeeName) {
	super();
	this.id = id;
	this.employeeName = employeeName;
}

public Employee(String employeeName) {
	super();
	this.employeeName = employeeName;
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
	 * @return the employeeName
	 */
	public String getEmployeeName() {
		return employeeName;
	}
	/**
	 * @param employeeName the employeeName to set
	 */
	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}
	
	@Override
	public String toString() {
		
		return "Employee [id= " + id + ", employeeName " + employeeName + "]";
	}

	
}
