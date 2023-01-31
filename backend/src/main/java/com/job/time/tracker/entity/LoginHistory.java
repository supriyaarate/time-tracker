package com.job.time.tracker.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the login_history database table.
 * 
 */
@Getter
@Setter
@ToString
@Entity
@Table(name="login_history")
@NamedQuery(name="LoginHistory.findAll", query="SELECT l FROM LoginHistory l")
public class LoginHistory implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(unique=true, nullable=false)
	private int id;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="END_TIME")
	private Date endTime;

	@Column(name="IP_ADDRESS", nullable=false, length=20)
	private String ipAddress;

	@Column(nullable=false, length=255)
	private String module;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="START_TIME", nullable=false)
	private Date startTime;

	//bi-directional many-to-one association to JUser
	@ManyToOne
	@JoinColumn(name="USER_ID", nullable=false)
	private JUser JUser;


}