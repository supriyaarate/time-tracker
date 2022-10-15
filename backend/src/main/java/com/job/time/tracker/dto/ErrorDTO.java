package com.job.time.tracker.dto;


import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ErrorDTO {
	
	private String message;
	private String fieldName;
	private String statusCode;
	private String customField;
	private String description;


}
