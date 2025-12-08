package com.demo.springdemo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ArtistController {

    private final ArtistService service;

    public ArtistController(ArtistService service) {
        this.service = service;
    }

    @GetMapping("/artist")
    public Artist getFavoriteArtist() {
        return service.getFavoriteArtist();
    }

    @GetMapping("/artist/name")
    public String getFavoriteArtistName() {
        return service.getFavoriteArtist().name;
    }

    @GetMapping("/artists")
    public List<Artist> getAllArtists() {
        return service.getAllArtists();
    }

    @GetMapping("/artist/{name}")
    public Artist getArtistByName(@PathVariable String name) {
        return service.getArtistByName(name);
    }


}
