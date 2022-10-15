package com.job.time.tracker.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;

@Getter
@Setter
@ToString
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
public class UserDTO implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 4475051249777741741L;
	
	private int id;
	private String confirmPassword;
	private String email;
	private String firstName;
	private String lastName;
	private String oldPassword;
	private String password;
	private String username;
	
}
