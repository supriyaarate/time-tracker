package com.job.time.tracker.security;



import com.job.time.tracker.dto.UserContext;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;


@Slf4j
@Service
public class UserLoggedInService {

    public UserContext getLoggedInUserDetails() {

        MyUserDetails myUserDetails = (MyUserDetails) SecurityContextHolder.getContext().getAuthentication()
                .getPrincipal();

        final UserContext userContext = new UserContext(myUserDetails.getId(), myUserDetails.getFirstName(), myUserDetails.getLastName(),
                myUserDetails.getEmail(), myUserDetails.getUsername());

        return userContext;
    }



}
