package com.example.jwtsecurity.controller;

import com.example.jwtsecurity.model.LoginRequest;
import com.example.jwtsecurity.model.LoginResponse;
import com.example.jwtsecurity.service.AuthenticationService;
import com.example.jwtsecurity.service.JwtService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    private final AuthenticationService authenticationService;
    private final JwtService jwtService;

    public AuthController(AuthenticationService authenticationService, JwtService jwtService) {
        this.authenticationService = authenticationService;
        this.jwtService = jwtService;
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody LoginRequest loginRequest) {
        AuthenticationService.UserDetails user = authenticationService.authenticate(
            loginRequest.getUsername(), 
            loginRequest.getPassword()
        );

        if (user == null) {
            return ResponseEntity.status(401).body("Invalid username or password");
        }

        String token = jwtService.generateToken(user.getUsername(), user.getRole());
        LoginResponse response = new LoginResponse(token, user.getUsername(), user.getRole());

        return ResponseEntity.ok(response);
    }
}
