package com.revature.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.revature.models.Lion;

@Repository
public interface LionRepository extends JpaRepository<Lion, Integer> {

}
