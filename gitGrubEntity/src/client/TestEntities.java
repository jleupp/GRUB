package client;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.criteria.CriteriaQuery;

import entities.Menu;
import entities.Restaurant;

public class TestEntities {
	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("GrubPU");
		EntityManager em = emf.createEntityManager();
		
		
//		Customer cust = em.find(Customer.class, "jeffrey.leupp@gmail.com");
//		Restaurant r = em.find(Restaurant.class, 1);
////		System.out.println(cust.getAdresses().get(0));
//		System.out.println();
//		System.out.println(cust.getBirthDay());
//		System.out.println(r.getCity());
//		System.out.println(cust.getAccess().getAccessLevel());
//		System.out.println(cust);
		
//		 CriteriaQuery<Manager> cq = em.getCriteriaBuilder().createQuery(Manager.class);
//	        cq.select(cq.from(Manager.class));
//	       List<Manager> managers = em.createQuery(cq).getResultList();
//	       for(Manager man : managers) {
//	    	   System.out.println(man.getEmail());
//	    	   System.out.print("THIS MANAGERS ACCESS LEVEL: ");
//	    	   System.out.println(man.getAccess().getAccessLevel());
//	       }
//	       
//	       CriteriaQuery<Restaurant> cq = em.getCriteriaBuilder().createQuery(Restaurant.class);
//	       cq.select(cq.from(Restaurant.class));
//	       List<Restaurant> rests = em.createQuery(cq).getResultList();
//	       for(Restaurant rest : rests) {
//	    	   for (Menu menu : rest.getMenus()) {
//	    		   System.out.println("ITTERATING THROGH MENUS");
//	    		   System.out.println(menu.getType());
//	    		   System.out.println(menu.getStartTime());
//	    		   System.out.println(menu.getEndTime());
//	    	   }
//	    	   System.out.println(rest.getName());
//	    	   System.out.println(rest.getMenus().size());
//	    	   System.out.print("THIS MANAGERS ACCESS LEVEL: ");
//	    	   System.out.println(rest.getManager().getAccess().getAccessLevel());
//	       }
//	       
//	       CriteriaQuery<Menu> cq = em.getCriteriaBuilder().createQuery(Menu.class);
//	       cq.select(cq.from(Menu.class));
//	       List<Menu> menus = em.createQuery(cq).getResultList();
//	       for(Menu menu : menus) {
//	    	   for (MenuItem item : menu.getItems()) {
//	    		   System.out.println("ITTERATING THROGH Items");
//	    		   System.out.println(item.getName());
//	    		   System.out.println(item.getDescription());
//	    		   System.out.println(item.getTemp().toString());
//	    	   }
//	    	   System.out.println(menu.getType());
//	    	   System.out.println(menu.getStartTime());
//	    	   System.out.println(menu.getEndTime());
//	    	   System.out.print("_________________________________________________");
////	    	   System.out.println(rest.getManager().getAccess().getAccessLevel());
//	       }
		
		CriteriaQuery<Order> cq = em.getCriteriaBuilder().createQuery(Order.class);
	       cq.select(cq.from(Order.class));
	       List<Order> orders = em.createQuery(cq).getResultList();
	       for(Order order : orders) {
	    	   System.out.println(order.getCustomer().getEmail());
	    	   System.out.println(order.getCustomer().getAccess().getAccessLevel());
	    	   System.out.println(order.getOrderId());
	    	   System.out.println("----------------------");
	    	   for (OrderDetail od : order.getOrderDetails()) {
	    		   System.out.println("ITTERATING THROGH Menu_Items");
	    		   System.out.println("----------------------");
	    		   System.out.println(od.getMenuItem().getName());
	    		   System.out.println(od.getMenuItem().getDescription());
	    		   System.out.println(od.getQuantity());
	    		   System.out.println("\t\t" + od.getOrder().getOrderId());
	    		   System.out.println("\t\t" + od.getOrder().getCustomer().getEmail());
	    		   System.out.println("\t\t" + od.getMenuItem().getMenu().getStartTime());
	    		   System.out.println("\t\t" + od.getMenuItem().getTemp());
	    		   System.out.println("\t\t" + od.getMenuItem().getMenu().getRestaurant().getName());
	    		   System.out.println("\t\t" + od.getMenuItem().getMenu().getRestaurant().getManager().getEmail());
	    		   System.out.println("\t\t" + od.getMenuItem().getMenu().getRestaurant().getManager().getAccess().getAccessLevel());
	    		   
	    	   }         
	    	   
	    	   System.out.print("_________________________________________________");
//	    	   System.out.println(rest.getManager().getAccess().getAccessLevel());
	       }
	       
		
//		Manager manager = em.
		
		
	}
}