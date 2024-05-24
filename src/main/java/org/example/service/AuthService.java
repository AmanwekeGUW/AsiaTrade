package org.example.service;

import io.jsonwebtoken.security.Password;
import lombok.RequiredArgsConstructor;
import org.example.dto.JwtAuthToken;
import org.example.dto.UserDTO;
import org.example.entity.Role;
import org.example.entity.User;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthService {
    private final UserService userService;
    private final JwtService jwtService;
    private final PasswordEncoder passwordEncoder;
    private final AuthenticationManager authenticationManager;

    public JwtAuthToken register(UserDTO userDTO){
        User user = User.builder()
                .userName(userDTO.getUserName())
                .userEmail(userDTO.getUserEmail())
                .userPassword(passwordEncoder.encode(userDTO.getPassword()))
                .role(Role.ROLE_USER)
                .build();
        userService.create(user);
        String token = jwtService.generateToken(user);
        return new JwtAuthToken(token);
    }
    public JwtAuthToken login(UserDTO userDTO){
        authenticationManager.authenticate(new UsernamePasswordAuthenticationToken
                (userDTO.getUserName(),userDTO.getPassword()));
        var user = userService
                .userDetailsService()
                .loadUserByUsername(userDTO.getUserName());
        String token = jwtService.generateToken(user);
        return new JwtAuthToken(token);
    }

}
