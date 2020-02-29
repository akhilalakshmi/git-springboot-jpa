package com.example.assignment.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.example.assignment.pojo.User;

public interface UserRepository extends CrudRepository<User, Integer>{
	public User findByNameAndPassword(String name,String password);
	public List<User> findByRole(String role);
}
