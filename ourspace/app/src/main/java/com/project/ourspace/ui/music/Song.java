package com.project.ourspace.ui.music;


public class Song {
    private static int count;
    private int id;
    private String songName;
    private String artistName;
    private String songUrl;

    public Song(String init_song, String init_artist, String init_url) {
        this.id = ++count;
        this.songName = init_song;
        this.artistName = init_artist;
        this.songUrl = init_url;
    }

    public int getId() {
        return id;
    }

    public String getSongName() {
        return songName;
    }

    public String getArtistName(){
        return artistName;
    }

    public String getSongUrl() {
        return songUrl;
    }
}
