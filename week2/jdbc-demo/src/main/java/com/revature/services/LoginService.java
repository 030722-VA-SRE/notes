package com.revature.services;

import com.revature.daos.UserDao;
import com.revature.daos.UserPostgres;
import com.revature.models.User;

public class LoginService {
	
	private UserDao ud = new UserPostgres();
	
	public boolean login(String username, String password) {
		User u = ud.getUserByUsername(username);
		/*-
		 * if u is null/ doesn't exist, throw an exception
		 * 
		 * check that the password sent matches the password in the database for that user
		 */
		if(!u.getPassword().equals(password)) {
			// throw another exception
		}
		
		// if passwords match, etc. etc.... return true.
		return true;
	}

}
