package com.demo.spotifyapidemo;

import org.springframework.stereotype.Service;
import tools.jackson.databind.JsonNode;
import tools.jackson.databind.ObjectMapper;

import java.net.URI;
import java.net.URLEncoder;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.nio.charset.StandardCharsets;

/**
 * 🎧 SpotifyArtistService connects to the Spotify Web API
 * to fetch artist details and search for albums.
 */
@Service // Marks this class as a Spring service component (managed by the Spring container)
public class SpotifyArtistService {

    // Inject the SpotifyAuthService to get the access token
    private final SpotifyAuthService authService;

    // Constructor injection (recommended by Spring)
    public SpotifyArtistService(SpotifyAuthService authService) {
        this.authService = authService;
    }

    /**
     * 🎤 Get detailed info about a specific artist using their Spotify ID.
     * @param artistId the Spotify artist ID (e.g. 0TnOYISbd1XYRBk9myaseg for Pitbull)
     * @return JSON response containing artist data
     */
    public JsonNode getArtist(String artistId) throws Exception {
        // Step 1: Get a valid access token
        String accessToken = authService.getAccessToken();

        // Step 2: Build the Spotify API request URL
        String url = "https://api.spotify.com/v1/artists/" + artistId;

        // Step 3: Build the HTTP request with authorization header
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(url))
                .header("Authorization", "Bearer " + accessToken) // OAuth2 token in Bearer format
                .build();

        // Step 4: Create HTTP client and send the request
        HttpClient client = HttpClient.newHttpClient();
        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

        // Step 5: Parse the JSON response using Jackson 3.x
        ObjectMapper mapper = new ObjectMapper();
        return mapper.readTree(response.body()); // Returns a JsonNode object
    }

    /**
     * 🔍 Search for albums by an artist's name.
     * Calls: https://api.spotify.com/v1/search?q={artist}&type=album
     * @param artistName the name of the artist to search for (e.g. "Chris Brown")
     * @return JSON response containing a list of matching albums
     */
    public JsonNode searchAlbumsByArtist(String artistName) throws Exception {
        // Step 1: Get the access token from the auth service
        String accessToken = authService.getAccessToken();

        // Step 2: Encode the artist name for a URL-safe query string
        String query = URLEncoder.encode(artistName, StandardCharsets.UTF_8);

        // Step 3: Build the Spotify search URL
        String url = "https://api.spotify.com/v1/search?q=" + query + "&type=album&market=us";

        // Step 4: Create an HTTP request with Authorization header
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(url))
                .header("Authorization", "Bearer " + accessToken)
                .build();

        // Step 5: Send the HTTP request using Java's HttpClient
        HttpClient client = HttpClient.newHttpClient();
        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

        // Step 6: Parse the JSON response to extract albums
        ObjectMapper mapper = new ObjectMapper();
        return mapper.readTree(response.body()); // Returns a JsonNode tree structure
    }
}
