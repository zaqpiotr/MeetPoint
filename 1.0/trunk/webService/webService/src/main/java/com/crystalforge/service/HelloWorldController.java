package com.crystalforge.service;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;


@Controller
@RequestMapping(value = "/controller")
public class HelloWorldController {
	
	 
	
	
       @RequestMapping(method = RequestMethod.GET)
       @ResponseBody
    public String home() {
        System.out.println("HomeController: Passing through...");
       // return "WEB-INF/views/home.jsp";
    	return "FU!";
    }

}