package com.revature.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.revature.models.Task;

@Repository
public interface TaskRepository extends JpaRepository<Task, Integer> {


}
