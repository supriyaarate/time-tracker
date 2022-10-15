package com.job.time.tracker.util;


import com.job.time.tracker.constants.ExceptionConstants;
import com.job.time.tracker.dto.UserDTO;
import com.job.time.tracker.exception.BusinessException;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class ValidationUtils {
	
	public static boolean validateUser(UserDTO userDTO) throws BusinessException {

		if (userDTO.getFirstName() == null) {
			throw new BusinessException(ExceptionConstants.FIRST_NAME_CANNOT_BE_NULL);
		}

		if (userDTO.getLastName() == null) {
			throw new BusinessException(ExceptionConstants.LAST_NAME_CANNOT_BE_NULL);
		}

		if (userDTO.getEmail() == null) {
			throw new BusinessException(ExceptionConstants.EMAIL_CANNOT_BE_NULL);
		}

		if (userDTO.getUsername() == null) {
			throw new BusinessException(ExceptionConstants.USERNAME_CANNOT_BE_NULL);
		}

		//to do - need more logic to verify the password requirements and validate confirmPassword with entered password
		if (userDTO.getPassword() == null) {
			throw new BusinessException("Password cannot be empty");
		}

		if (userDTO.getConfirmPassword() == null) {
			throw new BusinessException("Confirmed Password cannot be empty");
		}

		if(!userDTO.getPassword().equals(userDTO.getConfirmPassword())){
			log.info("password : " +userDTO.getPassword());
			log.info("confirm pass : " +userDTO.getConfirmPassword());
			throw  new BusinessException("Passwords do not match");
		}

		return true;
	}

}
