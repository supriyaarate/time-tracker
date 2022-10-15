package com.job.time.tracker.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;

import java.io.Serializable;
import java.util.List;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties
@Getter
@Setter
public class ConfigDTO implements Serializable {
    
    private List<RequestMappingDTO> apiList;
    private UserDTO userInfo;
}
