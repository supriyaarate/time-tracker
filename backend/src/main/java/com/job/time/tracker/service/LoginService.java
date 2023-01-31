package com.job.time.tracker.service;

import com.job.time.tracker.entity.JUser;
import com.job.time.tracker.entity.LoginHistory;
import com.job.time.tracker.repository.LoginHistoryRepository;
import com.job.time.tracker.security.MyUserDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.time.Instant;
import java.util.Date;

@Service
public class LoginService {
    @Autowired
    LoginHistoryRepository loginHistoryRepository;

    public void login(MyUserDetails userDetails)
    {
        LoginHistory loginHistory = new LoginHistory();
        loginHistory.setStartTime(new Date());
        loginHistory.setModule(userDetails.getEmail());
        try {
            loginHistory.setIpAddress(String.valueOf(InetAddress.getLocalHost().getHostAddress()));
        } catch (UnknownHostException e) {
            throw new RuntimeException(e);
        }
        JUser jUser = new JUser();
        jUser.setId(userDetails.getId());

        loginHistory.setJUser(jUser);

        loginHistoryRepository.save(loginHistory);

    }
}
