package com.job.time.tracker.entity;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.util.Date;

@Getter
@Setter
@ToString
@Entity
@Builder
@Table(name = "JOB")
public class Job {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID", nullable = false)
    private Integer id;

    @Column(name = "UNIQUE_KEY", nullable = false, length = 15)
    private String uniqueKey;

    @Column(name = "JOB_NAME", nullable = false, length = 100)
    private String jobName;

    @Column(name = "DESCRIPTION")
    private String description;

    @Column(name = "STATUS", nullable = false)
    private Boolean status = false;

    @Column(name = "CREATED_TIME", nullable = false)
    private Date createdTime;

    @Column(name = "MODIFIED_TIME", nullable = false)
    private Date modifiedTime;

    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "USER_ID", nullable = false)
    private JUser jUser;

}