package com.example.assignment.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.assignment.dao.UserDAO;
import com.example.assignment.pojo.User;

@Controller
public class WelcomeController {
	@Autowired
	private User user;
	@Autowired
	private UserDAO userdao;
	
	@GetMapping("/reg")
	public String reguser() {
				return "registration";
	}
	@PostMapping("/reguser")
	public String saveuser(HttpServletRequest req,@RequestParam String name,@RequestParam String password,@RequestParam String address) {
		String role="user";
		user=new User();
		user.setName(name);
		user.setPassword(password);
		user.setAddress(address);
		user.setRole(role);
		userdao.saveUser(user);
	
		return "index";
	}	 
	@PostMapping("/login")
    public String showLoginPage(HttpServletRequest req,@RequestParam String name,@RequestParam String password){
	//System.out.println(name+" "+password);
	user=userdao.findByNameAndPassword(name, password);
	HttpSession session=req.getSession();
	if(user!=null&&user.getRole().equals("admin")){
		req.setAttribute("userdet",user);
		addUserInSession(user, session);

		  return "admin/adminpage";
	}
	else if(user!=null&&user.getRole().equals("user")) {
		req.setAttribute("userdet",user);
		addUserInSession(user, session);
				return "user/userpage";
	}
	else {
		req.setAttribute("error","Invalid Username or password");
		return "index";
	}
   
  }
	@GetMapping("/profile")
		public String profile(HttpServletRequest req) {
		HttpSession session=req.getSession();
		String sessionid=(String)session.getAttribute("id");
		int id =Integer.parseInt(sessionid);
		User user=userdao.findById(id);
		req.setAttribute("userdet",user);
		
			return "user/profile";
	}
	@GetMapping("/profileadmin")
	public String profileadmin(HttpServletRequest req) {
	HttpSession session=req.getSession();
	String sessionid=(String)session.getAttribute("id");
	int id =Integer.parseInt(sessionid);
	User user=userdao.findById(id);
	req.setAttribute("userdet",user);
	
		return "admin/profile";
}
	  private void addUserInSession(User obj,HttpSession session){
	        session.setAttribute("name", obj.getName());
	       String sessid=String.valueOf(obj.getId());
	        session.setAttribute("id", sessid);
	    }

		@PostMapping("/updateuser")
		public String updateuser(HttpServletRequest req,@RequestParam String name,@RequestParam String password,@RequestParam String address) {
			String role="user";
			HttpSession session=req.getSession();
			String sessionid=(String)session.getAttribute("id");
			int id =Integer.parseInt(sessionid);
			user.setId(id);
			user.setName(name);
			user.setPassword(password);
			user.setAddress(address);
			user.setRole(role);
			userdao.saveUser(user);
			return "user/userpage";
	}
		
		@PostMapping("/updateadmin")
		public String updateadmin(HttpServletRequest req,@RequestParam String name,@RequestParam String password,@RequestParam String address) {
			String role="admin";
			HttpSession session=req.getSession();
			String sessionid=(String)session.getAttribute("id");
			int id =Integer.parseInt(sessionid);
			user.setId(id);
			user.setName(name);
			user.setPassword(password);
			user.setAddress(address);
			user.setRole(role);
			userdao.saveUser(user);
			return "admin/adminpage";
	}
		@GetMapping("/showalluser")
	    public String showUsers(HttpServletRequest req) {
		List<User> users=userdao.findallUser();
		req.setAttribute("userlist", users);
	    return "admin/alluser";
		
	    }
		

		@GetMapping("/updateUserdetails")
	    public String updateUser(HttpServletRequest req,@RequestParam int id) {
		User user=userdao.findById(id);
		req.setAttribute("userdetails", user);
	    return "admin/editdetails";
	    }	
		@PostMapping("/editUser")
		public String edituser(HttpServletRequest req,@RequestParam int id,@RequestParam String name,@RequestParam String password,@RequestParam String address) {
			String role="user";
			user.setId(id);
			user.setName(name);
			user.setPassword(password);
			user.setAddress(address);
			user.setRole(role);
			userdao.saveUser(user);
			List<User> users=userdao.findallUser();
			req.setAttribute("userlist", users);
			return "admin/alluser";
		}
		@GetMapping("/deleteUser")
	    public String deleteUser(HttpServletRequest req,@RequestParam int id) {
		userdao.deleteUser(id);
		List<User> users=userdao.findallUser();
		req.setAttribute("userlist", users);
	    return "admin/alluser";
	    }
		

}


