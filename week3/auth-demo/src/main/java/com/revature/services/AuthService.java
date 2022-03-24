package com.revature.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.dtos.UserDTO;
import com.revature.models.User;
import com.revature.repositories.UserRepository;

@Service
public class AuthService {
	
	private UserRepository ur;

	@Autowired
	public AuthService(UserRepository ur) {
		super();
		this.ur = ur;
	}
	
	public UserDTO login(String username, String password) {
		// retrieve user from db by username, returns null if does not exist
		User principal = ur.findUserByUsername(username);
		
		// check that the uname and pass sent in req match the ones retrieved from db
		if(principal == null || !password.equals(principal.getPassword())) {
			// log for invalid credential/throw exception
			return null;
		}
		
		return new UserDTO(principal);
	}
	
	public String generateToken(UserDTO principal) {
		/*-
		 * fancy logic to create a token
		 * 
		 * This is not a good implementation of a token
		 */
		return principal.getId()+":"+principal.getUsername();
	}

}
