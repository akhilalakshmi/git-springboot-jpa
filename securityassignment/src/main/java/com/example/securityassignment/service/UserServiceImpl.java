package com.example.securityassignment.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.securityassignment.helper.AuthenticationHelper;
import com.example.securityassignment.model.Users;
import com.example.securityassignment.repository.UserRepository;
@Service
public class UserServiceImpl implements UserService{
	@Autowired
	UserRepository userRepo;

	@Override
	public List<Users> getAllUsers() {

		return userRepo.findAll();
	}

	@Override
	public Users getUserById(Integer id) {
	
		return userRepo.findById(id).get();
	}

	@Override
	public Optional<Users> getAuthenticatedUser(Users user) {
	
		return userRepo.findByName(AuthenticationHelper.getAuthenticatedUsername());
	}

	@Override
	public Users createOrUpdateUser(Users user) {
	
		return userRepo.save(user);
	}

	@Override
	public void deleteUser(Users user) {

		userRepo.delete(user);
	}

	@Override
	public Users findByName(String userName){
		return userRepo.findByName(userName).get();

	}

	
	@Override
	public List<Users> findByList(String userName) {
		// TODO Auto-generated method stub
		return userRepo.findAllByName(userName);
	}

}
