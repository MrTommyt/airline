package com.example.airline.controllers;

import com.example.airline.dto.UserInfoDto;
import com.example.airline.security.jwt.JwtUtil;
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

    @PostMapping("/sign-in")
    public ResponseEntity<UserInfoDto> createUser(@RequestBody UserInfoDto signInRequest) {
        UserInfoDto userInfoDto = userDetailsService.addUser(signInRequest);
        return ResponseEntity.status(HttpStatus.CREATED).body(userInfoDto);
    }

    @PostMapping("/login")
    public ResponseEntity<String> authenticateUser(@RequestBody UserInfoDto loginRequest) {
        System.out.println(loginRequest.username());
        System.out.println(loginRequest.password());
        try {
            Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(loginRequest.email(), loginRequest.password())
            );

            System.out.printf("isAuthenticated: %b%n", authentication.isAuthenticated());
            if (authentication.isAuthenticated()) {
                String jwt = jwtUtils.generateToken(authentication);
                System.out.println("jwt: " + jwt);
                return ResponseEntity.ok(jwt);
            } else {
                throw new UsernameNotFoundException("Invalid username or password");
            }
        } catch (AuthenticationException e) {
            e.printStackTrace();
        } catch (Throwable t) {
            System.out.println("Unexpected exception");
            t.printStackTrace();
        } finally {
            System.out.println("executing finally code");
        }

        System.out.println("Unauthorized");
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Unauthorized");
    }
}
