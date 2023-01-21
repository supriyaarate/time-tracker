package com.job.time.tracker.service;


import com.job.time.tracker.constants.ExceptionConstants;
import com.job.time.tracker.constants.RoleConstants;
import com.job.time.tracker.constants.UserStatus;
import com.job.time.tracker.dto.UserDTO;
import com.job.time.tracker.entity.JRole;
import com.job.time.tracker.entity.JUser;
import com.job.time.tracker.entity.RoleUser;
import com.job.time.tracker.exception.BusinessException;
import com.job.time.tracker.repository.UserRepository;
import com.job.time.tracker.security.EncryptionUtils;
import com.job.time.tracker.util.ValidationUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Slf4j
@Service
public class UserService {
	
	@Autowired
	private UserRepository userRepository;
	
	public JUser saveUser(UserDTO userDTO ) throws BusinessException {
		
		ValidationUtils.validateUser(userDTO);
		checkIfUserExists(userDTO.getUsername(), userDTO.getEmail());
		
		String encryptedPassword = EncryptionUtils.setEncrptPassword(userDTO.getPassword());
		
		final JUser jUser = new JUser();
		jUser.setFirstName(userDTO.getFirstName());
		jUser.setLastName(userDTO.getLastName());
		jUser.setEmail(userDTO.getEmail());
		jUser.setUserName(userDTO.getUsername());
		jUser.setPassword(encryptedPassword);
		jUser.setConfirmPassword(encryptedPassword);

		jUser.setStatus(UserStatus.ACTIVE.getId());
		jUser.setEnabled(true);

		List<RoleUser> roleUserList = new ArrayList<>();

		final RoleUser roleUser = new RoleUser();
		roleUser.setJUser(jUser);

		JRole jRole = new JRole();
		jRole.setId(RoleConstants.CLIENT.getValue());
		roleUser.setJRole(jRole);
		roleUserList.add(roleUser);
		jUser.setRoleUsers(roleUserList);
		
		return userRepository.save(jUser);
		
	}
	
	public boolean checkIfUserExists(String username, String email) throws BusinessException {
		
		if(username != null) {
			Optional<JUser> user = userRepository.findByuserName(username);
			
			if(user.isPresent()) {
				throw new BusinessException(ExceptionConstants.USER_WITH_USERNAME_ALREADY_EXISTS);
			}
		}
		
		if(email != null) {
			Optional<JUser> user = userRepository.findByEmail(email);
			
			if(user.isPresent()) {
				throw new BusinessException(ExceptionConstants.USER_WITH_EMAIL_ALREADY_EXISTS);
			}
			
		}
		
		return true;
	}

	public JUser findUserById(int id) throws BusinessException {
		
		final Optional<JUser> user = userRepository.findById(id);
		
		if(!user.isPresent()) {
			log.error("User not found with id " +id);
			throw new BusinessException(ExceptionConstants.USER_DOES_NOT_EXIST + id);
		}
		
		log.info("User found with id " +id);
		return user.get();
	}
	

}
