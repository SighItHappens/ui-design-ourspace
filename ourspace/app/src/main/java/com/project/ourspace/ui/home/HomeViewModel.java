package com.project.ourspace.ui.home;

import android.util.Log;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.project.ourspace.R;
import com.project.ourspace.data.model.TileList;

import java.util.ArrayList;
import java.util.List;

import static com.project.ourspace.R.drawable.two_and_a_half_men;

public class HomeViewModel extends ViewModel {

    private static final String TAG = "HomeViewModel";

    private MutableLiveData<List<Tile>> mList;
    List<Tile> tileList = new ArrayList<>();
    public HomeViewModel() {
        Log.d(TAG, "HomeViewModel: Started");
        mList = new MutableLiveData<>();

//        List<Tile> tileList = TileList.getTileList();

        // Adding some items to our list
        tileList.add(
                new Tile(
                        1, "Jake", "04 Apr 2020", "filler"));
        tileList.add(
                new Tile(
                        1, "Jacob", "03 Apr 2020", "snowman"));
        tileList.add(
                new Tile(
                        2, "Sam", "05 Apr 2020", "Eleven", "Khalid", "https://open.spotify.com/track/1ToprX3cpBiXoAe5eNSk74?si=AELZvNrpQ1eNaFio74RJ8Q"
                )
        );
        tileList.add(
                new Tile(
                        4, "Sam", "05 Apr 2020", "Hello there", "General Kenobi"
                )
        );
        tileList.add(
                new Tile(
                        3, "Shravya", "09 Apr 2020", "two_and_a_half_men"));

        mList.setValue(tileList);

    }

    public void addItem(int type, String user, String time, String image) {
        Log.d(TAG, "addItem: Started");
//        TileList.addItem(new Tile(type, user, time, image));
        List<Tile> tileList = mList.getValue();
        tileList.add(new Tile(type, user, time, image));
        mList.postValue(tileList);
    }

    public void addMusicItem(int type, String user, String time, String songName, String artistName, String url) {
        Log.d(TAG, "addMusicItem: Started");
//        TileList.addItem(new Tile(type, user, time, songName, artistName, url));
        List<Tile> tileList = mList.getValue();
        tileList.add(new Tile(type, user, time, songName, artistName, url));
        mList.postValue(tileList);
    }

    public LiveData<List<Tile>> getList() {
        return mList;
    }
}