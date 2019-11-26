package com.image.demo.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/rest/auth")
public class TestController {
	
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	@GetMapping("/hello")
	public String hello() {
		return "Hello Taha";
	}
	
	@PreAuthorize("hasRole('ROLE_USER')")
	@GetMapping("/user")
	public String user() {
		return "Hello Taha";
	}

}
