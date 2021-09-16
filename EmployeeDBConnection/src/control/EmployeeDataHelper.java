package control;


import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import model.EmployeeInformation;



/**
 * @author Cody Hale - chale
 * CIS175 - Fall 2021
 * Sep 10, 2021
 */
public class EmployeeDataHelper {
	
	static EntityManagerFactory emFactory = Persistence.createEntityManagerFactory("EmployeeDBConnection"); 
	
	public void addEmployee(EmployeeInformation ei) {
		
		// creates an entity manager, creates a new transactions, gathers the information passed into the ei and commits it to the db instance.
		
		EntityManager em = emFactory.createEntityManager();
		em.getTransaction().begin();
		em.persist(ei);
		em.getTransaction().commit();
		em.close();
		
	}

	
	//searches for an employee by their first name
	public List<EmployeeInformation> searchForEmployeeByFirstName(String firstName) {
	
		EntityManager em = emFactory.createEntityManager();
		em.getTransaction().begin();
		TypedQuery<EmployeeInformation>typedQuery = em.createQuery("select ei from EmployeeInformation ei where ei.employeeFirstName = :selectedEmployeeFirstName", EmployeeInformation.class);
		typedQuery.setParameter("selectedEmployeeFirstName", firstName);
				
		List<EmployeeInformation>foundEmployeeInformations = typedQuery.getResultList();
		em.close();
		
		return foundEmployeeInformations;
		
	}
	
	//searches for an employee by their last name
	public List<EmployeeInformation> searchForEmployeeByLastName(String lastName) {
		EntityManager em = emFactory.createEntityManager();
		em.getTransaction().begin();
		TypedQuery<EmployeeInformation>typedQuery = em.createQuery("select ei from EmployeeInformation ei where ei.employeeLastName = :selectedEmployeeLastName", EmployeeInformation.class);
		typedQuery.setParameter("selectedEmployeeLastName", lastName);
		List<EmployeeInformation>foundEmployeeInformations = typedQuery.getResultList();
		em.close();
		
		return foundEmployeeInformations;
		
	}
	
	//searches for an employee by their employer's name
	public List<EmployeeInformation> searchForEmployeeByEmployerName(String employer) {
		EntityManager em = emFactory.createEntityManager();
		em.getTransaction().begin();
		TypedQuery<EmployeeInformation>typedQuery = em.createQuery("select ei from EmployeeInformation ei where ei.employer = :selectedEmployer", EmployeeInformation.class);
		typedQuery.setParameter("selectedEmployer", employer);
		List<EmployeeInformation>foundEmployeeInformations = typedQuery.getResultList();
		em.close();
			
		return foundEmployeeInformations;
		
	}
	
	//searches for an employee by their tenure
	public List<EmployeeInformation> searchForEmployeeByTenure(int tenure) {
		EntityManager em = emFactory.createEntityManager();
		em.getTransaction().begin();
		TypedQuery<EmployeeInformation>typedQuery = em.createQuery("select ei from EmployeeInformation ei where ei.yearsEmployed = :selectedYearsEmployed", EmployeeInformation.class);
		typedQuery.setParameter("selectedYearsEmployed", tenure);
		List<EmployeeInformation>foundEmployeeInformations = typedQuery.getResultList();
		em.close();
		
		return foundEmployeeInformations;
	}
		
	
	public void updateEmployee(EmployeeInformation toEdit) {
		
		EntityManager em = emFactory.createEntityManager();
		em.getTransaction().begin();
		em.merge(toEdit);
		em.getTransaction().commit();
		em.close();
	}
	
	public void cleanUp() {
		emFactory.close();
		
	}
	
	/**
	 * @return
	 */
	public List<EmployeeInformation> showAllData() {
		// TODO Auto-generated method stub
		
		EntityManager em = emFactory.createEntityManager();
		List<EmployeeInformation>allData = em.createQuery("SELECT i FROM EmployeeInformation i").getResultList();
				
				return allData;
	}

	
	/**
	 * @param toDelete
	 */
	public void deleteEmployee(EmployeeInformation toDelete) {
		
		// TODO Auto-generated method stub
		EntityManager em = emFactory.createEntityManager();
		em.getTransaction().begin();
		
		TypedQuery<EmployeeInformation>typedQuery = em.createQuery("select ei from EmployeeInformation ei where ei.employeeFirstName = :selectedEmployeeFirstName and ei.employeeLastName = :selectedEmployeeLastName and ei.employer = :selectedEmployer and ei.yearsEmployed = :selectedYearsEmployed", EmployeeInformation.class);

		//Substitute parameter with actual data from the toDelete item
		typedQuery.setParameter("selectedEmployeeFirstName", toDelete.getEmployeeFirstName());
		typedQuery.setParameter("selectedEmployeeLastName", toDelete.getEmployeeLastName());
		typedQuery.setParameter("selectedEmployer", toDelete.getEmployer());
		typedQuery.setParameter("selectedYearsEmployed", toDelete.getYearsEmployed());
		
		//we only want one result
		typedQuery.setMaxResults(1);
	
		
		//get the result and save it into a new list item
		EmployeeInformation result = typedQuery.getSingleResult();
		
		//remove it
		em.remove(result);
		em.getTransaction();
		em.close();
	}

	/**
	 * @param idToEdit
	 * @return
	 */
	public EmployeeInformation searchForEmployeeByID(int idToEdit) {
		
		// TODO Auto-generated method stub
		EntityManager em = emFactory.createEntityManager();
		em.getTransaction().begin();
		EmployeeInformation found = em.find(EmployeeInformation.class, idToEdit);
		em.close();
		return found;
	}
}
