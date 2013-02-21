package com.crystalforge.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.crystalforge.dao.interfaces.TestDupa;
import com.crystalforge.dao.interfaces.UserDao;
import com.crystalforge.model.User;


@Controller
@RequestMapping(value = "/controller")
public class HelloWorldController {
	
	 
	private UserDao userDao;
	private TestDupa testDupa;
	
	
	@Autowired
    public void setTestDupa(TestDupa testDupa) {
		this.testDupa = testDupa;
	}

	@Autowired
	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}

	@RequestMapping(method = RequestMethod.GET)
    @ResponseBody
    public String home() {
        System.out.println("HomeController: Passing through...");
       // return "WEB-INF/views/home.jsp";
        
        User user = new User();
        user.setName("Piotr");
        
        userDao.saveUser(user);
        
    	return testDupa.dupa();
    }

}