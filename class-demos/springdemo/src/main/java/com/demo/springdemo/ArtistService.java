package com.demo.springdemo;

import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class ArtistService {
    public Artist getFavoriteArtist() {
        return new Artist(
                "C.A.S.",
                "X's",
                "Hideaway"
        );
    }

    public List<Artist> getAllArtists() {
        return List.of(
                new Artist("The Weeknd", "After Hours", "Blinding Lights"),
                new Artist("Adele", "21", "Rolling in the Deep"),
                new Artist("Coldplay", "Parachutes", "Yellow")
        );
    }

    public Artist getArtistByName(String name) {
        for (Artist a : getAllArtists()) {
            if (a.getName().equalsIgnoreCase(name)) {
                return a;
            }
        }

        //if not found
        return null;
    }
}