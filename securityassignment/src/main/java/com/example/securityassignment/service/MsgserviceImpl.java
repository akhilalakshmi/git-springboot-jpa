package com.example.securityassignment.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.securityassignment.model.Msg;
import com.example.securityassignment.repository.MsgRepository;

@Service
public class MsgserviceImpl implements MsgService {
	@Autowired
	MsgRepository msgRepo;

	@Override
	public Msg createOrUpdateMsg(Msg msg) {
		// TODO Auto-generated method stub
		return msgRepo.save(msg);
	}

	@Override
	public List<Msg> getAllMsgs() {
		// TODO Auto-generated method stub
		return msgRepo.findAll();
	}

	@Override
	public Msg getMsg(Integer msgid) {
		// TODO Auto-generated method stub
		return msgRepo.findById(msgid).get();
	}

}
