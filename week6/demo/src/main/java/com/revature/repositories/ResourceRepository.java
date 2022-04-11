package com.revature.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.revature.models.Resource;

@Repository
public interface ResourceRepository extends JpaRepository<Resource, Integer> {

}
