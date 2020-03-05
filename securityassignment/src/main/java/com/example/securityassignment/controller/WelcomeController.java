package com.example.securityassignment.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.securityassignment.model.Users;


@Controller
public class WelcomeController {

    @PreAuthorize("hasAnyRole('ADMIN')")

    @RequestMapping(value = "/register", method = RequestMethod.GET)
	public String createUser(ModelMap model) {
		model.addAttribute("user", new Users());
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
