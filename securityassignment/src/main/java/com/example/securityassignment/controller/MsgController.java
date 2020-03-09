package com.example.securityassignment.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.example.securityassignment.helper.AuthenticationHelper;
import com.example.securityassignment.model.Msg;
import com.example.securityassignment.model.Users;
import com.example.securityassignment.service.MsgService;
import com.example.securityassignment.service.UserService;

@Controller
public class MsgController {
	@Autowired
	private MsgService icustommsgservice;

	@Autowired
	private UserService icustomuserservice;

	
	
	@RequestMapping(value = "/sendmessage", method = RequestMethod.GET)
	public String regUser(ModelMap model) {
		model.addAttribute("user", icustomuserservice.findByName(AuthenticationHelper.getAuthenticatedUsername()));
		model.addAttribute("msg", new Msg());
		return "user/sendmsg";
	}
	@RequestMapping(value = "/msgsending", method = RequestMethod.POST)
	public String addmsg(ModelMap model, @Valid Msg msg) {
		
	 Users user=(Users)icustomuserservice.findByName(AuthenticationHelper.getAuthenticatedUsername());
		
		msg.setUser(user);
		icustommsgservice.createOrUpdateMsg(msg);
		model.addAttribute("sucessmsg", "Message send");
		model.addAttribute("msg", new Msg());
		return "user/sendmsg";
	}
	

}
