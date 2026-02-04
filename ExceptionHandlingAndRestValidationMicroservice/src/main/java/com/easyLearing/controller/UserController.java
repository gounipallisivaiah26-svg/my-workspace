package com.easyLearing.controller;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.easyLearing.entity.User;
import com.easyLearing.exception.userNotFoundException;
import com.easyLearing.service.userService;

import jakarta.validation.Valid;
@RestController
@RequestMapping("/users1")
public class UserController {
	@Autowired
private userService userService;
	
	
	@PostMapping("/signup")
	public ResponseEntity<User> saveUser(@RequestBody @Valid User user){
		System.out.println("2021-users1");
		return new ResponseEntity<>(userService.saveUse(user),HttpStatus.CREATED);
	}
	@GetMapping("/fetchAll")
	public ResponseEntity<List<User>> getAllUsers(){
		return ResponseEntity.ok(userService.getAllUsers());
	}
	@GetMapping("/{id}")
	public ResponseEntity<User> getUserById(@PathVariable int id) throws userNotFoundException{
		return ResponseEntity.ok(userService.getUserById(id));
	}
}
