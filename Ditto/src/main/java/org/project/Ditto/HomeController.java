package org.project.Ditto;

import java.text.DateFormat;
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
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	@RequestMapping(value="/postDeed",method=RequestMethod.POST)
	public ModelAndView postDeedHere(@RequestParam(value="deed") String d_deed,
			@RequestParam(value="u_name") String u_name,@RequestParam(value="u_pass") String u_pass) {
		ModelAndView mnv = new ModelAndView("home");
		Dto_Users userFresh = userService.getUser(u_name, u_pass);
		Deeds freshDeed = deedService.createDeed(d_deed,userFresh.getU_id());
		//adding a fresh deed to the page without any user linked to it.
		mnv.addObject("deed",freshDeed);
		mnv.addObject("user", userFresh);
		mnv.addObject("deedList", deedService.getAllDeeds());
	
		
		return mnv;
	}
	
	@RequestMapping(value="/loginEx", method= RequestMethod.POST)
	public ModelAndView loginRead(@RequestParam(value="u_name") String u_name,
			@RequestParam(value="u_pass") String u_pass) {
		ModelAndView mnv = new ModelAndView("home");
		System.err.println(u_name+" || "+u_pass);
		if(userService.searchUser(u_name, u_pass)) {
			Dto_Users user = userService.getUser(u_name, u_pass);
			mnv.addObject("user", user);
		}
		mnv.addObject("deedList", deedService.getAllDeeds());
		
		return mnv;
	}
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public ModelAndView home() {
		/*logger.info("Welcome home! The client locale is {}.", locale);*/
		
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
		
/*		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		String formattedDate = dateFormat.format(date);
		mnv.addObject("serverTime", formattedDate );*/
		
		/*model.addAttribute("deeds", deedsList);*/
		
		return mnv;
	}
	
}
