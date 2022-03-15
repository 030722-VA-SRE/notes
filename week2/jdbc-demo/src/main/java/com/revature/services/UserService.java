package com.revature.services;

import java.util.List;

import com.revature.daos.UserDao;
import com.revature.daos.UserPostgres;
import com.revature.models.User;

public class UserService {
	
	private UserDao ud = new UserPostgres();
	
	public User getById(int id) {
		User u = ud.getUserById(id);
		
		/*- add business logic
		 * 		- id u = null, ie u doesn't exist in the database, throw an exception
		 * 			- ie: UserNotFoundException
		 * 
		 */
		
		return u;
	}
	
	public List<User> getAll() {
		// Can add some logic here, ie: if list is empty throw an exception
		return ud.getUsers();
	}
	
	public boolean addUser(User user) {
		// validation of user object, add business logic
		int newId = ud.createUser(user);
		
		if(newId == -1) {
			// throw an exception
			return false;
		}
		
		return true;
	}
}
