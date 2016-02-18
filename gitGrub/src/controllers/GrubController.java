package controllers;

import java.sql.Timestamp;
import java.time.Instant;

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
	
	@RequestMapping(path="createorder.do", method = RequestMethod.POST)
	public ModelAndView buildOrder(@ModelAttribute("personCred") LogInCredentials login, @ModelAttribute("orderList") Order order, @RequestParam("orderinfo") String info) {
		System.out.println(info);
		System.out.println("STRING SENT FROM MENU.JSP");
		ModelAndView mv = new ModelAndView("order.jsp");
		order = grubDAO.buildOrder(login, order, info);
		
		mv.addObject("Order", order);
		System.out.println(order.getStatus() + order.getCustomer());
		return mv;
	}
	
	@RequestMapping(path="menu.do", method = RequestMethod.POST)
	public ModelAndView displayRestaurantsMenu(@RequestParam("menuchoice") String s) {
		ModelAndView mv = new ModelAndView("menu.jsp");
		mv.addObject("Menu", grubDAO.getUserSelectedMenu(s));
		mv.setViewName("menu.jsp");
		System.out.println(Timestamp.from(Instant.now()));
		return mv;
//		Menu menu = grubDAO.getUserSelectedMenu(s);
//		for(MenuItem item : menu.getItems()) {
//			System.out.println(item.getName() + " " + item.getDescription());
//			System.out.println("$" + item.getPrice());
//		}
//		mv.addObject("Menu", grubDAO.getUserSelectedMenu(s));
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
					mv.setViewName("index.html");
				break;
			}
			default: {
				System.out.println("HUGE FRIGGIN MISTAKE IN LOGIN SWITCH");
				mv.setViewName("index.html");
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
