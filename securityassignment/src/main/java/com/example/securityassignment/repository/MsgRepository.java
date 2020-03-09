package com.example.securityassignment.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.securityassignment.model.Msg;

public interface MsgRepository extends JpaRepository<Msg, Integer>{
	

}
