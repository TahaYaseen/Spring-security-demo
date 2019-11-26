package com.image.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.image.demo.entity.SystemUser;

@Repository
public interface UserRepository extends JpaRepository<SystemUser, Integer>{
	
	//@Query("Select * from User u where u.username=:username")
	SystemUser findByUsername(String username);
}
