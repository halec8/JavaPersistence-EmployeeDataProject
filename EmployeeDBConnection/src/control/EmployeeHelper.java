package control;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import model.Employee;

/**
 * @author Cody Hale - chale
 * CIS175 - Fall 2021
 * Oct 4, 2021
 */
public class EmployeeHelper {
	
	static EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("EmployeeDBConnection");

	public void insertEmployee(Employee e) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		em.persist(e);
		em.getTransaction().commit();
		em.close();
	}
	
	@SuppressWarnings("unchecked")
	
	public List<Employee> showAllEmployees() {
		EntityManager em = emfactory.createEntityManager();
		List<Employee> allEmployees = em.createQuery("SELECT e FROM Employee e").getResultList();
		return allEmployees;
	}

	public Employee findEmployee(String nameToLookUp) {
		// TODO Auto-generated method stub
		
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		TypedQuery<Employee> typedQuery = em.createQuery("select eh from Employee eh where eh.employeeName = :selectedName", Employee.class);
		
		typedQuery.setParameter("selectedName", nameToLookUp);
		typedQuery.setMaxResults(1);
		
		Employee foundEmployee;
		try {
			foundEmployee = typedQuery.getSingleResult();
		} catch (Exception e) {
			// TODO: handle exception
			foundEmployee = new Employee(nameToLookUp);
		}
		return foundEmployee;
	}
}
