package com.demo.springdemo;

public class Artist {
    public String name;
    public String albumTitle;
    public String songTitle;

    public Artist(String name, String albumTitle, String songTitle) {
        this.name = name;
        this.albumTitle = albumTitle;
        this.songTitle = songTitle;
    }

    public String getName() {
        return name;
    }

    public String getAlbumTitle() {
        return albumTitle;
    }

    public String getSongTitle() {
        return songTitle;
    }
}