package com.project.ourspace.data.model;

import android.widget.Toast;

import com.project.ourspace.ui.home.Tile;

import java.util.List;
import java.util.ArrayList;

public class TileList {
    static List<Tile> tileList;

    static {
        tileList = new ArrayList<>();
    }

    public static void addItem(Tile tile) {
        TileList.tileList.add(0, tile);
    }

    public static List<Tile> getTileList() {
        return tileList;
    }

    public static void setTileList(List<Tile> tileList) {
        TileList.tileList = tileList;
    }
}