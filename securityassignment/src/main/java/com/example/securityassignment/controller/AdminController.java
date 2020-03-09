package com.example.securityassignment.controller;

import java.time.format.DateTimeFormatter;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.securityassignment.helper.AuthenticationHelper;
import com.example.securityassignment.model.Users;
import com.example.securityassignment.service.MsgService;
import com.example.securityassignment.service.UserService;

@Controller
public class AdminController {
	@Autowired
	private UserService icustomuserservice;
	@Autowired
	private MsgService icustommsgservice;
	
	@GetMapping("/profileadmin")
	public String userProfile(ModelMap model) {
		model.addAttribute("user", icustomuserservice.findByName(AuthenticationHelper.getAuthenticatedUsername()));
		return "/admin/profile";
	}
	@RequestMapping(value = "/updateadmin", method = RequestMethod.POST)
	public String userProfile(ModelMap model, @Valid @ModelAttribute("user") Users user, BindingResult result) {
		System.out.println(user.getId()+"===========userid"+user.getName());
		Users dbUser = icustomuserservice.getUserById(user.getId());
		System.out.println(user.getName()+"*****");
		dbUser.setName(user.getName());
		dbUser.setPassword(user.getPassword());
		dbUser.setEmail(user.getEmail());
		icustomuserservice.createOrUpdateUser(dbUser);
		model.addAttribute("user", dbUser);
		model.addAttribute("msg", "Updated successfully!");
		return "admin/profile";
	}
	@RequestMapping(value = "/showalluser", method = RequestMethod.GET)
	public String ListMessages(ModelMap model) {
	
		model.put("users", icustomuserservice.getAllUsers());
		return "admin/alluser";
	}
	
	@GetMapping("/updateUserdetails")
	public String adminProfileEditAll(ModelMap model,@RequestParam Integer id) {

		model.addAttribute("dbUser", icustomuserservice.getUserById(id));
		return "/admin/editdetails";
	}
	@RequestMapping(value = "/editUser", method = RequestMethod.POST)
	public String editUserByAdmin(ModelMap model, @Valid @ModelAttribute("dbUser") Users user, BindingResult result) {
		System.out.println(user.getId()+"===========userid"+user.getName());
		Users dbUser = icustomuserservice.getUserById(user.getId());
		System.out.println(user.getName()+"*****");
		dbUser.setName(user.getName());
		dbUser.setPassword(user.getPassword());
		dbUser.setEmail(user.getEmail());
		icustomuserservice.createOrUpdateUser(dbUser);
		model.put("users", icustomuserservice.getAllUsers());
		return "admin/alluser";
	}
	
	
	
	@GetMapping("/deleteUser")
	public String adminProfileDelete(ModelMap model,@RequestParam Integer id) {
		icustomuserservice.deleteUser(icustomuserservice.getUserById(id));
		model.put("users", icustomuserservice.getAllUsers());
		return "admin/alluser";
	}
	
	@RequestMapping(value = "/viewmessage", method = RequestMethod.GET)
	public String viewmsg(ModelMap model) {
		model.put("msglist", icustommsgservice.getAllMsgs());
		return "admin/allmsgs";
	}
	
	
	@RequestMapping(value ="/getContent", method = RequestMethod.GET)
	public String viewContent(ModelMap model,@RequestParam String msgid) {
		 Integer id=Integer.parseInt(msgid);
		model.put("msgctnt", icustommsgservice.getMsg(id));
		return "admin/content";
	}
}
