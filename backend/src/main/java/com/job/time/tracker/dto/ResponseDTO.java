package com.job.time.tracker.dto;


import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

@Setter
@Getter
@ToString
public class ResponseDTO {
	
	private int status;
	private boolean success;
	private List<ErrorDTO> errors;
	private Object response;

}
