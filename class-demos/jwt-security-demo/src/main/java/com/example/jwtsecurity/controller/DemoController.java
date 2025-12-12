package com.example.jwtsecurity.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api")
public class DemoController {

    /**
     * EXERCISE 1: Public endpoint (no authentication needed)
     * This endpoint is accessible to everyone without a token
     */
    @GetMapping("/public/welcome")
    public Map<String, String> publicWelcome() {
        Map<String, String> response = new HashMap<>();
        response.put("message", "Welcome! This is a public endpoint - no authentication required.");
        return response;
    }

    /**
     * EXERCISE 2: Any authenticated user can access
     * Both USER and ADMIN can access this endpoint
     */
    @GetMapping("/user/profile")
    public Map<String, String> userProfile(Authentication authentication) {
        Map<String, String> response = new HashMap<>();
        response.put("message", "Hello " + authentication.getName() + "!");
        response.put("info", "This endpoint requires authentication but any role can access it.");
        return response;
    }

    /**
     * EXERCISE 3: Only users with USER role can access
     * ADMIN cannot access this endpoint
     */
    @PreAuthorize("hasRole('USER')")
    @GetMapping("/user/dashboard")
    public Map<String, String> userDashboard(Authentication authentication) {
        Map<String, String> response = new HashMap<>();
        response.put("message", "Welcome to your user dashboard, " + authentication.getName() + "!");
        response.put("info", "Only users with USER role can access this endpoint.");
        return response;
    }

    /**
     * EXERCISE 4: Only users with ADMIN role can access
     * Regular users cannot access this endpoint
     */
    @PreAuthorize("hasRole('ADMIN')")
    @GetMapping("/admin/panel")
    public Map<String, String> adminPanel(Authentication authentication) {
        Map<String, String> response = new HashMap<>();
        response.put("message", "Welcome to the admin panel, " + authentication.getName() + "!");
        response.put("info", "Only users with ADMIN role can access this endpoint.");
        return response;
    }

    /**
     * EXERCISE 5: Both USER and ADMIN can access
     * Uses hasAnyRole to allow multiple roles
     */
    @PreAuthorize("hasAnyRole('USER', 'ADMIN')")
    @GetMapping("/shared/resources")
    public Map<String, String> sharedResources(Authentication authentication) {
        Map<String, String> response = new HashMap<>();
        response.put("message", "Shared resources for " + authentication.getName());
        response.put("info", "Both USER and ADMIN roles can access this endpoint.");
        return response;
    }

    /**
     * EXERCISE 6: Admin-only delete operation
     * Demonstrates protecting sensitive operations
     */
    @PreAuthorize("hasRole('ADMIN')")
    @GetMapping("/admin/delete-user")
    public Map<String, String> deleteUser(Authentication authentication) {
        Map<String, String> response = new HashMap<>();
        response.put("message", "User deletion initiated by " + authentication.getName());
        response.put("warning", "This is a sensitive operation - only ADMIN can perform this.");
        return response;
    }
}
