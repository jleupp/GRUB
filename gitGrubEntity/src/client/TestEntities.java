package client;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class TestEntities {
	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("GrubPU");
		EntityManager em = emf.createEntityManager();
		
		
		Restaurant r = em.find(Restaurant.class, 1);
		System.out.println(r);
		
		
	}
}