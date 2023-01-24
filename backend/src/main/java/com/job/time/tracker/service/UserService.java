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

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import static com.job.time.tracker.util.RandomCharUtils.generateRandomBase64Token;

@Slf4j
@Service
public class UserService {
	
	@Autowired
	private UserRepository userRepository;
	
	public JUser saveUser(UserDTO userDTO ) throws BusinessException, UnknownHostException {
		
		ValidationUtils.validateUser(userDTO);
		checkIfUserExists(userDTO.getUserName(), userDTO.getEmail());
		
		String encryptedPassword = EncryptionUtils.setEncrptPassword(userDTO.getPassword());

		final JUser jUser = new JUser();
		//jUser.setReferenceId("EMP"+String.valueOf(RandomConstants.generateRandomDigits()));
		jUser.setReferenceId(generateRandomBase64Token());
		jUser.setFirstName(userDTO.getFirstName());
		jUser.setMiddleName(userDTO.getMiddleName());
		jUser.setLastName(userDTO.getLastName());
		jUser.setUserName(userDTO.getUserName());
		jUser.setPassword(encryptedPassword);
		jUser.setConfirmPassword(encryptedPassword);

		jUser.setAddress(userDTO.getAddress());
		jUser.setLangPref(userDTO.getLangPref());
		jUser.setEmail(userDTO.getEmail());
		jUser.setPhone(userDTO.getPhone());
		jUser.setPhoneCountryCode(userDTO.getPhoneCountryCode());
		jUser.setType(userDTO.getType());
		jUser.setCanSendEmail(userDTO.getCanSendEmail());
		jUser.setWalkthroughStatus(userDTO.getWalkthroughStatus());
		jUser.setVerified(userDTO.getVerified());
		jUser.setCreateDate(new Date());
		jUser.setUpdateDate(new Date());
		jUser.setIpAddress(String.valueOf(InetAddress.getLocalHost().getHostAddress()));

		jUser.setStatus(UserStatus.ACTIVE.getId());
		jUser.setEnabled(true);
		jUser.setAccountNonExpired(true);
		jUser.setCredentialsNonExpired(true);
		jUser.setAccountNonLocked(true);


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
