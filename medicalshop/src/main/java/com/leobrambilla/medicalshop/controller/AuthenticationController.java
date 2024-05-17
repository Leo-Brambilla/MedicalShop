package com.leobrambilla.medicalshop.controller;

import com.leobrambilla.medicalshop.domain.user.AuthenticationData;
import com.leobrambilla.medicalshop.domain.user.User;
import com.leobrambilla.medicalshop.domain.user.UserRepository;
import com.leobrambilla.medicalshop.infra.security.TokenService;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class AuthenticationController {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private TokenService tokenService;

    @PostMapping("/register")
    public void register(@RequestBody User user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        userRepository.save(user);
    }

    @PostMapping("/login")
    public String authenticate(@RequestBody AuthenticationData data) {
        try {
            Authentication authentication = authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(data.login(), data.password()));
            var user = (User) authentication.getPrincipal();
            return tokenService.tokenGenerator(user);
        } catch (AuthenticationException e) {
            throw new RuntimeException("Invalid login or password", e);
        }
    }
}
