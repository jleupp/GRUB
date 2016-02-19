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
	
	public void submitAndFinalizeOrder(LogInCredentials login, Order order) {
		System.out.println("IN SUBMIT AND FINALIZE ORDER");
		//Set Pending order Status to Submitted
		order.setStatus("submitted");
		//Get a managed customer Bean
		Customer p = em.find(Customer.class, login.getPersonLoggedIn().getEmail());
		
		System.out.println(em.contains(p) + " " + p.getClass() + " is a managed object");
		
		//Add the restaurant ordered from to customers previous restaurant list and add order
		//to previous orders list		
		p.addNewRestaurant(login.getPersonLoggedIn().getPendingOrder());
		p.addOrder(order);
		//Get a managed Restaurant Bean
		Restaurant r = em.find(Restaurant.class, login.getPersonLoggedIn().getPendingOrder().getOrderDetails().get(0).getMenuItem().getMenu().getRestaurant().getId());
		//Add customer to restaurants Customer List
		r.addCustomer(p);
		//Merge updated customer and restaurant Beans [UPDATE] & Persist the Order and Order_Details submitted from user [CREATE]
		try {
			System.out.println("Prior to merge cascade of Customer - Order - OrderItem");
			em.merge(p);
			em.merge(r);
		} catch(Exception e) {
			System.out.println("ERRAH IN THE SUBMIT MERGE");
			System.out.println(e.getMessage());
		}

		// persit the created order to the db, this cascades all the included order items [CREATE]
	}
	
	public Order buildOrder(LogInCredentials login, Order order, String s) {
		String[] tokens = s.split(",");
		Menu menu = findMenuById(Integer.parseInt(tokens[0]));
		System.out.println(Timestamp.from(Instant.now()));
		order.setDateOrdered(Timestamp.from(Instant.now()));
		order.setStatus("pending");
//		order.setOrderId(0);
		List<OrderDetail> orderDetails = new ArrayList<>();
		
		System.out.println(order.getStatus());
		
		for (int i = 1; i<tokens.length; i++) {
		System.out.println("TIME THROUGH " + i);
			
				System.out.println(i + " TIME THROUGH ADD ORDER DETAIL LOOP");
				OrderDetail od2 = new OrderDetail();
				od2.setMenuItem(menu.getMenuItemByID(Integer.parseInt(tokens[i])));
				od2.setLineItem(i);
				od2.setQuantity(1);
				
				orderDetails.add(od2);
				System.out.println(od2.getLineItem());
				System.out.println("XXXXXXX" + od2.getMenuItem().getId() + "XXXXXXX");
				od2.setFUCKINGORDER(order);
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
