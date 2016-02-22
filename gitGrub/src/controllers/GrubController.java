package controllers;

import java.sql.Timestamp;
import java.time.Instant;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import client.LogInCredentials;
import data.GrubDAO;
import entities.Order;

@Controller
@SessionAttributes({"personCred", "orderList"})
public class GrubController {
	@Autowired
	private GrubDAO grubDAO;

	@ModelAttribute("personCred")
	public LogInCredentials setPersonCred() {
		LogInCredentials login = new LogInCredentials();
		return login;
	}

	@ModelAttribute("orderList")
	public Order initOrderList() {
		Order order = new Order();
		return order;
	}
	
	@RequestMapping(path="activeorder.do")
	public ModelAndView displayActiveOrders(@ModelAttribute("personCred")LogInCredentials login, @ModelAttribute("orderList") Order order) {
		ModelAndView mv = new ModelAndView("order.jsp");
		//THIS NEEDS TO BE WORKED ON
		mv.addObject("Order", order);
		return mv; //CHANGE THIS
	}
	
	@RequestMapping(path="deactivate.do")
	public ModelAndView deactivateUser(@ModelAttribute("personCred")LogInCredentials login) {
		ModelAndView mv = new ModelAndView("index.jsp");
		if(login.getPersonLoggedIn() !=null) {
			grubDAO.deactivateAndEraseCustomer(login);
			String log = "You have been D.E.L.E.T.E.D go f yourself";
			mv.addObject("message", log);
			return mv;
		}
		else {
			String log = "You must be logged in to delete yourself...";
			mv.addObject("message", log);
			return mv;
		}
	}
	
	@RequestMapping(path="logout.do", method=RequestMethod.GET)
	public ModelAndView logoutFromGitGrub(@ModelAttribute("personCred")LogInCredentials login) {
		login.setAccessID(0);
		login.setPassword("ERRAH");
		login.setUser_name("NotAUser");
		login.setPersonLoggedIn(null);
		String log = "You have been successfully logged out";
		ModelAndView mv = new ModelAndView("index.jsp");
		mv.addObject("message", log);
		return mv;
	}
	@RequestMapping(path="managerhome.do", method=RequestMethod.GET)
	public ModelAndView managerDashboard(@ModelAttribute("personCred")LogInCredentials login) {
		if(login.getAccessID()<2 && login.getAccessID()>0) {
			ModelAndView mv = new ModelAndView("managerhome.jsp");
			return mv;
		}
		else {
			ModelAndView mv = new ModelAndView("index.jsp");
			return mv;
		}
	}
	
	@RequestMapping(path="deliver.do", method=RequestMethod.POST)
	public ModelAndView deliverOrder(@ModelAttribute("personCred") LogInCredentials login, @RequestParam("orderid") String s) {
		if(login.getAccessID()<2 && login.getAccessID()>0) {	
			ModelAndView mv = new ModelAndView("restaurantorders.jsp");
			System.out.println(s);
			grubDAO.submitAndFinalizeOrder(login, grubDAO.searchAllOrders(s));
			List<Order> orders = grubDAO.getSubmittedOrders(login);
			if (orders.size()>0) {
				mv.addObject("submittedOrders", orders);
			} else {
				String Empty = login.getRestaurant().getName() + " Has no Submitted Orders";
				System.out.println("WE HAVE A NO ORDER RETURNED");
				mv = new ModelAndView("managerhome.jsp");
				mv.addObject("EmptyString", Empty);
			}
			return mv;
		} else {
			System.out.println(login.getAccessID());
			ModelAndView mv = new ModelAndView("index.jsp");
			return mv;
		}
	}
	
	@RequestMapping(path="restaurantorders.do") //, path = RequestMethod.Post)
	public ModelAndView viewSubmittedOrders(@ModelAttribute("personCred") LogInCredentials login, @ModelAttribute("orderList") Order order) {
		if(login.getAccessID()<2 && login.getAccessID()>0) {
			ModelAndView mv = new ModelAndView("restaurantorders.jsp");
			List<Order> orders = grubDAO.getSubmittedOrders(login);//, order);
			if (orders.size()>0) {
				mv.addObject("submittedOrders", orders);
			} else {
				String Empty = login.getRestaurant().getName() + " Has no Submitted Orders";
				System.out.println("WE HAVE A NO ORDER RETURNED");
				mv = new ModelAndView("managerhome.jsp");
				mv.addObject("EmptyString", Empty);
			}
			return mv;
		}
		else {
			System.out.println(login.getAccessID());
			ModelAndView mv = new ModelAndView("index.jsp");
			return mv;
		}
	}
	
	@RequestMapping(path="submitorder.do", method = RequestMethod.POST)
	public ModelAndView submitOrder(@ModelAttribute("personCred") LogInCredentials login, @ModelAttribute("orderList") Order order) {
		System.out.println("IN SUBMIT ORDER");
//		System.out.println(login.getPersonLoggedIn().getEmail());
		ModelAndView mv = new ModelAndView("custhome.jsp");
		grubDAO.submitAndFinalizeOrder(login,order);
		System.out.println("Back from Finalizing Order");
		return mv;
	}
	@RequestMapping(path="createorder.do", method = RequestMethod.POST)
	public ModelAndView buildOrder(@ModelAttribute("personCred") LogInCredentials login, @ModelAttribute("orderList") Order order, @RequestParam("orderinfo") String info) {
		System.out.println(info);
		System.out.println("STRING SENT FROM MENU.JSP");
		ModelAndView mv = new ModelAndView("order.jsp");
		order = grubDAO.buildOrder(login, order, info);
		
		mv.addObject("Order", order);
		System.out.println(order.getStatus() + order.getCustomer() + "OOOOOOOOOOOO" + order.getOrderDetails().size() + order.getOrderDetails().get(0).getOrder());
		return mv;
	}
	
	@RequestMapping(path="menu.do", method = RequestMethod.POST)
	public ModelAndView displayRestaurantsMenu(@RequestParam("menuchoice") String s) {
		ModelAndView mv = new ModelAndView("menu.jsp");
		mv.addObject("Menu", grubDAO.getUserSelectedMenu(s));
		mv.setViewName("menu.jsp");
		System.out.println(Timestamp.from(Instant.now()));
		return mv;
	}

	@RequestMapping(path="browse.do") //, method = RequestMethod.POST)
	public ModelAndView browseRestaurants() {
		ModelAndView mv = new ModelAndView("browse.jsp");
		mv.addObject("restList", grubDAO.browseAllRestaurants());
		return mv;
	}
	@RequestMapping(path = "logincredentials.do", method = RequestMethod.POST)
	public ModelAndView setManagerCredentials(@ModelAttribute("personCred") LogInCredentials login, String user_name, String password, String restaurant) {
		ModelAndView mv = new ModelAndView();
		login.setUser_name(user_name);
		login.setPassword(password);
		login = grubDAO.checkUserCred(login);
		switch(login.getAccessID()) {
			case 1: {
					mv.addObject("manager", login);
					mv.setViewName("managerhome.jsp");
				break;
			}
			case 2: {
					mv.addObject("customer", login);
					mv.setViewName("custhome.jsp");
				break;
			}
			case 10: {
					mv.addObject("ERROR", login);
					mv.setViewName("index.jsp");
				break;
			}
			default: {
				System.out.println("HUGE FRIGGIN MISTAKE IN LOGIN SWITCH");
				mv.setViewName("index.jsp");
			}
		
		}
		return mv;
	}	

	public ModelAndView getCustomerList(@RequestParam("") String n) {
		ModelAndView mv = new ModelAndView();

		mv.setViewName("jsp");
		mv.addObject("", n);
		return mv;
	}
}
