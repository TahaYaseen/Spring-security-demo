package com.image.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.image.demo.entity.SystemUser;

import com.image.demo.repository.UserRepository;

@Service
public class CustomUserDetailsService implements UserDetailsService{
	@Autowired
	private UserRepository userRepository;
	
	public  CustomUserDetailsService(UserRepository userRepository) {
		this.userRepository = userRepository;
	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		SystemUser user = userRepository.findByUsername(username);
		CustomUserDetails userDetail = new CustomUserDetails();
		userDetail.setUser(user);
		//CustomUserDetails userDetails = null;
		if (user != null) {
			//userDetails = new CustomUserDetails();
			//userDetails.setUser(user);
		} else {
			throw new UsernameNotFoundException("User not exist with name : " + username);
		}
		return userDetail;

	}

}
