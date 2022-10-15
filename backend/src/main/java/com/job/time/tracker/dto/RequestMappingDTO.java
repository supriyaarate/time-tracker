package com.job.time.tracker.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties
@Getter
@Setter
public class RequestMappingDTO {

    private String name;
    private String url;
}
