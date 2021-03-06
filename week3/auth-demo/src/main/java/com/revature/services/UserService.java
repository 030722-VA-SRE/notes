package com.revature.services;

import java.util.List;

import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.MDC;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.dtos.UserDTO;
import com.revature.exceptions.UserNotFoundException;
import com.revature.models.User;
import com.revature.repositories.LionRepository;
import com.revature.repositories.UserRepository;

@Service
public class UserService {

	private UserRepository ur;
	private LionRepository lr;
	private static Logger log = LoggerFactory.getLogger(UserService.class);
	@Autowired
	public UserService(UserRepository ur, LionRepository lr) {
		super();
		this.ur = ur;
		this.lr = lr;
	}
	
	public UserDTO getUserById(int id) throws UserNotFoundException {
		User user = ur.findById(id).orElseThrow(UserNotFoundException::new);
		// log.info("user x retrieved ...");
		log.info(MDC.get("userToken"));
		return new UserDTO(user);
	}
	
	@Transactional
	public User createUser(User newUser) {	
		/*-
		 * logic for user already exists exception
		 */
		return ur.save(newUser);
	}
	

	public List<User> getAll(){
		log.info(MDC.get("userToken"));
		return ur.findAll();
	}
	
	@Transactional
	public User updateUser(int id, User user) {
		/*-
		 *  Logic for update user, ie:
		 *  	- check that user exists
		 *  	- partial updates
		 *  	- etc...
		 */
		return ur.save(user);
	}
	
	@Transactional
	public void deleteUser(int id) throws UserNotFoundException {
		// this tries to retrieve a user by id, if it doesn't exist, throws an exception
		getUserById(id);

		ur.deleteById(id);
	}
}
