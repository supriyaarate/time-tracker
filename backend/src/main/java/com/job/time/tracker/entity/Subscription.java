package com.job.time.tracker.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the subscription database table.
 * 
 */
@Entity
@Getter
@Setter
@ToString
@Table(name="subscription")
@NamedQuery(name="Subscription.findAll", query="SELECT s FROM Subscription s")
public class Subscription implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(unique=true, nullable=false)
	private int id;

	@Column(nullable=false)
	private int amount;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="expiry_date")
	private Date expiryDate;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="renew_date")
	private Date renewDate;

	@Column(nullable=false)
	private int status;

	//bi-directional many-to-one association to JUser
	@ManyToOne
	@JoinColumn(name="USER_ID", nullable=false)
	private JUser JUser;


}