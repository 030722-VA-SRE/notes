package com.revature.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.revature.models.Role;
import com.revature.models.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
	public List<User> findUsersByRole(Role role);
}
