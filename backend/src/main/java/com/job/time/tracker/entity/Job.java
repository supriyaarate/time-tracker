package com.job.time.tracker.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.*;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the job database table.
 * 
 */
@Getter
@Setter
@ToString
@Entity
@Builder
@Table(name="job")
@AllArgsConstructor
@NoArgsConstructor
@NamedQuery(name="Job.findAll", query="SELECT j FROM Job j")
public class Job implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(unique=true, nullable=false)
	private int id;

	@Column(name="JOB_NAME", nullable=false, length=50)
	private String jobName;

	//bi-directional many-to-one association to JUser
	@ManyToOne
	@JoinColumn(name="USER_ID", nullable=false)
	private JUser JUser;

	//bi-directional many-to-one association to TimeTracker
	@OneToMany(mappedBy="job")
	private List<TimeTracker> timeTrackers;


}