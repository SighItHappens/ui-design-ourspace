package com.project.ourspace;

import androidx.appcompat.app.AppCompatActivity;

import android.app.SearchManager;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.SearchView;

public class CreateTelevisionActivity extends AppCompatActivity {

    AutoCompleteTextView autocomplete;
    Button searchButton;
    Button addButton;
    ImageView showImage0, showImage1, showImage2;
    String[] arr = {"Breaking Bad","Friends","Planet Earth"};
   // String[] arr = { "Paries,France", "PA,United States","Parana,Brazil",
   //         "Padua,Italy", "Pasadena,CA,United States"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_television);

        autocomplete = (AutoCompleteTextView)
                findViewById(R.id.autoCompleteTextView1);

        ArrayAdapter<String> adapter = new ArrayAdapter<String>
                (this,android.R.layout.select_dialog_item, arr);

        autocomplete.setThreshold(2);
        autocomplete.setAdapter(adapter);

        showImage0 = (ImageView) findViewById(R.id.imageView0);
        showImage1 = (ImageView) findViewById(R.id.imageView1);
        showImage2 = (ImageView) findViewById(R.id.imageView2);

        addButton = (Button) findViewById(R.id.button3);

        searchButton = (Button) findViewById(R.id.button2);
        searchButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
              String x = autocomplete.getText().toString();
              if(x.equals(arr[0])){
                  // Breaking Bad
                  addButton.setVisibility(View.VISIBLE);
                  showImage0.setVisibility(View.VISIBLE);
                  showImage1.setVisibility(View.GONE);
                  showImage2.setVisibility(View.GONE);
              } else if(x.equals(arr[1])){
                  // Friends
                  addButton.setVisibility(View.VISIBLE);
                  showImage0.setVisibility(View.GONE);
                  showImage1.setVisibility(View.VISIBLE);
                  showImage2.setVisibility(View.GONE);
              } else if(x.equals(arr[2])){
                  // Planet Earth
                  addButton.setVisibility(View.VISIBLE);
                  showImage0.setVisibility(View.GONE);
                  showImage1.setVisibility(View.GONE);
                  showImage2.setVisibility(View.VISIBLE);
              }
            }
        });

        addButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(showImage0.getVisibility()==View.VISIBLE){
                // Breaking Bad
                    // return seasons = 5, episodes = 13
                    // create TV show instance on Family Wall & return to home page
                }else if(showImage1.getVisibility()==View.VISIBLE){
                // Friends
                    // return seasons = 10, episodes = 24
                    // create TV show instance on Family Wall & return to home page
                }else if(showImage2.getVisibility()==View.VISIBLE){
                // Planet Earth
                    // return seasons = 1, episodes = 11
                    // create TV show instance on Family Wall & return to home page

                }
            }
        });

    }


        // Get the SearchView and set the searchable configuration
//        SearchManager searchManager = (SearchManager) getSystemService(Context.SEARCH_SERVICE);
//        SearchView searchView = (SearchView) findViewById(R.id.searchView);

        // Assumes current activity is the searchable activity
//        searchView.setSearchableInfo(searchManager.getSearchableInfo(getComponentName()));
//        searchView.setIconifiedByDefault(true); // Do not iconify the widget; expand it by default
//        searchView.setSubmitButtonEnabled(true);
//    return true;


    }

