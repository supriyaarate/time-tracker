package com.job.time.tracker.controller;


import com.job.time.tracker.dto.JwtRequestDTO;
import com.job.time.tracker.dto.JwtResponseDTO;
import com.job.time.tracker.exception.BusinessException;
import com.job.time.tracker.security.MyUserDetails;
import com.job.time.tracker.security.MyUserService;
import com.job.time.tracker.util.JwtUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


@RestController
@CrossOrigin
@Slf4j
public class JwtController {

	@Autowired
	private AuthenticationManager authenticationManager;

	@Autowired
	private MyUserService myUserService;

	@Autowired
	private JwtUtils jwtUtils;
	
	@PostMapping(value = "/authenticate", name = "Authenticate")
    public ResponseEntity<JwtResponseDTO> createAuthenticationToken(@RequestBody JwtRequestDTO jwtRequestDTO) throws Exception{
		
		try {
			authenticationManager.authenticate(
					new UsernamePasswordAuthenticationToken(jwtRequestDTO.getUserName(), jwtRequestDTO.getPassword()));

		} catch (DisabledException e) {
			throw new BusinessException("User is disabled");
		} catch (BadCredentialsException e) {
			throw new BusinessException("Credentials are Invalid");
		} catch (Exception e) {
			log.info(e.getMessage());
			throw new Exception("Something went wrong", e);
		}

		MyUserDetails myUserDetails = (MyUserDetails) myUserService.loadUserByUsername(jwtRequestDTO.getUserName());
		String token = jwtUtils.generateToken(myUserDetails);
		return ResponseEntity.ok(new JwtResponseDTO(token));
	}

}
