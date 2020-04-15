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

        List<Tile> tileList = TileList.getTileList();

        if (tileList.isEmpty()) {
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

                    new Tile(3, "Jane", "04 Apr 2020",
                            "F.R.I.E.N.D.S", 3,11,new double[2][3],"@drawable/friends"));
        }

        mList.setValue(tileList);
    }

    public LiveData<List<Tile>> getList() {
        return mList;
    }
}