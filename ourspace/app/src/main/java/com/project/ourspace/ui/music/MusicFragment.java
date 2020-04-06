package com.project.ourspace.ui.music;

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
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.project.ourspace.R;

public class MusicFragment extends Fragment {
    private RecyclerView recyclerView;
    private MusicViewModel musicViewModel;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        musicViewModel =
                ViewModelProviders.of(this).get(MusicViewModel.class);
        View root = inflater.inflate(R.layout.fragment_music, container, false);
        recyclerView = root.findViewById(R.id.recycler_music);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));

        MusicViewModel.Song[] songs = {new MusicViewModel.Song("Hello Goodbye", "https://www.youtube.com/watch?v=rblYSKz_VnI"),
                new MusicViewModel.Song("Twist and Shout", "https://www.youtube.com/watch?v=2RicaUqd9Hg"),
                new MusicViewModel.Song("Hey Jude", "https://www.youtube.com/watch?v=A_MjCqQoLLA")
        };

        MusicAdapter musicAdapter = new MusicAdapter(songs);
        recyclerView.setAdapter(musicAdapter);
        recyclerView.setItemAnimator(new DefaultItemAnimator());

        final TextView textView = root.findViewById(R.id.text_music);
        musicViewModel.getTitle().observe(getViewLifecycleOwner(), new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                textView.setText(s);
            }
        });
        return root;
    }
}
