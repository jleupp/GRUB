package client;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class TestEntities {
	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("GrubPU");
		EntityManager em = emf.createEntityManager();
		
		
		Manager m = em.find(Manager.class, "manager@panzano.com");
		System.out.println(m.getEmail()+" "+m.getPhone());
		System.out.println(m.getAccessId());
		
	}
}