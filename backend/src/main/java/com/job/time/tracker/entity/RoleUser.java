package com.job.time.tracker.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the role_user database table.
 * 
 */
@Entity
@Getter
@Setter
@ToString
@Table(name="role_user")
@NamedQuery(name="RoleUser.findAll", query="SELECT r FROM RoleUser r")
public class RoleUser implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(unique=true, nullable=false)
	private int id;

	//bi-directional many-to-one association to JRole
	@ManyToOne
	@JoinColumn(name="ROLE_ID")
	private JRole JRole;

	//bi-directional many-to-one association to JUser
	@ManyToOne
	@JoinColumn(name="USER_ID")
	private JUser JUser;

}