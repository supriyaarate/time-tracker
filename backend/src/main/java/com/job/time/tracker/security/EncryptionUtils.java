package com.job.time.tracker.security;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class EncryptionUtils {
	
	public static String setEncrptPassword(String password) {
		
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
		String encodedPassword = encoder.encode(password);
		return encodedPassword;
		
	}


}
