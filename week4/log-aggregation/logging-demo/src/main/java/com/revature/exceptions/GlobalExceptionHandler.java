package com.revature.exceptions;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {
	
	private static final Logger LOG = LoggerFactory.getLogger(GlobalExceptionHandler.class);
			
	@ExceptionHandler(AuthenticationException.class)
	public ResponseEntity<String> handleAuthenticationException(AuthenticationException e) {
		LOG.warn("Authentication exception was handled.", e);
		return new ResponseEntity<>("Wrong credentials", HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(AuthorizationException.class)
	public ResponseEntity<String> handleAuthenticationException(AuthorizationException e) {
		LOG.warn("Authorization exception was handled.", e);
		return new ResponseEntity<>("Not Authorized", HttpStatus.FORBIDDEN);
	}
}
