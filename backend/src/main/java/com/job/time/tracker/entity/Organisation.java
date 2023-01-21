package com.job.time.tracker.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the organisation database table.
 * 
 */
@Entity
@Getter
@Setter
@ToString
@Table(name="organisation")
@NamedQuery(name="Organisation.findAll", query="SELECT o FROM Organisation o")
public class Organisation implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(unique=true, nullable=false)
	private int id;

	@Column(nullable=false, length=50)
	private String name;

	//bi-directional many-to-one association to JUser
	@ManyToOne
	@JoinColumn(name="USER_ID", nullable=false)
	private JUser JUser;



}