package controllers;

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
	public String initOrderList() {
		//HERE WE WILL INIT AN ORDER ENTITY
		//THE ORDER ENTITY HAS A LIST OF ORDER DETAIL OBJECTS
		String s = "Order Entity Instantiation";
		return s;
	}

	@RequestMapping(path="browse.do", method = RequestMethod.POST)
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
