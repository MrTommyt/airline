package com.example.airline.controllers;

import com.example.airline.dto.UserInfoDto;
import com.example.airline.dto.auth.AuthRequest;
import com.example.airline.dto.auth.AuthResponse;
import com.example.airline.repositories.UserRepository;
import com.example.airline.security.jwt.JwtUtil;
import com.example.airline.security.service.UserDetailsImp;
import com.example.airline.security.service.UserDetailsServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class UserController {
    private final UserDetailsServiceImpl userDetailsService;
    private final JwtUtil jwtUtils;
    private final AuthenticationManager authenticationManager;

    @Autowired
    public UserController(UserDetailsServiceImpl userDetailsService, JwtUtil jwtUtils, AuthenticationManager authenticationManager) {
        this.userDetailsService = userDetailsService;
        this.jwtUtils = jwtUtils;
        this.authenticationManager = authenticationManager;
    }

    @PostMapping("/signup")
    public ResponseEntity<UserInfoDto> createUser(@RequestBody UserInfoDto signInRequest) {
        UserInfoDto userInfoDto = userDetailsService.addUser(signInRequest);
        return ResponseEntity.status(HttpStatus.CREATED).body(userInfoDto);
    }

    @PostMapping("/login")
    public ResponseEntity<AuthResponse> authenticateUser(@RequestBody AuthRequest loginRequest) {
        Authentication authentication = authenticationManager.authenticate(
            new UsernamePasswordAuthenticationToken(loginRequest.email(), loginRequest.password())
        );

        if (authentication.isAuthenticated()) {
            String jwt = jwtUtils.generateToken(authentication);
            UserDetailsImp ud = (UserDetailsImp) authentication.getPrincipal();
            return ResponseEntity.ok(new AuthResponse(jwt, ud));
        } else {
            throw new UsernameNotFoundException("Invalid username or password");
        }
    }
}
