package controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import data.GrubDAO;
import entities.LogInCredentials;

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

	@RequestMapping(path = "setManagerLoginCredentials.do", method = RequestMethod.POST)
	public ModelAndView setManagerCredentials(@ModelAttribute("personCred") LogInCredentials login, String user_name, String password, String restaurant) {
		ModelAndView mv = new ModelAndView("managerhome.jsp");
		login.setUser_name(user_name);
		login.setPassword(password);
		grubDAO.checkManagerCred(login, restaurant);

		
		mv.addObject("personCred", login);
		return mv;
	}

	public ModelAndView getCustomerList(@RequestParam("") String n) {
		ModelAndView mv = new ModelAndView();

		mv.setViewName("jsp");
		mv.addObject("", n);
		return mv;
	}
}
