package com.project.ourspace.ui.music;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import com.google.android.material.textfield.TextInputLayout;
import com.project.ourspace.MainActivity;
import com.project.ourspace.R;
import com.project.ourspace.data.LoginRepository;
import com.project.ourspace.data.model.LoggedInUser;
import com.project.ourspace.data.model.TileList;
import com.project.ourspace.ui.home.HomeViewModel;
import com.project.ourspace.ui.home.Tile;

import java.net.MalformedURLException;
import java.net.URL;

public class CreateSong extends AppCompatActivity {
    private static final String TAG = "CreateSongActivity";

    HomeViewModel homeViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.create_song);
    }

    public void createSingleSong(View view) {
        Intent homeScreenIntent = new Intent(this, MainActivity.class);

        // Find each song content item
        TextInputLayout songName = findViewById(R.id.edit_single_songname);
        String songNameString = songName.getEditText().getText().toString();
        TextInputLayout artistName = findViewById(R.id.edit_single_artistname);
        String artistNameString = artistName.getEditText().getText().toString();
        TextInputLayout songUrl = findViewById(R.id.edit_single_songurl);
        String songUrlString;

        // Try to create a url from the string: If it's not valid, then don't include a link.
        try {
            URL formatted_songUrl = new URL(songUrl.getEditText().getText().toString());
            songUrlString = songUrl.getEditText().getText().toString();
        } catch (MalformedURLException e) {
            songUrlString = null;
        }

        LoggedInUser userDetails = LoginRepository.getInstance().getUserDetails();

        homeViewModel = new ViewModelProvider(this).get(HomeViewModel.class);
        TileList.addItem(new Tile(2, userDetails.getDisplayName(), "14 Apr 2020", songNameString, artistNameString, songUrlString));

        Log.d(TAG, "Retrieved Note Owner: " + userDetails.getDisplayName());
        Log.d(TAG, "Retrieved Song Name: " + songNameString);
        Log.d(TAG, "Retrieved Artist Name: " + artistNameString);
        Log.d(TAG, "Retrieved Song URL: " + songUrlString);

        Toast.makeText(getApplicationContext(), "Song created!", Toast.LENGTH_LONG).show();
        startActivity(homeScreenIntent);
    }
}