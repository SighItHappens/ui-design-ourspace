package com.project.ourspace.ui.music;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.project.ourspace.R;

import java.util.ArrayList;
import java.util.List;

public class CreatePlaylist extends AppCompatActivity implements CreateMusicDialog.CreateMusicDialogListener {
    private TextView songName;
    private TextView artistName;
    private TextView url;
    private Button submit;
    List<Song> songList;
    RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.create_playlist);

        recyclerView = (RecyclerView) findViewById(R.id.new_songs_list);
        recyclerView.setHasFixedSize(false);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        submit = (Button) findViewById(R.id.create_single_song);

        songList = new ArrayList<>();
        songList.add(new Song("Hello, Goodbye", "The Beatles", null));
        songList.add(new Song("The Pretender", "The Foo Fighters", null));

        SongAdapter adapter = new SongAdapter(this, songList);
        recyclerView.setAdapter(adapter);

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view){
                openDialog();
            }
        });
    }


    public void openDialog() {
        CreateMusicDialog createMusicDialog = new CreateMusicDialog();
        createMusicDialog.show(getSupportFragmentManager(), "Create Music");
    }

    public void applyTexts(String songname, String artistname, String songurl) {
        songList.add(new Song(songname, artistname, songurl));

    }

    public void cancelTexts() {
        finish();
    }
}
