package client;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.criteria.CriteriaQuery;

import entities.Manager;
import entities.Restaurant;

public class TestEntities {
	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("GrubPU");
		EntityManager em = emf.createEntityManager();
		
		
		Customer cust = em.find(Customer.class, "jeffrey.leupp@gmail.com");
		Restaurant r = em.find(Restaurant.class, 1);
//		System.out.println(cust.getAdresses().get(0));
		System.out.println();
		System.out.println(cust.getBirthDay());
		System.out.println(r.getCity());
		System.out.println(cust.getAccess().getAccessLevel());
		System.out.println(cust);
		
		 CriteriaQuery<Manager> cq = em.getCriteriaBuilder().createQuery(Manager.class);
	        cq.select(cq.from(Manager.class));
	       List<Manager> managers = em.createQuery(cq).getResultList();
	       for(Manager man : managers) {
	    	   System.out.println(man.getEmail());
	    	   System.out.print("THIS MANAGERS ACCESS LEVEL: ");
	    	   System.out.println(man.getAccess().getAccessLevel());
	       }
	       
		
//		Manager manager = em.
		
		
	}
}