package com.example.airline.security.service;

import com.example.airline.dto.UserInfoDto;
import com.example.airline.models.Role;
import com.example.airline.models.RoleType;
import com.example.airline.models.User;
import com.example.airline.repositories.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    private static final Logger log = LoggerFactory.getLogger(UserDetailsServiceImpl.class);

    public UserDetailsServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
        this.passwordEncoder = new BCryptPasswordEncoder();
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<User> userOptional = userRepository.findByUsername(username);

        if (userOptional.isEmpty()) {
            throw new UsernameNotFoundException("[ERROR]: is Empty");
        }
        return UserDetailsImp.build(userOptional.get());
    }

    public UserInfoDto addUser(UserInfoDto userInfo) {
        User user = new User(null, userInfo.username(), userInfo.email(), passwordEncoder.encode(userInfo.password()),
                Arrays.stream(userInfo.roles().split(" "))
                        .map(role -> new Role(RoleType.valueOf(role)))
                        .collect(Collectors.toSet())
        );
        user = userRepository.save(user);
        return new UserInfoDto(user.getUsername(), user.getEmail(), user.getPassword(), userInfo.roles());
    }
}
