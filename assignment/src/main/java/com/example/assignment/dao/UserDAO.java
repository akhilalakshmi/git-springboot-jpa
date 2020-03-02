package com.example.assignment.dao;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.assignment.controller.WelcomeController;
import com.example.assignment.pojo.User;
import com.example.assignment.repository.UserRepository;

@Service
@Transactional
public class UserDAO {
	
	@Autowired
	private final UserRepository userrepo;
	final static Logger logger=Logger.getLogger(UserDAO.class);
	public UserDAO(UserRepository userrepo) {
		this.userrepo=userrepo;
	}
	
	
	public void saveUser(User user) {
		logger.warn("saving user to db");
		userrepo.save(user);
		
	}

	public List<User> findallUser() {
		List<User> users=new ArrayList<User>();
		String role="user";
		users=userrepo.findByRole(role);
		/*for(User eachuser: userrepo.findByRole(role)) {
			users.add(eachuser);
		}*/
		// TODO Auto-generated method stub
		return users;
	}

	public void deleteUser(int id) {
		userrepo.deleteById(id);
		
	}

	public User findById(int id) {

		User user= userrepo.findById(id).get();
		return user;
		
	}
	public User findByNameAndPassword(String name,String password) {
		return userrepo.findByNameAndPassword(name, password);
	}


}
