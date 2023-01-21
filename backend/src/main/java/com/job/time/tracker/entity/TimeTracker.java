package com.job.time.tracker.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the time_tracker database table.
 * 
 */
@Entity
@Getter
@Setter
@ToString
@Table(name="time_tracker")
@NamedQuery(name="TimeTracker.findAll", query="SELECT t FROM TimeTracker t")
public class TimeTracker implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(unique=true, nullable=false)
	private int id;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="LOGIN_TIME", nullable=false)
	private Date loginTime;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="LOGOFF_TIME")
	private Date logoffTime;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="WORK_DATE", nullable=false)
	private Date workDate;

	@Column(name="WORK_HOURS")
	private int workHours;

	//bi-directional many-to-one association to Job
	@ManyToOne
	@JoinColumn(name="JOB_ID", nullable=false)
	private Job job;


}