package com.job.time.tracker.security;

import com.job.time.tracker.entity.JUser;
import com.job.time.tracker.repository.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Slf4j
@Service
public class MyUserService implements UserDetailsService{
	
	@Autowired
	private UserRepository userRepository;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		
		Optional<JUser> user = userRepository.findByuserName(username);
				
		user.orElseThrow( () -> new UsernameNotFoundException("Could not find user with userName" +username));
		
		return new MyUserDetails(user.get());
		
	}

}