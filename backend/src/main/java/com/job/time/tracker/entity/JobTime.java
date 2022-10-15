package com.job.time.tracker.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.util.Date;

@Getter
@Setter
@ToString
@Entity
@Table(name = "JOB_TIME")
public class JobTime {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID", nullable = false)
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "JOB_ID", nullable = false)
    private Job job;

    @Column(name = "STATUS", nullable = false)
    private Integer status;

    @Column(name = "START_TIME", nullable = false)
    private Date startTime;

    @Column(name = "STOP_TIME", nullable = false)
    private Date stopTime;

}