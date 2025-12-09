package com.demo.spotifyapidemo;

import org.springframework.web.bind.annotation.*;
import tools.jackson.databind.JsonNode;

/**
 * 🎧 SpotifyController handles HTTP requests from the outside world.
 * It exposes REST endpoints like:
 * - /spotify/artist/{id}
 * - /spotify/search?artist=...
 *
 * These endpoints let users interact with the Spotify Web API via our service layer.
 */
@RestController // Tells Spring this class is a REST API controller (not returning HTML)
@RequestMapping("/spotify") // All routes here start with /spotify
public class SpotifyController {

    // We inject the service layer which handles all Spotify API logic
    private final SpotifyArtistService artistService;

    /**
     * ✅ Constructor injection: Spring will automatically provide the SpotifyArtistService instance.
     */
    public SpotifyController(SpotifyArtistService artistService) {
        this.artistService = artistService;
    }

    /**
     * 🎤 GET /spotify/artist/{id}
     * Fetches detailed information about an artist using their Spotify ID.
     * Example: /spotify/artist/0TnOYISbd1XYRBk9myaseg
     *
     * @param id The Spotify artist ID
     * @return JSON with artist info (name, genres, popularity, etc.)
     */
    @GetMapping("/artist/{id}")
    public JsonNode getArtist(@PathVariable String id) throws Exception {
        // @PathVariable pulls {id} from the URL path
        return artistService.getArtist(id);
    }

    /**
     * 🔍 GET /spotify/search?artist=Chris+Brown
     * Searches for albums by a given artist name using Spotify's /search endpoint.
     *
     * @param artist The artist name to search (e.g., "Drake")
     * @return JSON with album data (title, release date, etc.)
     */
    @GetMapping("/search")
    public JsonNode searchAlbums(@RequestParam("artist") String artist) throws Exception {
        // @RequestParam pulls the ?artist= value from the query string
        return artistService.searchAlbumsByArtist(artist);
    }
}
