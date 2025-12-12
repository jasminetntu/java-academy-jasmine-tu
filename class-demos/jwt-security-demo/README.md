# JWT Security Demo - Instructor Guide

## Overview

This is a Spring Boot demonstration application for teaching JWT authentication and Spring Security annotations. It provides hands-on exercises for students to learn about token-based authentication, role-based access control, and security best practices.

## Project Structure

```
jwt-security-demo/
├── src/main/java/com/example/jwtsecurity/
│   ├── JwtSecurityApplication.java          # Main application class
│   ├── config/
│   │   ├── JwtAuthenticationFilter.java     # Filter that validates JWT tokens
│   │   └── SecurityConfig.java              # Spring Security configuration
│   ├── controller/
│   │   ├── AuthController.java              # Login endpoint
│   │   └── DemoController.java              # Demo endpoints with various security levels
│   ├── model/
│   │   ├── LoginRequest.java                # Login request DTO
│   │   └── LoginResponse.java               # Login response with JWT token
│   └── service/
│       ├── AuthenticationService.java       # User authentication (hardcoded users)
│       └── JwtService.java                  # JWT generation and validation
├── src/main/resources/
│   └── application.properties               # Application configuration
├── pom.xml                                  # Maven dependencies
└── EXERCISES.md                             # Student exercise guide
```

## Key Learning Objectives

1. **JWT Basics**
   - Understanding token structure (header, payload, signature)
   - Token generation and validation
   - Token expiration and refresh concepts

2. **Spring Security Concepts**
   - Stateless authentication
   - Security filter chain
   - Method-level security with annotations
   - Role-based access control (RBAC)

3. **REST API Security**
   - Bearer token authentication
   - Authorization header usage
   - HTTP status codes (401 vs 403)

4. **Security Annotations**
   - `@PreAuthorize("hasRole('ROLE')")`
   - `@PreAuthorize("hasAnyRole('ROLE1', 'ROLE2')")`
   - `@EnableMethodSecurity`

## Hardcoded Users

| Username | Password    | Role  |
|----------|-------------|-------|
| user     | password123 | USER  |
| admin    | admin123    | ADMIN |

**Note:** In production, passwords should be encrypted using BCrypt or similar, and users should be stored in a database.

## Endpoints Overview

### Public Endpoints (No Authentication)
- `POST /api/auth/login` - Login and receive JWT token
- `GET /api/public/welcome` - Public welcome message

### Protected Endpoints (Authentication Required)
- `GET /api/user/profile` - Any authenticated user
- `GET /api/user/dashboard` - USER role only
- `GET /api/admin/panel` - ADMIN role only
- `GET /api/shared/resources` - USER or ADMIN role
- `GET /api/admin/delete-user` - ADMIN role only (sensitive operation)

## Running the Application

```bash
# Using Maven
mvn spring-boot:run

# Or build and run the JAR
mvn clean package
java -jar target/jwt-security-demo-1.0.0.jar
```

The application will start on `http://localhost:8080`

## Testing with Postman

Students should follow the exercises in `EXERCISES.md` which walks them through:
1. Accessing public endpoints
2. Logging in to get JWT tokens
3. Using tokens to access protected endpoints
4. Testing role-based access control
5. Understanding authentication vs authorization

## Common Student Questions

**Q: Why do we add "ROLE_" prefix in the filter but not in @PreAuthorize?**
A: Spring Security internally expects roles to be prefixed with "ROLE_", but the `hasRole()` method automatically adds this prefix. The `hasAuthority()` method doesn't add the prefix.

**Q: Can someone decode the JWT and see the user's role?**
A: Yes! JWT is encoded but not encrypted. Anyone can decode it (use jwt.io to show students). The signature prevents tampering, but the content is visible. Never put sensitive data like passwords in JWTs.

**Q: What if someone steals a JWT token?**
A: They can impersonate the user until the token expires. This is why:
- Tokens should have short expiration times
- HTTPS should always be used
- Tokens should be stored securely (not in localStorage if possible)
- Refresh tokens provide a balance between security and convenience

**Q: Why not use sessions instead of JWT?**
A: JWTs are stateless (no server-side storage), making them ideal for:
- Microservices architectures
- Horizontal scaling
- Mobile apps
- API-first designs

Sessions are still fine for traditional web apps.

**Q: How do we handle token refresh?**
A: This demo doesn't include refresh tokens (to keep it simple), but in production:
- Issue short-lived access tokens (15 minutes)
- Issue long-lived refresh tokens (7 days)
- Use refresh tokens to get new access tokens
- Refresh tokens can be revoked server-side
