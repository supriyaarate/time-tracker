package com.job.time.tracker.controller;

import com.job.time.tracker.dto.JobDTO;
import com.job.time.tracker.entity.Job;
import com.job.time.tracker.repository.JobRepository;
import com.job.time.tracker.security.UserLoggedInService;
import com.job.time.tracker.service.JobService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class JobController {

    @Autowired
    private JobRepository jobRepository;

    @Autowired
    private JobService jobService;

    @Autowired
    private UserLoggedInService userLoggedInService;

    @GetMapping(value = "/job", name = "FindAllJob")
    public ResponseEntity<List<Job>> getAllJob(){
        return new ResponseEntity<List<Job>>( jobService.findAll() , HttpStatus.OK);
    }

    @PostMapping(value = "/job", name = "AddJob")
    public ResponseEntity<JobDTO> addJob(@RequestBody JobDTO jobDTO){
        return new ResponseEntity<JobDTO>( jobService.addJob(jobDTO , userLoggedInService.getLoggedInUserDetails()));
    }
}
