package org.example.controller;

import lombok.RequiredArgsConstructor;
import org.example.dto.LoginDTO;
import org.example.dto.UserDTO;
import org.example.entity.User;
import org.example.service.LoggedService;
import org.example.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequiredArgsConstructor
public class LoginController {
    private final UserService userService;
    private final LoggedService loggedService;


    @GetMapping("login")
    public String ShowLogin(Model model) {
        model.addAttribute("Login", new User());
        return "Login";
    }

    @PostMapping("login")
    public String Login(LoginDTO dto, Model model) {
        String result = userService.Login(dto.getUserEmail(), dto.getPassword(), model);
        if ("success".equals(result)) {
            loggedService.setUserEmail(dto.getUserEmail());
            return "redirect:/index";
        } else {
            model.addAttribute("error", "Login Falled");
            return "Login";
        }
    }
}