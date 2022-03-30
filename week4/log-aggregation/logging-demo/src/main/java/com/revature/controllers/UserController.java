package com.revature.controllers;

import java.util.List;
import java.util.UUID;

import org.jboss.logging.MDC;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.revature.dtos.UserDto;
import com.revature.services.AuthService;
import com.revature.services.UserService;

@RestController
@RequestMapping("/users")
public class UserController {

	private UserService us;
	private AuthService as;
	private static final Logger LOG = LoggerFactory.getLogger(UserController.class);
	
	@Autowired
	public UserController(UserService us, AuthService as) {
		super();
		this.us = us;
		this.as = as;
	}
	
	@GetMapping
	public ResponseEntity<List<UserDto>> getUsers(@RequestHeader(value = "Authorization", required = false) String token){
		// this logic should be handled as a filter
		MDC.put("requestId", UUID.randomUUID().toString());
		// auth logic throws a runtime exception if not verified, better placed as a filter
		as.verify(token);
	
		LOG.info("users retrieved");
		return new ResponseEntity<>(us.getUsers(), HttpStatus.OK);
	}
}
