package com.job.time.tracker.service;

import com.job.time.tracker.constants.RoleConstants;
import com.job.time.tracker.dto.UserDTO;
import com.job.time.tracker.exception.BusinessException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.net.UnknownHostException;

@Service
public class RegistrationService {

    @Autowired
    private UserService userService;

    public boolean addUser(UserDTO userDTO) throws BusinessException, UnknownHostException {

        userService.saveUser(userDTO );

        return true;
    }
}
