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
    private List<Tile> tileList;

    public HomeViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("This is home fragment");
        mList = new MutableLiveData<>();

        tileList = new ArrayList<>();


        //adding some items to our list
        tileList.add(
                new Tile(
                        "Mommy","2 HOURS AGO","Dad","#sundayfunday #snowman",
                        2,R.drawable.snowman,R.drawable.snowman,R.drawable.snowman,R.drawable.snowman));


        tileList.add(
                new Tile(
                        "Mommy","2 HOURS AGO","Dad","#sundayfunday #snowman",
                        2,R.drawable.snowman,R.drawable.snowman,R.drawable.snowman,R.drawable.snowman));

        tileList.add(
                new Tile(
                        "Mommy","2 HOURS AGO","Dad","#sundayfunday #snowman",
                        2,R.drawable.snowman,R.drawable.snowman,R.drawable.snowman,R.drawable.snowman));
        mList.setValue(tileList);
    }

    public LiveData<String> getText() {
        return mText;
    }


    public LiveData<List<Tile>> getList() {
        return mList;
    }
}