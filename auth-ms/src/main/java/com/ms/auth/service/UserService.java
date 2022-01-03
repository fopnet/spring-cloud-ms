package com.ms.auth.service;

import java.util.Optional;

import com.ms.auth.entity.User;
import com.ms.auth.feignclient.UserFeignClient;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserService implements UserDetailsService {

    @Autowired
    private UserFeignClient userFeignClient;

    public User findByEmail(String email) {
        return Optional.of(userFeignClient.findByEmail(email).getBody())
                .orElseThrow(() -> new IllegalArgumentException("Email not found"));
    }

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        try {
            return findByEmail(email);
        } catch (IllegalArgumentException e) {
            throw new UsernameNotFoundException(e.getMessage(), e);
        }
    }
}
