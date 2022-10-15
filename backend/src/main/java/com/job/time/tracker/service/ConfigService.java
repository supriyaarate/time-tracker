package com.job.time.tracker.service;

import com.job.time.tracker.dto.ConfigDTO;
import com.job.time.tracker.dto.RequestMappingDTO;
import com.job.time.tracker.dto.UserContext;
import com.job.time.tracker.dto.UserDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.mvc.method.RequestMappingInfo;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerMapping;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
@Slf4j
public class ConfigService {

    @Autowired
    private RequestMappingHandlerMapping requestMappingHandlerMapping;

    public ConfigDTO getConfigProperties(UserContext loggedInUserDetails) {
        final ConfigDTO configDTO = ConfigDTO.builder()
                .userInfo(setUserConfigProperties(loggedInUserDetails))
                .apiList(handleContextRefresh())
                .build();
        return configDTO;
    }

    public List<RequestMappingDTO> handleContextRefresh() {
        List<RequestMappingDTO> apiList = new ArrayList<>();
        for(Map.Entry<RequestMappingInfo, HandlerMethod> entry : this.requestMappingHandlerMapping.getHandlerMethods().entrySet()){
            final RequestMappingDTO requestMappingDTO = RequestMappingDTO.builder().
                    name(entry.getKey().getName()).
                    url(entry.getKey().getPatternsCondition().toString())
                    .build();
            if(requestMappingDTO.getName() != null) {
                apiList.add(requestMappingDTO);
            }

        }
        return apiList;
    }

    public UserDTO setUserConfigProperties(UserContext userContext){
        final UserDTO userDTO = UserDTO.builder()
                .firstName(userContext.getFirstName())
                .lastName(userContext.getLastName())
                .username(userContext.getUsername())
                .id(userContext.getUserId())
                .email(userContext.getEmail())
                .build();
        return userDTO;
    }
}
