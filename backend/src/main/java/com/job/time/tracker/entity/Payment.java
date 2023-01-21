package com.job.time.tracker.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the payment database table.
 * 
 */
@Entity
@Getter
@Setter
@ToString
@Table(name="payment")
@NamedQuery(name="Payment.findAll", query="SELECT p FROM Payment p")
public class Payment implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(unique=true, nullable=false)
	private int id;

	@Column(name="CARD_TYPE", length=50)
	private String cardType;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="PAY_DATE")
	private Date payDate;

	@Column(name="PAYMENT_REFERENCE")
	private int paymentReference;

	@Column(name="PAYMENT_TYPE", length=50)
	private String paymentType;

	@Column(nullable=false)
	private int status;

	//bi-directional many-to-one association to JUser
	@ManyToOne
	@JoinColumn(name="USER_ID", nullable=false)
	private JUser JUser;




}