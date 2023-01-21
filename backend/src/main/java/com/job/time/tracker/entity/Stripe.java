package com.job.time.tracker.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the stripe database table.
 * 
 */
@Entity
@Getter
@Setter
@ToString
@Table(name="stripe")
@NamedQuery(name="Stripe.findAll", query="SELECT s FROM Stripe s")
public class Stripe implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(unique=true, nullable=false)
	private int id;

	@Column(nullable=false, length=200)
	private String message;


}