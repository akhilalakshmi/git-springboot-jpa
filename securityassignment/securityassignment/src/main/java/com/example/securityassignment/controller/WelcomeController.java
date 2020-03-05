package com.example.securityassignment.controller;

import java.time.LocalDateTime;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.securityassignment.model.Users;
import com.example.securityassignment.repository.UserRepository;




@Controller
public class WelcomeController {
	@Autowired
	UserRepository userrepo;

  

    @RequestMapping(value = "/register", method = RequestMethod.GET)
	public String createUser(ModelMap model) {
		model.addAttribute("user", new Users());
		return "registration";
	}
    @RequestMapping(value = "/reguser", method = RequestMethod.POST)
	public String createUser(ModelMap model, @Valid Users user, BindingResult result) {
		

    	        user.getRoles().add(new com.example.securityassignment.model.Role("USER"));
				userrepo.save(user);	
				model.addAttribute("user", new Users());
				model.addAttribute("msg", "Registration succeeded!");
	
		return "registration"; 
	}
    
	/*@RequestMapping(value = "/login", method = RequestMethod.GET)
    public String login(Model model, String error, String logout) {
        if (error != null) {
        	model.addAttribute("error", error);
            model.addAttribute("msg", "Your username and password are invalid!");
        }

        if (logout != null) {
        	model.addAttribute("error", null);
            model.addAttribute("msg", "You have been logged out successfully!");
        }

        return "login";
    }*/
    @GetMapping( "/login")
	public String loginpage(){

		return "login";
	}
 
}
