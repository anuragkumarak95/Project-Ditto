package org.project.Ditto;

import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import javax.servlet.http.Cookie;

import org.project.Ditto.Models.Deeds;
import org.project.Ditto.Models.Dto_Users;
import org.project.Ditto.Services.DeedService;
import org.project.Ditto.Services.UsersService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.method.support.ModelAndViewContainer;
import org.springframework.web.servlet.ModelAndView;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	
	@Autowired
	private UsersService userService;
	@Autowired
	private DeedService deedService;
	
	@RequestMapping(value="logoutUser")
	public ModelAndView UserLogout() {
		ModelAndView mnv = new ModelAndView("home");
		mnv.addObject("deedList", deedService.getAllDeeds());
		return mnv;
	}
	
	@RequestMapping(value="/postDeed",method=RequestMethod.POST)
	public ModelAndView postDeedHere(@RequestParam(value="deed") String d_deed,
			@RequestParam(value="u_name") String u_name,@RequestParam(value="u_pass") String u_pass) {
		ModelAndView mnv = new ModelAndView("home");
		Dto_Users userFresh = userService.getUser(u_name, u_pass);
		 deedService.createDeed(d_deed,userFresh.getName());

		//adding a fresh deed to the page without any user linked to it.
		
		mnv.addObject("user", userFresh);
		mnv.addObject("deedList", deedService.getAllDeeds());
		
	
		
		return mnv;
	}
	
	@RequestMapping(value="/loginEx", method= RequestMethod.POST)
	public ModelAndView loginRead(@RequestParam(value="u_name") String u_name,
			@RequestParam(value="u_pass") String u_pass) {
		ModelAndView mnv = new ModelAndView("home");
		if(userService.searchUser(u_name, u_pass)) {
			
			Dto_Users user = userService.getUser(u_name, u_pass);
			System.err.println("[lginEx]search complete :"+user.getName()+" logged in.");
			
			mnv.addObject("user", user);
		}
		mnv.addObject("deedList", deedService.getAllDeeds());
		
		return mnv;
	}
	
	@RequestMapping(value="/signupEx", method= RequestMethod.POST)
	public ModelAndView signupRead(@RequestParam(value="u_name") String u_name,@RequestParam(value="name") String name,
			@RequestParam(value="u_pass") String u_pass) {
		ModelAndView mnv = new ModelAndView("home");
		Dto_Users new_user = userService.createUser(name, u_name, u_pass);
		
		mnv.addObject("user",new_user);
		mnv.addObject("deedList", deedService.getAllDeeds());
		
		return mnv;
	}
	
	@RequestMapping(value="/signUpUser")
	public ModelAndView signUpUser() {
		ModelAndView mnv = new ModelAndView("home");
		mnv.addObject("signupToken","yes");
		mnv.addObject("deedList", deedService.getAllDeeds());
		return mnv;
	}
	
	@RequestMapping(value="/dittoMe")
	public ModelAndView dittoMe(@RequestParam(value="d_id") int d_id,
			@RequestParam(value="u_name") String u_name) {
		ModelAndView mnv = new ModelAndView("home");
		
		Deeds deed = deedService.getDeedByID(d_id);
		deedService.incDitto(deed);
		mnv.addObject("user",userService.getUserById(u_name));
		mnv.addObject("deedList", deedService.getAllDeeds());
		return mnv;
	}
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public ModelAndView home() {
		
		
		/*
		 * testing codes here.. 
		 * 
		 * 
		 * userService.createUser("Anurag", "Kumar");
		//not working..
		Deeds deed = deedService.createDeed("Meinne kuch kiya", 1);
		
		deedService.editDeed(deed.getD_id(), "Naya Deed");
		deedService.incDitto(deedService.getDeedByID(deed.getD_id()));
		deedService.incDitto(deedService.getDeedByID(deed.getD_id()));
		deedService.incDitto(deedService.getDeedByID(deed.getD_id()));
		deedService.decDitto(deedService.getDeedByID(deed.getD_id()));
		System.err.println(deed.getD_ditto_count());
		
		deedService.deleteDeed(deed);
		
		List<Deeds> deedsList =  deedService.getAllDeeds();
		
		for(Deeds deeder : deedsList) {
			System.out.println(deeder.getD_deed()+" :: user_id :"+deeder.getD_user_id()+" dittos : "+deeder.getD_ditto_count());
		}
		
		userService.searchUser("Anurag", "Kumar");
		*/
		
		ModelAndView mnv = new ModelAndView("home");
		
		mnv.addObject("deedList", deedService.getAllDeeds());
		

		
		return mnv;
	}
	
}
