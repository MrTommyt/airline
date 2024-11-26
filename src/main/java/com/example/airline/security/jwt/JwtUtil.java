package com.example.airline.security.jwt;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import jakarta.annotation.PostConstruct;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import java.nio.charset.StandardCharsets;
import java.security.Key;
import java.util.Date;

@SuppressWarnings("deprecation")
@Component
public class JwtUtil {
    private static Logger log = LoggerFactory.getLogger(JwtUtil.class);

    @Value("${app.jwt.secret}")
    private String SECRET;
    @Value("${app.jwt.expirationMs}")
    private long EXPIRATION_TIME;

    public String generateToken(Authentication authentication) {
        UserDetails userDetails = (UserDetails) authentication.getPrincipal();
        String token = Jwts.builder()
            .setSubject(userDetails.getUsername())
            .setIssuedAt(new Date())
            .setExpiration(new Date(new Date().getTime() + EXPIRATION_TIME))
            .signWith(getSecretKey(), SignatureAlgorithm.HS512)
            .compact();

        log.info("Token for user ({}): {}", userDetails.getUsername(), token);
        return token;
    }

    public boolean validateToken(String tkn) {
        try {
            Jwts.parser()
                .setSigningKey(getSecretKey())
                .build()
                .parseClaimsJws(tkn);
            return true;
        } catch (Exception e) {
            log.error("Error validating token: {}", e.getMessage());
        }
        return false;
    }

    public String getUsernameFromJwtToken(String token) {
        return Jwts.parser()
            .setSigningKey(getSecretKey())
            .build()
            .parseClaimsJws(token)
            .getBody()
            .getSubject();
    }

    @PostConstruct
    public void validateSecretKey() {
        if (SECRET.getBytes(StandardCharsets.UTF_8).length < 32) {
            throw new IllegalArgumentException("JWT secret key must be at least 32 characters long for HS512 algorithm.");
        }
    }

    public Key getSecretKey() {
        return Keys.hmacShaKeyFor(SECRET.getBytes(StandardCharsets.UTF_8));
    }
}
