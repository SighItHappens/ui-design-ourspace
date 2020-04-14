package com.project.ourspace;

import androidx.appcompat.app.AppCompatActivity;

import android.app.SearchManager;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.SearchView;
import android.widget.Space;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputLayout;

public class CreateTelevisionActivity extends AppCompatActivity {

    private static final String TAG = "CreateTVActivity";

    AutoCompleteTextView autocomplete;
    ImageView imageView;
    Button searchButton, addButton;

    String[] arr = {"Breaking Bad", "Friends", "Planet Earth"};
    String finalSelection = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        init();

        searchButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String selectedShow = autocomplete.getText().toString();
                Log.d(TAG, "Selected TV Show: " + selectedShow);

                if (selectedShow == null || selectedShow.trim().isEmpty()) {
                    addButton.setVisibility(View.GONE);
                    imageView.setVisibility(View.GONE);

                    String errorText = getString(R.string.tv_search_input_error);
                    Toast.makeText(getApplicationContext(), errorText, Toast.LENGTH_LONG).show();
                    return;
                }

                if (arr[0].equals(selectedShow)) {
                    finalSelection = arr[0];
                    addButton.setVisibility(View.VISIBLE);
                    imageView.setVisibility(View.VISIBLE);
                    imageView.setImageResource(getResources().getIdentifier("@drawable/breakingbad", null, getPackageName()));
                } else if (arr[1].equals(selectedShow)) {
                    finalSelection = arr[1];
                    addButton.setVisibility(View.VISIBLE);
                    imageView.setVisibility(View.VISIBLE);
                    imageView.setImageResource(getResources().getIdentifier("@drawable/friends", null, getPackageName()));
                } else if (arr[2].equals(selectedShow)) {
                    finalSelection = arr[2];
                    addButton.setVisibility(View.VISIBLE);
                    imageView.setVisibility(View.VISIBLE);
                    imageView.setImageResource(getResources().getIdentifier("@drawable/planetearth", null, getPackageName()));
                }
            }
        });

        addButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.d(TAG, "Confirming selection: " + finalSelection);
                if (arr[0].equals(finalSelection)) {
                    // Breaking Bad
                    // return seasons = 5, episodes = 13
                    // create TV show instance on Family Wall & return to home page
                } else if (arr[1].equals(finalSelection)) {
                    // Friends
                    // return seasons = 10, episodes = 24
                    // create TV show instance on Family Wall & return to home page
                } else if (arr[2].equals(finalSelection)) {
                    // Planet Earth
                    // return seasons = 1, episodes = 11
                    // create TV show instance on Family Wall & return to home page
                }
            }
        });
    }

    public void init() {
        setContentView(R.layout.activity_create_television);
        autocomplete = findViewById(R.id.autoCompleteTextView1);

        autocomplete.setThreshold(1);
        autocomplete.setAdapter(new ArrayAdapter<String>
                (this, android.R.layout.select_dialog_item, arr));

        imageView = findViewById(R.id.tvShowImage);
        imageView.setVisibility(View.GONE);
        addButton = findViewById(R.id.button3);
        addButton.setVisibility(View.GONE);
        searchButton = findViewById(R.id.searchTvShow);
    }
}

