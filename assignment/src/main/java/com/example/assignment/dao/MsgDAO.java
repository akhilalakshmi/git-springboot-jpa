package com.example.assignment.dao;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.assignment.pojo.Msg;
import com.example.assignment.pojo.User;
import com.example.assignment.repository.MsgRepository;

@Service
@Transactional
public class MsgDAO {
	
	@Autowired
	private final MsgRepository msgrepo;
	
	public MsgDAO(MsgRepository msgrepo) {
		this.msgrepo=msgrepo;
	}
		public void savemsg(Msg msg) {
		msgrepo.save(msg);
		
	}
		
		public List<Msg> findallMsg() {
			List<Msg> msgs=new ArrayList<Msg>();
			
			msgs=msgrepo.findAll();
		
			return msgs;
		}

}
