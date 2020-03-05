package com.example.securityassignment.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.example.securityassignment.model.CustomUserDetails;
import com.example.securityassignment.model.Users;
import com.example.securityassignment.repository.UserRepository;
@Service
public class CustomUserDetailsService implements UserDetailsService{
	@Autowired
	private UserRepository userrepo;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		// TODO Auto-generated method stub
	Optional<Users> optionalusers=userrepo.findByName(username);
	
	optionalusers
    .orElseThrow(() -> new UsernameNotFoundException("Username not found"));
return optionalusers
    .map(CustomUserDetails::new).get();
	}

}
