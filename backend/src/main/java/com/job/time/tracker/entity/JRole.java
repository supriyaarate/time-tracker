package com.job.time.tracker.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the j_role database table.
 * 
 */
@Getter
@Setter
@ToString
@Entity
@Table(name="j_role")
@NamedQuery(name="JRole.findAll", query="SELECT j FROM JRole j")
public class JRole implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(unique=true, nullable=false)
	private int id;

	@Column(name="ROLE_NAME", nullable=false, length=50)
	private String roleName;

	//bi-directional many-to-one association to RoleUser
	@OneToMany(mappedBy="JRole")
	private List<RoleUser> roleUsers;


}