package com.job.time.tracker.service;

import com.job.time.tracker.dto.JobDTO;
import com.job.time.tracker.dto.UserContext;
import com.job.time.tracker.entity.JUser;
import com.job.time.tracker.entity.Job;
import com.job.time.tracker.repository.JobRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class JobService {

    @Autowired
    private JobRepository jobRepository;

    public List<Job> findAll() {
        return jobRepository.findAll();
    }

    public HttpStatus addJob(JobDTO jobDTO, UserContext loggedInUserDetails) {
        final JUser jUser = new JUser();
        jUser.setId(loggedInUserDetails.getUserId());

        final Job job = Job.builder()
                .jobName(jobDTO.getJobName())
                .createdTime(new Date())
                .modifiedTime(new Date())
                .status(true)
                .description(jobDTO.getDescription())
                .jUser(jUser)
                .build();

        jobRepository.save(job);

        return null;
    }
}
