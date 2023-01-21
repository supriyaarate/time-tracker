package com.job.time.tracker.constants;

import org.apache.catalina.User;

public enum UserStatus {

    INACTIVE(0,"INACTIVE"),
    ACTIVE(1,"ACTIVE"),
    BLOCKED_BY_ADMIN(2,"BLOCKED_BY_ADMIN"),
    INCORRECT_PASSWORD_EXCEED(3,"INCORRECT_PASSWORD_EXCEED"),
    RESET_PASSWORD(4,"INCORRECT_PASSWORD_EXCEED");

    private int id;
    private String status;

    UserStatus(int id, String status){
        this.id= id;
        this.status=status;
    }

    public int getId(){
        return this.id;
    }
    
    public String getStatus(){
        return this.status;
    }

    public static UserStatus findByValue(String value){
        for(UserStatus userStatus: UserStatus.values()){
            if(userStatus.status.equalsIgnoreCase(value)){
                return userStatus;
            }
        }
        throw new IllegalArgumentException("Illegal Status provided");
    }

    public static UserStatus findById(int id){
        for(UserStatus userStatus : UserStatus.values()){
            if(userStatus.id == id){
                return userStatus;
            }
        }
        throw new IllegalArgumentException("Illegal ID for User Status provided");
    }
}
