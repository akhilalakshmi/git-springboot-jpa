package com.example.securityassignment.service;

import java.util.List;

import com.example.securityassignment.model.Msg;

public interface MsgService {
	Msg createOrUpdateMsg(Msg msg);
	List<Msg> getAllMsgs();
	Msg getMsg(Integer msgid);

}
