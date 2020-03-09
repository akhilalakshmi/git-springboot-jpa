package com.example.securityassignment.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.securityassignment.model.Users;

public interface UserRepository extends JpaRepository<Users, Integer>{

	Optional<Users> findByName(String username);
	List<Users> findAllByName(String userName);

}
