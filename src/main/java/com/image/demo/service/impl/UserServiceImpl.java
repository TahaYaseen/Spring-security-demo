package com.image.demo.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.image.demo.entity.UserToken;
import com.image.demo.repository.UserTokenRepository;
import com.image.demo.service.UserService;

@Service
public class UserServiceImpl implements UserService{
	
	@Autowired
	private UserTokenRepository userTokenRepository;
	

	public void saveToken(String token, String username) {
		
		UserToken userToken = new UserToken();
		
		//UserToken userToken = userTokenRepository.findByUsername(username);
		userToken.setToken(token);
		userToken.setUsername(username);
		userTokenRepository.save(userToken);
		
		
		
	}
}
