package com.revature.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.revature.dtos.UserDTO;
import com.revature.services.AuthService;

@RestController
@RequestMapping("/auth")
public class AuthController {

	private AuthService as;
	private static Logger log = LoggerFactory.getLogger(AuthController.class);
	// Better practice to use class logger over root logger as we can specify different logger configuration based on class
	
	@Autowired
	public AuthController(AuthService as) {
		super();
		this.as = as;
	}
	
	@PostMapping
	public ResponseEntity<UserDTO> login(@RequestParam("username")String username, @RequestParam("password")String password){
		
		// principal = null if login fails
		UserDTO principal = as.login(username, password);
		
		if(principal == null) {
			return new ResponseEntity<>(HttpStatus.FORBIDDEN);
		}
		
		String token = as.generateToken(principal);
		
		HttpHeaders hh = new HttpHeaders();
		
		// set tokenName, value
		hh.set("Authorization", token);
		
		return new ResponseEntity<>(principal, hh, HttpStatus.ACCEPTED);
	}
	
}
