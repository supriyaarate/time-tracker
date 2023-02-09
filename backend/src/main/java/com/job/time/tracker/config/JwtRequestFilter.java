package com.job.time.tracker.config;

import com.job.time.tracker.security.MyUserDetails;
import com.job.time.tracker.security.MyUserService;
import com.job.time.tracker.util.JwtUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Slf4j
@Component
public class JwtRequestFilter extends OncePerRequestFilter{
	
	@Autowired
	private JwtUtils jwtUtils;
	
	@Autowired
	private MyUserService myUserService;
	
	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {

		final String requestTokenHeader = request.getHeader("Authorization");
		String jwtToken;
		String username;
		
		if(requestTokenHeader != null && requestTokenHeader.startsWith("Bearer ")) {
			try {
				jwtToken = requestTokenHeader.substring(7);
				username = jwtUtils.getUsernameFromToken(jwtToken);
				
				if(username != null) {
					MyUserDetails myUserDetails = (MyUserDetails) myUserService.loadUserByUsername(username);
					
					if(jwtUtils.validateToken(jwtToken, myUserDetails)) {
						UsernamePasswordAuthenticationToken usernamePassowrdAuthenticationToken = 
								new UsernamePasswordAuthenticationToken(myUserDetails, null, myUserDetails.getAuthorities());
						
						SecurityContextHolder.getContext().setAuthentication(usernamePassowrdAuthenticationToken);
					}
				}
			}
			catch (Exception e) {
				e.printStackTrace();
				log.error("Cannot set user authentication: {}" + e);
			}
		}
		
		filterChain.doFilter(request, response);
		
	}

}
