package org.doomtech.kameorder.Auth.controller;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.doomtech.kameorder.Auth.service.AuthService;
import org.doomtech.kameorder.Auth.dto.AuthResponse;
import org.doomtech.kameorder.Auth.dto.LoginRequest;
import org.doomtech.kameorder.Auth.dto.RegisterRequest;
import org.doomtech.kameorder.jwt.JwtService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthController {

    private final AuthService authService;
    private final JwtService jwtService;

    @PostMapping("/login")
    public ResponseEntity<AuthResponse> login(@RequestBody @Valid LoginRequest request) {
        return ResponseEntity.ok(authService.login(request));
    }

    @PostMapping("/register")
    public ResponseEntity<AuthResponse> register(@RequestBody @Valid RegisterRequest request) {
        return ResponseEntity.ok(authService.register(request));
    }

    @PostMapping("/refresh")
    public ResponseEntity<AuthResponse> refreshToken(HttpServletRequest request) {
        String token = jwtService.extractToken(request); // Debes implementarlo
        String username = jwtService.getUsernameFromToken(token);
        return ResponseEntity.ok(authService.refreshToken(username));
    }

}
