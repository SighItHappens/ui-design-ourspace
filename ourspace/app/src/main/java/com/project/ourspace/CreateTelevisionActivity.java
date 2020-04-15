package com.project.ourspace;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import java.text.SimpleDateFormat;
import java.util.Date;
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
import com.project.ourspace.data.model.TileList;
import com.project.ourspace.ui.home.Tile;

public class CreateTelevisionActivity extends AppCompatActivity {

    private static final String TAG = "CreateTVActivity";

    AutoCompleteTextView autocomplete;
    ImageView imageView;
    Button searchButton, addButton;
    double[][] showProgress;

    String[] arr = {"Breaking Bad", "Friends", "Planet Earth"};
    String finalSelection = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActionBar actionBar = this.getSupportActionBar();
        actionBar.setTitle("OurSpace - Add New TV Show");

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
                SimpleDateFormat formatter = new SimpleDateFormat("MMM dd yyyy");
                Date date = new Date();
                if (arr[0].equals(finalSelection)) {
                    showProgress = new double[2][5];

                    TileList.addItem(
                        new Tile(3, "Jane", formatter.format(date),
                                  arr[0], 5,13,showProgress,"@drawable/breakingbad"));

                    // Breaking Bad
                    // return seasons = 5, episodes = 13
                    // create TV show instance on Family Wall & return to home page
                    Intent homeScreenIntent = new Intent(getApplicationContext(), MainActivity.class);
                    startActivity(homeScreenIntent);
                } else if (arr[1].equals(finalSelection)) {
                    // Friends
                    showProgress = new double[2][10];
                    // return seasons = 10, episodes = 24
                    TileList.addItem(
                            new Tile(3, "Jane", formatter.format(date),
                                    arr[1], 10,24,showProgress, "@drawable/friends"));
                    // create TV show instance on Family Wall & return to home page
                    Intent homeScreenIntent = new Intent(getApplicationContext(), MainActivity.class);
                    startActivity(homeScreenIntent);
                } else if (arr[2].equals(finalSelection)) {

                    // Planet Earth
                    // return seasons = 1, episodes = 11
                    showProgress = new double[2][1];

                    TileList.addItem(
                            new Tile(3, "Jane", formatter.format(date),
                                    arr[2], 4,11,showProgress,"@drawable/planetearth"));
                    // create TV show instance on Family Wall & return to home page
                    Intent homeScreenIntent = new Intent(getApplicationContext(), MainActivity.class);
                    startActivity(homeScreenIntent);
                }
            }
        });
    }

    public void init() {
        setContentView(R.layout.activity_create_television);

        ActionBar actionBar = this.getSupportActionBar();
        actionBar.setTitle("OurSpace - Add New TV Show");

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

