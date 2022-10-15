package com.job.time.tracker.dto;

import lombok.Getter;

@Getter
public class UserContext {

    private int userId;
    private String firstName;
    private String lastName;
    private String email;
    private String username;
    private String token;

    public UserContext(int userId, String firstName, String lastName, String email, String username) {
        this.userId = userId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.username = username;
    }
}
