package com.fireduptech.springDemo.controller;

/*import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
*/

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class BaseController {
	

	private static int counter = 0;
	private static final String VIEW_INDEX = "index";

/*
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String welcome( ModelMap model ) {

		model.addAttribute( "message", "Welcome" );
		model.addAttribute( "counter", ++counter );

		// Spring uses InternalResourceViewResolver and returns back index.jsp
		return VIEW_INDEX;
	}


	@RequestMapping(value = "/{name}", method = RequestMethod.GET)
	public String welcomeName( @PathVariable String name, ModelMap model ) {

		model.addAttribute( "message", "Welcome " + name );
		model.addAttribute( "counter", ++counter );

		return VIEW_INDEX;
	}
*/

	@RequestMapping("home")
	public ModelAndView home() {
            return new ModelAndView("home");
	}

	
        @RequestMapping("name")
        public String nameTest() {
            return "nameView";
        }
        
}
