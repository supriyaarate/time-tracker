package com.job.time.tracker.exception;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class NotFoundException extends RuntimeException{

	private static final long serialVersionUID = 1L;
	private String message;
	
	public NotFoundException(String message) {
		this.message = message;
	
	}
}
