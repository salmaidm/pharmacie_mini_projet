package com.salma.mini_projet_pharmacie.controller;

import com.salma.mini_projet_pharmacie.model.User;
import com.salma.mini_projet_pharmacie.service.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthController {

    private final AuthService authService;

    /**
     * LOGIN
     * POST /auth/login?email=...&password=...
     */
    @PostMapping("/login")
    public User login(@RequestParam String email,
                      @RequestParam String password) {
        return authService.login(email, password);
    }
}
