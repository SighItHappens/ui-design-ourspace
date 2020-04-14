package com.project.ourspace.ui.music;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.textfield.TextInputLayout;
import com.project.ourspace.MainActivity;
import com.project.ourspace.R;
import com.project.ourspace.data.LoginRepository;
import com.project.ourspace.data.model.LoggedInUser;

import java.net.MalformedURLException;
import java.net.URL;

public class CreateSong extends AppCompatActivity {
    private static final String TAG = "CreateSongActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.create_song);
    }

    public void createSingleSong(View view) {
        Intent homeScreenIntent = new Intent(this, MainActivity.class);

        // Find each song content item
        EditText songName = findViewById(R.id.edit_single_songname);
        String songNameString = songName.getText().toString();
        EditText artistName = findViewById(R.id.edit_single_artistname);
        String artistNameString = artistName.getText().toString();
        EditText songUrl = findViewById(R.id.edit_single_songurl);
        String songUrlString;

        // Try to create a url from the string: If it's not valid, then don't include a link.
        try {
            URL formatted_songUrl = new URL(songUrl.getText().toString());
            songUrlString = String.format("<a href=%s>Link</a>", songUrl.getText().toString());
        } catch (MalformedURLException e) {
            songUrlString = null;
        }

        LoggedInUser userDetails = LoginRepository.getInstance().getUserDetails();

        Log.d(TAG, "Retrieved Note Owner: " + userDetails.getDisplayName());
        Log.d(TAG, "Retrieved Song Name: " + songNameString);
        Log.d(TAG, "Retrieved Artist Name: " + artistNameString);
        Log.d(TAG, "Retrieved Song URL: " + songUrlString);

        startActivity(homeScreenIntent);
    }
}
