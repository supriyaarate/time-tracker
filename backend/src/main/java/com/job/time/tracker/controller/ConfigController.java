package com.job.time.tracker.controller;

import com.job.time.tracker.dto.ResponseDTO;
import com.job.time.tracker.security.UserLoggedInService;
import com.job.time.tracker.service.ConfigService;
import com.job.time.tracker.util.UtilService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ConfigController {

    @Autowired
    private ConfigService configService;

    @Autowired
    private UserLoggedInService userLoggedInService;

    @GetMapping(value = "/config" , name = "config")
    public ResponseDTO getConfig(){
        final ResponseDTO responseDTO = UtilService.getResponseDTO();
        responseDTO.setResponse(configService.getConfigProperties(userLoggedInService.getLoggedInUserDetails()));
        return responseDTO;
    }


}
