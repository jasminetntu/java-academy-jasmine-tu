package com.example.jwtsecurity.service;

import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class AuthenticationService {
    
    // Hardcoded users for demo purposes
    // In production, this would come from a database with encrypted passwords
    private final Map<String, UserDetails> users = new HashMap<>();

    public AuthenticationService() {
        // Initialize hardcoded users
        users.put("user", new UserDetails("user", "password123", "USER"));
        users.put("admin", new UserDetails("admin", "admin123", "ADMIN"));
    }

    public UserDetails authenticate(String username, String password) {
        UserDetails user = users.get(username);
        if (user != null && user.password.equals(password)) {
            return user;
        }
        return null;
    }

    // Simple inner class to hold user details
    public static class UserDetails {
        private final String username;
        private final String password;
        private final String role;

        public UserDetails(String username, String password, String role) {
            this.username = username;
            this.password = password;
            this.role = role;
        }

        public String getUsername() {
            return username;
        }

        public String getRole() {
            return role;
        }
    }
}
