package com.job.time.tracker.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

@RestController
@Slf4j
@RequestMapping("/public")
public class PingController {

    @GetMapping(value = "/ping" , name = "Ping")
    public ResponseEntity<String> pingServer(){
        log.info("Ping Called");
        return new ResponseEntity<String>(new Date().toString(), HttpStatus.OK);
    }

}
