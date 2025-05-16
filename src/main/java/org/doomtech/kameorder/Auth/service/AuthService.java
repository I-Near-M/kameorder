package org.doomtech.kameorder.Auth.service;

import lombok.RequiredArgsConstructor;
import org.doomtech.kameorder.Auth.dto.AuthResponse;
import org.doomtech.kameorder.Auth.dto.LoginRequest;
import org.doomtech.kameorder.Auth.dto.RegisterRequest;
import org.doomtech.kameorder.jwt.JwtService;
import org.doomtech.kameorder.user.model.Role;
import org.doomtech.kameorder.user.model.User;
import org.doomtech.kameorder.user.repository.UserRepository;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthService {

    private final UserRepository userRepository;
    private final JwtService jwtService;
    private final PasswordEncoder passwordEncoder;
    private final AuthenticationManager authenticationManager;

    public AuthResponse login(LoginRequest request) {
        authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(request.getUsername(), request.getPassword()));
        UserDetails user = userRepository.findByUsername(request.getUsername())
                .orElseThrow(() -> new RuntimeException("User not found"));
        String token = jwtService.getToken(user);
        return AuthResponse.builder()
                .token(token)
                .build();
    }

    public AuthResponse register(RegisterRequest request) {
        User user = User.builder()
                .username(request.getUsername())
                .password(passwordEncoder.encode(request.getPassword()))
                .firstName(request.getFirstName())
                .lastName(request.getLastName())
                .country(request.getCountry())
                .role(Role.USER)
                .build();
        userRepository.save(user);

        return AuthResponse.builder()
                .token(jwtService.getToken(user))
                .build();
    }
    public AuthResponse refreshToken(String username) {
        UserDetails user = userRepository.findByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException("User not found"));

        String token = jwtService.getToken(user);
        return AuthResponse.builder()
                .token(token)
                .build();
    }

}
