package com.example.securityassignment.controller;

import java.time.LocalDateTime;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


import com.example.securityassignment.model.Role;
import com.example.securityassignment.model.Users;
import com.example.securityassignment.repository.UserRepository;
import com.example.securityassignment.service.InterfaceCustomUserDetailsService;
import com.example.securityassignment.helper.AuthenticationHelper;




@Controller
public class WelcomeController {

	@Autowired
	private InterfaceCustomUserDetailsService icustomuserservice;

  

    @RequestMapping(value = "/registeruser", method = RequestMethod.GET)
	public String regUser(ModelMap model) {
		model.addAttribute("user", new Users());
		model.addAttribute("roletype", "ROLE_USER");
		return "registration";
	}
    @RequestMapping(value = "/registeradmin", method = RequestMethod.GET)
  	public String regadmin(ModelMap model) {
  		model.addAttribute("user", new Users());
  		model.addAttribute("roletype", "ROLE_ADMIN");
  		return "registration";
  	}

 
    @RequestMapping(value = "/adduser", method = RequestMethod.POST)
 	public String createAdmin(ModelMap model, @Valid Users user, BindingResult result,@RequestParam String rolename) {
 		
                          
     	        user.getRoles().add(new Role(rolename));
     	       icustomuserservice.createOrUpdateUser(user);
 				model.addAttribute("user", new Users());
 				model.addAttribute("msg", "Registration succeeded!");
 	
 		return "registration"; 
 	}
    
    @GetMapping( "/login")
	public String loginpage(){

		return "login";
	}
    @GetMapping( "/user/success")
	public String userpage(){

		return "/user/userpage";
	}
    
  	@GetMapping("/profile")
	public String userProfile(ModelMap model) {
		model.addAttribute("user", icustomuserservice.findByUsername(AuthenticationHelper.getAuthenticatedUsername()).get());
		return "/user/profile";
	}
  	
	@RequestMapping(value = "/updateuser", method = RequestMethod.POST)
	public String userProfile(ModelMap model, @Valid @ModelAttribute("user") Users user, BindingResult result) {
	
		Users dbUser = icustomuserservice.getUserById(user.getId()).get();
		
		dbUser.setName(user.getName());
		dbUser.setPassword(user.getPassword());
		dbUser.setEmail(user.getEmail());
		icustomuserservice.createOrUpdateUser(dbUser);
		
		model.addAttribute("user", dbUser);
		model.addAttribute("msg", "Updated successfully!");
		 
		return "/user/user-profile";
	}
	

}
