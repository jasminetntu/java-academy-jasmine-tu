package com.demo.spotifyapidemo;

import org.springframework.stereotype.Service;
import tools.jackson.databind.JsonNode;
import tools.jackson.databind.ObjectMapper;

import java.nio.charset.StandardCharsets;
import java.util.Base64;
import java.net.http.*;
import java.net.URI;

/**
 * 🎧 SpotifyAuthService is responsible for one job:
 * 👉 Retrieving an OAuth access token from Spotify using Client Credentials Flow.
 *
 * This token allows our app to talk to Spotify’s Web API.
 */
@Service
public class SpotifyAuthService {

    /**
     * ⚠️ Normally you NEVER hard‑code secrets!
     * You would store these in application.properties or environment variables.
     * But for teaching/demo purposes, we keep them here.
     */
    private static final String CLIENT_ID = "insert-id";
    private static final String CLIENT_SECRET = "insert-secret";

    /**
     * 🎯 This method retrieves an access token required to call Spotify API endpoints.
     * It uses Spotify's Client Credentials OAuth2 flow.
     */
    public String getAccessToken() throws Exception {

        // ----------------------------------------------------------
        // 1️⃣ Combine CLIENT_ID and CLIENT_SECRET into "id:secret"
        // ----------------------------------------------------------
        String auth = CLIENT_ID + ":" + CLIENT_SECRET;

        // ----------------------------------------------------------
        // 2️⃣ Encode the "id:secret" string as Base64 as required by Spotify
        // Example output: QWxhZGRpbjpvcGVuIHNlc2FtZQ==
        // ----------------------------------------------------------
        String encodedAuth = Base64.getEncoder()
                .encodeToString(auth.getBytes(StandardCharsets.UTF_8));

        // ----------------------------------------------------------
        // 3️⃣ Create an HTTP client (Java 11+ built‑in HTTP client)
        // ----------------------------------------------------------
        HttpClient client = HttpClient.newHttpClient();

        // ----------------------------------------------------------
        // 4️⃣ Build the POST request to Spotify's auth endpoint
        // - We send encoded credentials in the Authorization header
        // - grant_type=client_credentials tells Spotify what type of auth flow we use
        // ----------------------------------------------------------
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create("https://accounts.spotify.com/api/token"))
                .header("Authorization", "Basic " + encodedAuth)   // OAuth2 Basic auth header
                .header("Content-Type", "application/x-www-form-urlencoded")
                .POST(HttpRequest.BodyPublishers.ofString("grant_type=client_credentials"))
                .build();

        // ----------------------------------------------------------
        // 5️⃣ Execute the HTTP request and receive a JSON response
        // Example response:
        // {
        //   "access_token": "BQDx...",
        //   "token_type": "Bearer",
        //   "expires_in": 3600
        // }
        // ----------------------------------------------------------
        HttpResponse<String> response =
                client.send(request, HttpResponse.BodyHandlers.ofString());

        // ----------------------------------------------------------
        // 6️⃣ Use Jackson 3.x to read JSON from the response body
        // ----------------------------------------------------------
        ObjectMapper mapper = new ObjectMapper();
        JsonNode json = mapper.readTree(response.body());

        // ----------------------------------------------------------
        // 7️⃣ Extract the "access_token" field value as a plain string
        // json.get("access_token").toString() would include quotes → ❌
        // .asString() gives clean output → ✔️
        // ----------------------------------------------------------
        return json.get("access_token").asString();
    }}
//}

