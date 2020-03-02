package com.example.assignment.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;

import com.example.assignment.pojo.Msg;
import com.example.assignment.pojo.User;

public interface MsgRepository extends CrudRepository<Msg,Integer>{
	public List<Msg> findAll();
}
