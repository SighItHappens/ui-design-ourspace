package com.project.ourspace.ui.home;

public class Tile {
    private int id;
    private String title;

    public Tile(int id, String title) {
        this.id = id;
        this.title = title;
    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }
}
