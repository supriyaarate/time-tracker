package com.job.time.tracker.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigInteger;
import java.util.Date;
import java.util.List;
import java.util.Set;


/**
 * The persistent class for the j_user database table.
 * 
 */
@Getter
@Setter
@ToString
@Entity
@Table(name="j_user")
@NamedQuery(name="JUser.findAll", query="SELECT j FROM JUser j")
public class JUser implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(unique = true, nullable = false)
	private int id;

	@Column(name = "ACCOUNT_NON_EXPIRED", nullable = false)
	private Boolean accountNonExpired;

	@Column(name = "ACCOUNT_NON_LOCKED", nullable = false)
	private Boolean accountNonLocked;

	@Column(length = 255)
	private String address;

	@Column(name = "CAN_SEND_EMAIL", nullable = false)
	private Boolean canSendEmail;

	@Column(name = "CONFIRM_PASSWORD", nullable = false, length = 1024)
	private String confirmPassword;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "CREATE_DATE", nullable = false)
	private Date createDate;

	@Column(name = "CREDENTIALS_NON_EXPIRED", nullable = false)
	private Boolean credentialsNonExpired;

	@Column(nullable = false, length = 255)
	private String email;

	@Column(nullable = false)
	private Boolean enabled;

	@Column(name = "FIRST_NAME", nullable = false, length = 255)
	private String firstName;

	@Column(name = "IP_ADDRESS", nullable = false, length = 20)
	private String ipAddress;

	@Column(name = "LANG_PREF", nullable = false, length = 50)
	private String langPref;

	@Column(name = "LAST_NAME", nullable = false, length = 255)
	private String lastName;

	@Column(name = "MIDDLE_NAME", length = 255)
	private String middleName;

	@Column(nullable = false, length = 1024)
	private String password;

	private BigInteger phone;

	@Column(name = "PHONE_COUNTRY_CODE")
	private int phoneCountryCode;

	@Column(name = "REFERENCE_ID", nullable = false, length = 255)
	private String referenceId;

	@Column(nullable = false)
	private int status;

	@Column(nullable = false)
	private int type;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "UPDATE_DATE")
	private Date updateDate;

	@Column(name = "USER_NAME", nullable = false, length = 255)
	private String userName;

	@Column(nullable = false)
	private Boolean verified;

	@Column(name = "WALKTHROUGH_STATUS", nullable = false)
	private int walkthroughStatus;

	//bi-directional many-to-one association to Job
	@OneToMany(mappedBy = "JUser")
	private List<Job> jobs;

	//bi-directional many-to-one association to LoginHistory
	@OneToMany(mappedBy = "JUser")
	private List<LoginHistory> loginHistories;

	//bi-directional many-to-one association to Organisation
	@OneToMany(mappedBy = "JUser")
	private List<Organisation> organisations;

	//bi-directional many-to-one association to Payment
	@OneToMany(mappedBy = "JUser")
	private List<Payment> payments;

	//bi-directional many-to-one association to RoleUser
	@OneToMany(mappedBy = "JUser",fetch = FetchType.EAGER)
	private List<RoleUser> roleUsers;

	//bi-directional many-to-one association to Subscription
	@OneToMany(mappedBy = "JUser")
	private List<Subscription> subscriptions;

	//bi-directional many-to-one association to UserRelation
	@OneToMany(mappedBy = "JUser1")
	private List<UserRelation> userRelations1;

	//bi-directional many-to-one association to UserRelation
	@OneToMany(mappedBy = "JUser2")
	private List<UserRelation> userRelations2;


}


