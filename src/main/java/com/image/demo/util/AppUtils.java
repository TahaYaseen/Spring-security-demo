package com.image.demo.util;

import java.time.Clock;
import java.time.ZoneId;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

import com.image.demo.entity.SystemUser;

public class AppUtils {
	public static Long currentMillis() {
		return Clock.system(ZoneId.of("Asia/Kolkata")).millis();
	}
	
	public static Long currentUser() {
		if (null != getCurrentUser())
			return getCurrentUser().getId();
		else
			return null;
	}
	
	public static SystemUser getCurrentUser() {
		Authentication auth = SecurityContextHolder.getContext()
				.getAuthentication();
		if (null != auth) {
			SystemUser user = (SystemUser) auth.getPrincipal();
			return user;
		}
		return null;
	}
}
