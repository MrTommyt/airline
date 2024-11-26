package com.example.airline.dto.auth;

import org.springframework.security.core.userdetails.UserDetails;

public record AuthResponse(String token, UserDetails user) {
}
