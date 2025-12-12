# JWT Security Demo - Student Exercises

## Setup Instructions

1. **Start the Application**
   ```bash
   mvn spring-boot:run
   ```
   The application will start on `http://localhost:8080`

2. **Open Postman**
   You'll be using Postman to test all endpoints

## Available Credentials

The application has two hardcoded users:

| Username | Password    | Role  |
|----------|-------------|-------|
| user     | password123 | USER  |
| admin    | admin123    | ADMIN |

---

## Exercise 1: Test the Public Endpoint (No Authentication Required)

**Goal:** Verify that some endpoints are publicly accessible without a JWT token.

**Steps:**
1. In Postman, create a new GET request
2. URL: `http://localhost:8080/api/public/welcome`
3. Send the request (no headers needed)

**Expected Result:**
- Status: 200 OK
- Response shows a welcome message

**Learning Point:** Not all endpoints require authentication. The `/api/auth/**` and public endpoints are configured to be accessible without tokens.

---

## Exercise 2: Login as USER and Get JWT Token

**Goal:** Authenticate as a regular user and receive a JWT token.

**Steps:**
1. Create a new POST request in Postman
2. URL: `http://localhost:8080/api/auth/login`
3. Select Body → raw → JSON
4. Enter the following JSON:
   ```json
   {
     "username": "user",
     "password": "password123"
   }
   ```
5. Send the request

**Expected Result:**
- Status: 200 OK
- Response contains:
  - `token`: A long JWT string (copy this! without the quotes)
  - `username`: "user"
  - `role`: "USER"

**Learning Point:** The login endpoint generates a JWT token that contains the user's identity and role. This token will be used for subsequent requests.

**Action:** Copy the token value from the response. You'll need it for the next exercises!

---

## Exercise 3: Access User Profile Endpoint (Any Authenticated User)

**Goal:** Use the JWT token to access a protected endpoint that any authenticated user can access.

**Steps:**
1. Create a new GET request
2. URL: `http://localhost:8080/api/user/profile`
3. Go to the Authorization tab
4. Select Type: "Bearer Token"
5. Paste the token you copied from Exercise 2
6. Send the request

**Expected Result:**
- Status: 200 OK
- Response shows personalized greeting with username

**Learning Point:** The `Authorization: Bearer <token>` header is how you send JWT tokens. Spring Security automatically validates the token and extracts user information.

**Try This:** 
- Remove the Authorization header and send again → Should get 4xx
- Use an invalid token → Should get 4xx

---

## Exercise 4: Access USER-Only Dashboard

**Goal:** Verify that the USER role can access USER-specific endpoints.

**Steps:**
1. Create a new GET request
2. URL: `http://localhost:8080/api/user/dashboard`
3. Authorization: Bearer Token (use the USER token from Exercise 2)
4. Send the request

**Expected Result:**
- Status: 200 OK
- Response indicates this is a USER-only endpoint

**Learning Point:** The `@PreAuthorize("hasRole('USER')")` annotation restricts this endpoint to users with the USER role specifically.

---

## Exercise 5: Try to Access ADMIN Panel as USER (Should Fail!)

**Goal:** Understand role-based access control by attempting to access an admin endpoint with a user token.

**Steps:**
1. Create a new GET request
2. URL: `http://localhost:8080/api/admin/panel`
3. Authorization: Bearer Token (use the USER token)
4. Send the request

**Expected Result:**
- Status: 403 Forbidden
- This proves that even though you're authenticated, you don't have the right role

**Learning Point:** Authentication (proving who you are) is different from Authorization (proving you have permission). The `@PreAuthorize("hasRole('ADMIN')")` annotation blocks non-admin users.

---

## Exercise 6: Login as ADMIN and Get JWT Token

**Goal:** Authenticate as an administrator and receive an admin JWT token.

**Steps:**
1. Create a new POST request
2. URL: `http://localhost:8080/api/auth/login`
3. Body → raw → JSON:
   ```json
   {
     "username": "admin",
     "password": "admin123"
   }
   ```
4. Send the request
5. **Copy the new admin token!**

**Expected Result:**
- Status: 200 OK
- Token contains role: "ADMIN"

**Learning Point:** Different users get different tokens with different roles embedded in them.

---

## Exercise 7: Access ADMIN Panel as ADMIN

**Goal:** Successfully access admin-only endpoints with the correct role.

**Steps:**
1. Create a new GET request
2. URL: `http://localhost:8080/api/admin/panel`
3. Authorization: Bearer Token (use the ADMIN token from Exercise 6)
4. Send the request

**Expected Result:**
- Status: 200 OK
- Response shows admin panel access granted

**Learning Point:** With the correct role in your JWT, you can access protected endpoints.

---

## Exercise 8: Try to Access USER Dashboard as ADMIN (Should Fail!)

**Goal:** Understand that role-based restrictions work both ways.

**Steps:**
1. Use the GET request for `/api/user/dashboard`
2. Authorization: Bearer Token (use the ADMIN token)
3. Send the request

**Expected Result:**
- Status: 403 Forbidden
- The USER dashboard is restricted to USER role only

**Learning Point:** The `@PreAuthorize("hasRole('USER')")` annotation specifically requires the USER role, not ADMIN. This demonstrates fine-grained access control.

---

## Exercise 9: Access Shared Resources (Both Roles Allowed)

**Goal:** Test an endpoint that allows multiple roles using `hasAnyRole`.

**Steps:**
1. Create a new GET request
2. URL: `http://localhost:8080/api/shared/resources`
3. Try with USER token → Should work
4. Try with ADMIN token → Should also work

**Expected Result:**
- Status: 200 OK for both tokens
- Response indicates this is a shared resource

**Learning Point:** The `@PreAuthorize("hasAnyRole('USER', 'ADMIN')")` annotation allows multiple roles to access the same endpoint.

---

## Exercise 10: Test Sensitive Admin Operation

**Goal:** Practice with an endpoint that represents a sensitive operation.

**Steps:**
1. Create a new GET request (we're not really deleting anything, but otherwise this was a DELETE request)
2. URL: `http://localhost:8080/api/admin/delete-user`
3. Try with USER token → Should fail (403)
4. Try with ADMIN token → Should succeed (200)

**Expected Result:**
- USER: 403 Forbidden
- ADMIN: 200 OK with deletion confirmation

**Learning Point:** Sensitive operations should always be protected with appropriate role checks.

---

## Bonus Challenges

### Challenge 1: Inspect Your JWT Token
Go to [jwt.io](https://jwt.io) and paste your token. Look at the payload - can you see:
- The username (subject)?
- The role claim?
- The expiration time?
- When the token was issued?

### Challenge 2: Test Token Expiration
The tokens in this demo expire after 1 hour. To test this quickly:
1. In `JwtService.java`, change `EXPIRATION_TIME` to `1000 * 10` (10 seconds)
2. Restart the application
3. Login and get a token
4. Wait 15 seconds
5. Try to access a protected endpoint → Should fail

### Challenge 3: Create a Postman Collection
Organize all your requests into a Postman Collection with:
- A folder for "Authentication"
- A folder for "USER Endpoints"
- A folder for "ADMIN Endpoints"
- Environment variables for the tokens

### Challenge 4: Test Invalid Credentials
Try logging in with:
- Wrong username
- Wrong password
- Empty fields
What responses do you get?

---

## Security Concepts Demonstrated

1. **JWT Structure**: Tokens contain header, payload, and signature
2. **Stateless Authentication**: No server-side session storage needed
3. **Role-Based Access Control (RBAC)**: Different roles have different permissions
4. **Method-Level Security**: Using `@PreAuthorize` annotations
5. **Token Validation**: Automatic verification of token signature and expiration
6. **HTTP Authorization Header**: Standard way to send tokens

---

## Common Annotations Reference

- `@PreAuthorize("hasRole('ROLE_NAME')")` - Requires specific role
- `@PreAuthorize("hasAnyRole('ROLE1', 'ROLE2')")` - Requires any of the listed roles
- `@PreAuthorize("isAuthenticated()")` - Requires any authenticated user
- `@PreAuthorize("permitAll()")` - Allows everyone (rarely used with @PreAuthorize)

---

## Troubleshooting

**401 Unauthorized Error**
- Token might be expired
- Token might be invalid or malformed
- Missing or incorrect Authorization header

**403 Forbidden Error**
- You're authenticated but don't have the required role
- Check which role your token has vs. what the endpoint requires

**Invalid Token**
- Make sure you copied the entire token
- Token should be in format: `Bearer <token>`
- No extra spaces or quotes

---

## Questions to Think About

1. What information is stored inside the JWT token?
2. Why don't we need sessions with JWT authentication?
3. What happens if someone steals your JWT token?
4. How is authentication different from authorization?
5. Where in the code is the JWT token validated?
6. How does Spring Security know which role a user has?

Good luck with the exercises!
