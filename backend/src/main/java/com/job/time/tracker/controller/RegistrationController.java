package com.job.time.tracker.controller;


import com.job.time.tracker.dto.ResponseDTO;
import com.job.time.tracker.dto.UserDTO;
import com.job.time.tracker.exception.BusinessException;
import com.job.time.tracker.service.RegistrationService;
import com.job.time.tracker.util.UtilService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RegistrationController {

    @Autowired
    private RegistrationService registrationService;

    @PostMapping(value = "/public/registration", name = "AddUser")
    public ResponseDTO addUser(@RequestBody UserDTO userDTO) throws BusinessException {

        final ResponseDTO responseDTO = UtilService.getResponseDTO();
        responseDTO.setResponse(registrationService.addUser(userDTO));

        return responseDTO;
    }
}
