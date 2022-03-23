package com.revature.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.models.Role;
import com.revature.models.User;
import com.revature.repositories.UserRepository;

@Service
public class UserService {

	private UserRepository ur;

	@Autowired
	public UserService(UserRepository ur) {
		super();
		this.ur = ur;
	}
	
	public List<User> getUsers(){
		return ur.findAll();
	}
	
	public List<User> getUsersByRole(Role role){
		return ur.findUsersByRole(role);
	}
	
	public User createUser(User user) {
		return ur.save(user);
	}
}
