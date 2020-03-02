package com.example.assignment.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.assignment.dao.MsgDAO;
import com.example.assignment.dao.UserDAO;
import com.example.assignment.pojo.Msg;
import com.example.assignment.pojo.User;

@Controller
public class MsgController {
	@Autowired
	MsgDAO msgdao;
	@Autowired
	Msg msg;
	@Autowired
	private User user;
	@Autowired
	private UserDAO userdao;
	
	@GetMapping("/sendmessage")
	public String sendmessage() {
				return "user/sendmsg";
	}
	
	@PostMapping("/msgsending")
    public String msgsending(HttpServletRequest req,@RequestParam String subname,@RequestParam String msgcontent){
		msg=new Msg();
		HttpSession session=req.getSession();
		String sessionid=(String)session.getAttribute("id");
		int id =Integer.parseInt(sessionid);
		User user=userdao.findById(id);
		msg.setSubname(subname);
		msg.setMsgcontent(msgcontent);
		  msg.setUser(user);
		  msgdao.savemsg(msg);
          return "user/userpage";
        
	}
@GetMapping("/viewmessage")
    public String showMsgs(HttpServletRequest req) {
	List<Msg> msgs=msgdao.findallMsg();
	System.out.println("*****************");
	req.setAttribute("msglist", msgs);
    return "admin/allmsgs";
	
    }

@PostMapping("/viewcontent")
public String viewcontent(HttpServletRequest req) {
List<Msg> msgs=msgdao.findallMsg();
System.out.println("*****************");
req.setAttribute("msglist", msgs);
return "admin/allmsgs";

}
}
