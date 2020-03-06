package com.example.securityassignment.service;

import java.util.Optional;

import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Repository;

import com.example.securityassignment.model.Users;

public interface InterfaceCustomUserDetailsService extends UserDetailsService {
	Optional<Users> findByUsername(String username);
	Optional<Users> getUserById(Integer id);	
	Users createOrUpdateUser(Users user);

}
