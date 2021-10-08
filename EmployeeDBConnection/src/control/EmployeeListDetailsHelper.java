package control;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import model.Employee;
import model.EmployeeListDetails;

/**
 * @author Cody Hale - chale
 * CIS175 - Fall 2021
 * Oct 4, 2021
 */
public class EmployeeListDetailsHelper {

	static EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("EmployeeDBConnection");

	
	public void insertNewEmployeeListDetails(EmployeeListDetails eld) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		em.persist(eld);
		em.getTransaction().commit();
		em.close();
	}
	
	@SuppressWarnings("unchecked")
	
	public List<EmployeeListDetails> getLists() {
		EntityManager em = emfactory.createEntityManager();
		List<EmployeeListDetails> allDetails = em.createQuery("SELECT d FROM EmployeeListDetails d").getResultList();
		return allDetails;
	}

	/**
	 * @param tempId
	 * @return
	 */
	public EmployeeListDetails searchForEmployeeByID(Integer tempId) {
		// TODO Auto-generated method stub
		
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		EmployeeListDetails found = em.find(EmployeeListDetails.class, tempId);
		em.close();
		
		return found;
	}

	/**
	 * @param listToDelete
	 */
	public void deleteEmployee(EmployeeListDetails toDelete) {
		// TODO Auto-generated method stub
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		TypedQuery<EmployeeListDetails> typedQuery = em.createQuery("select detail from EmployeeListDetails detail where detail.id = :selectedId", EmployeeListDetails.class);
		typedQuery.setParameter("selectedId", toDelete.getId());
		typedQuery.setMaxResults(1);
		EmployeeListDetails result = typedQuery.getSingleResult();
		em.remove(result);
		em.getTransaction().commit();
		em.close();
	}
	
	public void updateList(EmployeeListDetails toEdit) {
		
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		
		em.merge(toEdit);
		em.getTransaction().commit();
		em.clear();
		
	}
	
	public Employee findEmployee(String toLookUp) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		TypedQuery<Employee> typedQuery = em.createQuery("select eh from employee eh where eh.employeeName = :selectedName ", Employee.class);
		
		typedQuery.setParameter("selectedName", toLookUp);
		typedQuery.setMaxResults(1);
		
		Employee foundEmployee;
		try {
			foundEmployee = typedQuery.getSingleResult();
		} catch (Exception e) {
			// TODO: handle exception
			foundEmployee = new Employee(toLookUp);
		}
		
		em.close();
		
		return foundEmployee;
	}
}
