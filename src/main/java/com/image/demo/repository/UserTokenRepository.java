package com.image.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.image.demo.entity.UserToken;
@Repository
public interface UserTokenRepository extends JpaRepository<UserToken, Integer>{
	
	UserToken findByUsername(String username);

}
