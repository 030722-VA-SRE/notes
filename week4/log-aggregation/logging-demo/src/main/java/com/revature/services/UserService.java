package com.revature.services;

import java.util.List;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.daos.UserRepository;
import com.revature.dtos.UserDto;
import com.revature.models.User;


@Service
public class UserService {

	private UserRepository ur;
	private static final Logger LOG = LoggerFactory.getLogger(UserService.class);

	@Autowired
	public UserService(UserRepository ur) {
		super();
		this.ur = ur;
	}

	public List<UserDto> getUsers(){
		List<User> users = ur.findAll();
		
		/*-
		 *  converts the list into a stream in which a map function is applied
		 *  The map function applies some logic to each object within the List and returns that object
		 *  the newly UserDto objects are then returned
		 */
		List<UserDto> usersDto = users.stream()
//				.filter(user -> user.getRole().toString().equals("ADMIN"))
				.map((user) -> new UserDto(user))
				.collect(Collectors.toList());
		
		return usersDto;
	}
}
