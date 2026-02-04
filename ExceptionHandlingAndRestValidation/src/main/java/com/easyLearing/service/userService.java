package com.easyLearing.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.easyLearing.entity.User;
import com.easyLearing.exception.userNotFoundException;
import com.easyLearing.repo.UserRepo;

@Service
public class userService {
	@Autowired
	private UserRepo repository;
	
	public User saveUse(User user) {
		return repository.save(user);
	}
	
	public List<User> getAllUsers(){
		return repository.findAll();
	}
	public User getUserById(int id) throws userNotFoundException {
		User user= repository.findByUserId(id);
		if(user!=null) {
			return user;
		} else {
			throw new userNotFoundException("User not found with id "+ id);
		}
		
		
	}
}