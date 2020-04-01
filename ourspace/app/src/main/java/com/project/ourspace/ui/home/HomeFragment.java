package com.project.ourspace.ui.home;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.project.ourspace.R;

import java.util.ArrayList;
import java.util.List;

public class HomeFragment extends Fragment {

    RecyclerView recyclerView;
    List<Tile> tileList;


    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {


        HomeViewModel homeViewModel = ViewModelProviders.of(this).get(HomeViewModel.class);
        View root = inflater.inflate(R.layout.fragment_home, container, false);

        recyclerView = (RecyclerView) root.findViewById(R.id.recycler_view);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));

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

        //creating recyclerview adapter
        TileAdapter adapter = new TileAdapter(getActivity(), tileList);

        //setting adapter to recyclerview
        recyclerView.setAdapter(adapter);
        return root;
    }
}
