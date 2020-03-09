package com.example.securityassignment.service;

import java.util.List;
import java.util.Optional;

import com.example.securityassignment.model.Users;

public interface UserService  {
	

	List<Users> getAllUsers();
	//Optional<Users> getUserById(Integer id);	
	Users getUserById(Integer id);	
	Optional<Users> getAuthenticatedUser(Users user);
	Users createOrUpdateUser(Users user);
	void deleteUser(Users user);
	Users findByName(String userName);
	List<Users> findByList(String userName);
}
