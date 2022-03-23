package com.revature.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.revature.models.Role;
import com.revature.models.User;
import com.revature.services.UserService;

@RestController
@RequestMapping("/users")
public class UserController {

	private UserService us;

	@Autowired
	public UserController(UserService us) {
		super();
		this.us = us;
	}
	
	@GetMapping
	public ResponseEntity<List<User>> getAll(@RequestParam(name = "role", required = false) String role){
		if(role != null) {
			return new ResponseEntity<>(us.getUsersByRole(Role.valueOf(role)), HttpStatus.OK);
		}
		return new ResponseEntity<>(us.getUsers(), HttpStatus.OK);
	}
	
	@PostMapping
	public ResponseEntity<String> postUser(@RequestBody User user){
		/*-
		 * logic to return appropriate response based on creation success
		 */
		us.createUser(user);
		return new ResponseEntity<>("UserCreated!", HttpStatus.CREATED);
	}
	
	@GetMapping("{id}")
	public ResponseEntity<List<User>> getById(){
		return new ResponseEntity<>(null, HttpStatus.OK);
	}
}
