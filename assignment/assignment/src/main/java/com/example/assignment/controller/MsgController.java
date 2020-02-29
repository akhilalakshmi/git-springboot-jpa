package com.example.assignment.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.assignment.dao.MsgDAO;
import com.example.assignment.pojo.Msg;

@Controller
public class MsgController {
	@Autowired
	MsgDAO msgdao;
	@Autowired
	Msg msg;
	
	
	@GetMapping("/sendmessage")
	public String sendmessage() {
				return "user/sendmsg";
	}
	
	@PostMapping("/msgsending")
    public String msgsending(HttpServletRequest req,@RequestParam String subnam,@RequestParam String msgcontent){
return "user/userpage";
	}

}
