package com.project.ourspace.ui.home;

public class Tile {

    // Generic Fields
    private int type;
    private String name;
    private String time;

    // Image fields
    private String image;

    // Song fields
    private String song_name;
    private String artist_name;
    private String song_link;

    // TV Show fields
    private String showName;
    private int seasons;
    private int episodes;
    private int[][] showProgress;


    // Note fields
    private String note;
    private String noteTitle;

    // Constructor for the image tile
    // Type = 1
    public Tile(int type, String name, String time, String image) {
        this.type = type;
        this.name = name;
        this.time = time;
        this.image = image;
    }

    // Constructor for the Song type
    // Type = 2
    public Tile(int type, String name, String time, String song_name, String artist_name, String song_link) {
        this.type = type;
        this.name = name;
        this.time = time;
        this.song_name = song_name;
        this.artist_name = artist_name;
        this.song_link = song_link;
    }

    //Constructor for the TV Show type
    public Tile(int type, String name, String time,String showName, int seasons, int episodes, int[][] showProgress, String image){
        this.type = type;
        this.name = name;
        this.time = time;
        this.showName = showName;
        this.seasons = seasons;
        this.episodes = episodes;
        this.showProgress = showProgress;
        this.image = image;
    }

    // Constructor for the note tile
    // Type = 4
    public Tile(int type, String name, String time, String noteTitle, String note) {
        this.type = type;
        this.name = name;
        this.time = time;
        this.note = note;
        this.noteTitle = noteTitle;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getImage() {
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

    public void setSong_link(String song_link) {
        this.song_link = song_link;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public String getNoteTitle() {
        return noteTitle;
    }

    public void setNoteTitle(String noteTitle) {
        this.noteTitle = noteTitle;
    }
}

