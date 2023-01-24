package com.job.time.tracker.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Column;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import java.io.Serializable;
import java.math.BigInteger;
import java.util.Date;

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
	private Boolean accountNonExpired;
	private Boolean accountNonLocked;
	private String address;
	private Boolean canSendEmail;
	private String confirmPassword;
	private Date createDate;
	private Boolean credentialsNonExpired;
	private String email;
	private Boolean enabled;
	private String firstName;
	private String ipAddress;
	private String langPref;
	private String lastName;
	private String middleName;
	private String password;
	private BigInteger phone;
	private int phoneCountryCode;
	private String referenceId;
	private int status;
	private int type;
	private Date updateDate;
	private String userName;
	private Boolean verified;
	private int walkthroughStatus;

}
