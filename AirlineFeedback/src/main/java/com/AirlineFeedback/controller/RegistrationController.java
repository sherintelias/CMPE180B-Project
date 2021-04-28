package com.AirlineFeedback.controller;
 
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.AirlineFeedback.bean.User;
import com.AirlineFeedback.dao.UserDao;
 
@Controller
public class RegistrationController {
  @Autowired
  public UserDao userDao;

  @RequestMapping(value = "/register", method = RequestMethod.GET)
  public ModelAndView showRegister(HttpServletRequest request, HttpServletResponse response) {
	  System.out.println("inside controller");
    ModelAndView mav = new ModelAndView("register");
    mav.addObject("user", new User());

    return mav;
  }

	
	  @InitBinder public void initBinder(WebDataBinder binder) { SimpleDateFormat
	  sdf = new SimpleDateFormat("yyyy-MM-dd"); sdf.setLenient(true);
	  binder.registerCustomEditor(Date.class, new CustomDateEditor(sdf, true)); }
	 
  @RequestMapping(value = "/registerProcess", method = RequestMethod.POST)
  public ModelAndView addUser(HttpServletRequest request, HttpServletResponse response,
		  @ModelAttribute("user") @Valid User user,  BindingResult result) {
	  System.out.println("inside controller process");
	  if(result.hasErrors()) {
		  return new ModelAndView("register");
	  }
		  
	  userDao.register(user);

	  return new ModelAndView("welcome", "firstname", user.getName());
  }
}