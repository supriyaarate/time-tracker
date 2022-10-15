package com.job.time.tracker.dto;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class JwtResponseDTO {

	private String token;
	
	public JwtResponseDTO(String token) {
		super();
		this.token = token;
	}
	
}
