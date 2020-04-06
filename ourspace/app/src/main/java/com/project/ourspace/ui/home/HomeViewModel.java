package com.project.ourspace.ui.home;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.project.ourspace.R;

import java.util.ArrayList;
import java.util.List;

import static com.project.ourspace.R.drawable.two_and_a_half_men;

public class HomeViewModel extends ViewModel {

    private MutableLiveData<String> mText;
    private MutableLiveData<List<Tile>> mList;

    public HomeViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("This is home fragment");
        mList = new MutableLiveData<>();

        List<Tile> tileList = new ArrayList<>();

        //adding some items to our list
        tileList.add(
                new Tile(
                         1, "Jake", "04/04/20", "filler"));


        tileList.add(
                new Tile(
                        1, "Jacob", "04/03/20", "snowman"));

        tileList.add(
                new Tile(
                        2, "Sam", "04/05/20", "Eleven", "Khalid", "https://open.spotify.com/track/1ToprX3cpBiXoAe5eNSk74?si=AELZvNrpQ1eNaFio74RJ8Q"
                )
        );

        mList.setValue(tileList);
    }

    public LiveData<String> getText() {
        return mText;
    }


    public LiveData<List<Tile>> getList() {
        return mList;
    }
}