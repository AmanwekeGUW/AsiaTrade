package org.example.controller;

import lombok.RequiredArgsConstructor;
import org.example.dto.JwtAuthToken;
import org.example.dto.UserDTO;
import org.example.service.AuthService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@CrossOrigin(origins ="http://localhost:3000")
@RequestMapping("/auth")
public class AuthController {
    private final AuthService authService;
 @PostMapping("/login")
    public JwtAuthToken login(@RequestBody UserDTO userDTO){
        return authService.login(userDTO);
 }
    @PostMapping("/register")
    public JwtAuthToken register(@RequestBody UserDTO userDTO){
        return authService.register(userDTO);
    }
}
