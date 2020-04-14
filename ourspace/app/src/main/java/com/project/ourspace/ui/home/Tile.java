package com.project.ourspace.ui.home;

import android.drm.DrmStore;

public class Tile {
    // Generic Fields
    private int type;
    private String Name;
    private String Time;

    // Image fields
    private String image;

    // Song fields
    private String song_name;
    private String artist_name;
    private String song_link;
    //Note fields
    private String note;

    //Constructor for the image tile
    // Type = 1
    public Tile(int type, String Name, String Time, String image) {
        this.type = type;
        this.Name = Name;
        this.Time = Time;
        this.image = image;
    }
//    public Tile(int type, String Name, String Time, String note) {
//        this.type = type;
//        this.Name = Name;
//        this.Time = Time;
//        this.note = note;
//    }

    //Constructor for the Song type
    // Type = 2
    public Tile(int type, String name, String Time, String song_name, String artist_name, String song_link) {
        this.type = type;
        this. Name = name;
        this.Time = Time;
        this.song_name = song_name;
        this.artist_name = artist_name;
        this.song_link = song_link;
    }



    //Make constructors for each type of tile


    public String getName() {
    return Name;
}

    public void setName(String name) {
        Name = name;
    }

    public String getTime() {
        return Time;
    }

    public void setTime(String time) {
        Time = time;
    }


    public String  getImage() {
        return image;
    }
    public void setImage(String _image) {
        image = _image;
    }

    public int getType() {
        return type;
    }
    public void setType(int Type) {
        type = Type;
    }

    public String getSong_name() {
        return song_name;
    }

    public void setSong_name(String song_name) {
        this.song_name = song_name;
    }

    public String getArtist_name() {
        return artist_name;
    }

    public void setArtist_name(String artist_name) {
        this.artist_name = artist_name;
    }

    public String getSong_link() {
        return song_link;
    }
//    public String getNote(){return note;}


    public void setSong_link(String song_link) {
        this.song_link = song_link;
    }
}

