package com.job.time.tracker.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the user_relation database table.
 * 
 */
@Entity
@Getter
@Setter
@ToString
@Table(name="user_relation")
@NamedQuery(name="UserRelation.findAll", query="SELECT u FROM UserRelation u")
public class UserRelation implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(unique=true, nullable=false)
	private int id;

	//bi-directional many-to-one association to JUser
	@ManyToOne
	@JoinColumn(name="EMPLOYER_ID", nullable=false)
	private JUser JUser1;

	//bi-directional many-to-one association to JUser
	@ManyToOne
	@JoinColumn(name="EMPLOYEE_ID", nullable=false)
	private JUser JUser2;

}