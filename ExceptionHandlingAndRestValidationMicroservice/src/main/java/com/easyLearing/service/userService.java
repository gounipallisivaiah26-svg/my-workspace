package com.easyLearing.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.easyLearing.ForeignClient.AddressFeignClient1;
//import com.easyLearing.ForeignClient.AddressFeignClient1;
import com.easyLearing.entity.User;
import com.easyLearing.exception.userNotFoundException;
import com.easyLearing.repo.UserRepo;

@Service
public class userService {
	@Autowired
	private UserRepo repository;
	
	@Autowired
	private AddressFeignClient1 addressFeignClient;
	public User saveUse(User user) {
		return repository.save(user);
	}
	
	public List<User> getAllUsers(){
		List<User> oldUsers=repository.findAll();
		List<User> newUsers=addressFeignClient.getAllUsers();
		for(User u:newUsers) {
			oldUsers.add(u);
		}
		return  oldUsers;
				
		 
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