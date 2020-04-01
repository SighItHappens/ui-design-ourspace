package com.project.ourspace.ui.home;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import java.util.ArrayList;
import java.util.List;

public class HomeViewModel extends ViewModel {

    private MutableLiveData<String> mText;
    private MutableLiveData<List<Tile>> mList;
    private List<Tile> tileList;

    public HomeViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("This is home fragment");
        mList = new MutableLiveData<>();

        tileList = new ArrayList<>();


        //adding some items to our list
        tileList.add(
                new Tile(
                        1,
                        "Item1"));

        tileList.add(
                new Tile(
                        1,
                        "Item2"));

        tileList.add(
                new Tile(
                        1,
                        "Item2"));
        mList.setValue(tileList);
    }

    public LiveData<String> getText() {
        return mText;
    }

    public LiveData<List<Tile>> getList() {
        return mList;
    }
}