package com.ms.auth.service;

import java.util.Optional;

import com.ms.auth.entity.User;
import com.ms.auth.feignclient.UserFeignClient;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserFeignClient userFeignClient;

    public User findByEmail(String email) {
        return Optional.of(userFeignClient.findByEmail(email).getBody())
                .orElseThrow(() -> new IllegalArgumentException("Email not found"));
    }
}
