package data;

import java.sql.Timestamp;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaQuery;

import org.springframework.transaction.annotation.Transactional;

import client.LogInCredentials;
import client.Person;
import entities.Customer;
import entities.Manager;
import entities.Menu;
import entities.Order;
import entities.OrderDetail;
import entities.Restaurant;

@Transactional
public class GrubRestaurantDAO implements GrubDAO {
	@PersistenceContext
	private EntityManager em;
	
	
	
	public Order buildOrder(LogInCredentials login, Order order, String s) {
		String[] tokens = s.split("&&");
		Menu menu = findMenuById(Integer.parseInt(tokens[0]));
		System.out.println(Timestamp.from(Instant.now()));
		order.setDateOrdered(Timestamp.from(Instant.now()));
		order.setStatus("pending");
		List<OrderDetail> orderDetails = new ArrayList<>();
		for (int i = 1; i<tokens.length; i++) {
			OrderDetail od = new OrderDetail();
			od.setMenuItem(menu.getMenuItemByID(Integer.parseInt(tokens[i])));
			od.setLineItem(i);
			od.setQuantity(1);
			orderDetails.add(od);
		}
		order.setOrderDetails(orderDetails);
		
//		order.setDateOrdered();
		if(login.getPersonLoggedIn() instanceof Customer) {
			order.setCustomer(((Customer)login.getPersonLoggedIn()));
			((Customer)login.getPersonLoggedIn()).addPendingOrder(order);
		}
		return order;
	}
	public Menu getUserSelectedMenu(String s) {
		String[] tokens = s.split("&&");
		Menu menu;
		menu = em.find(Restaurant.class, Integer.parseInt(tokens[0])).getMenu(tokens[1]);
//		for (MenuSection ms : menu.getMenuSections(menu.getItems())) {
//			System.out.println(ms.getSection() + "\t\t FROM DAO");
//		}
		return menu = em.find(Restaurant.class, Integer.parseInt(tokens[0])).getMenu(tokens[1]);
	}
	
	public LogInCredentials checkUserCred (LogInCredentials login) {
//		System.out.println("IN CHECKUSER ID");
		CriteriaQuery<Manager> cq = em.getCriteriaBuilder().createQuery(Manager.class);
	       cq.select(cq.from(Manager.class));
	       List<Person> peeps = new ArrayList<>();
	       peeps.addAll(em.createQuery(cq).getResultList());
	       
	       CriteriaQuery<Customer> cqC = em.getCriteriaBuilder().createQuery(Customer.class);
	       cqC.select(cqC.from(Customer.class));
	       peeps.addAll(em.createQuery(cqC).getResultList());
 
	       //Check Restaurants list here for matching email
	       for (Person peep : peeps) {
//	    	   System.out.println(peep.getEmail());
	    	   if (peep.getEmail().equalsIgnoreCase(login.getUser_name())) {
	    		   if (peep.getPassword().equals(login.getPassword())) {
	    			   login.setAccessID(peep.getAccess().getAccessLevel());
	    			   login.setPersonLoggedIn(peep);
	    			   return login;
	    		   } else continue;
	    	   }else continue;
	       }
		//Check Managers List @email for matching password
		login.setUser_name("PLEASE TRY AGAIN HACKER");
		login.setPassword("notAPass");
		login.setAccessID(10);
		login.setPersonLoggedIn(null);
		
		return login;
	}
	
	public List<Restaurant> browseAllRestaurants() {
		CriteriaQuery<Restaurant> cq = em.getCriteriaBuilder().createQuery(Restaurant.class);
	       cq.select(cq.from(Restaurant.class));
	       List<Restaurant> rests = em.createQuery(cq).getResultList();
//		System.out.println(rests.getClass().getName());
		return rests;
	}
	
	public Menu findMenuById(int i) {
		CriteriaQuery<Menu> cq = em.getCriteriaBuilder().createQuery(Menu.class);
			cq.select(cq.from(Menu.class));
			List<Menu> menus = em.createQuery(cq).getResultList();
			for(Menu menu : menus) {
				if(menu.getMenuId() == i) {
					return menu;
				} else continue;
			}
			System.out.println("COULDN'T FIND A MENU MATCH IN DAO findMenuById");
			return null;
	}
}
