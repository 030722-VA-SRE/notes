package com.revature.dtos;

import java.util.Objects;

import com.revature.models.User;
import com.revature.models.UserRole;

public class UserDto {

	private int id;
	private String username;
	private UserRole role;
	
	public UserDto() {
		super();
	}
	
	public UserDto(User u) {
		id = u.getId();
		username = u.getUsername();
		role = u.getRole();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public UserRole getRole() {
		return role;
	}

	public void setRole(UserRole role) {
		this.role = role;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, role, username);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		UserDto other = (UserDto) obj;
		return id == other.id && role == other.role && Objects.equals(username, other.username);
	}

	@Override
	public String toString() {
		return "UserDto [id=" + id + ", username=" + username + ", role=" + role + "]";
	}
	
}
