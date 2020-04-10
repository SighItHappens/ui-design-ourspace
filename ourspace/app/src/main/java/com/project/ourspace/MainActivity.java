package com.project.ourspace;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.content.res.ResourcesCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import com.google.android.material.navigation.NavigationView;
import com.leinardi.android.speeddial.SpeedDialActionItem;
import com.leinardi.android.speeddial.SpeedDialOverlayLayout;
import com.leinardi.android.speeddial.SpeedDialView;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";

    private AppBarConfiguration mAppBarConfiguration;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        initSpeedDial();

        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        NavigationView navigationView = findViewById(R.id.nav_view);
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        mAppBarConfiguration = new AppBarConfiguration.Builder(
                R.id.nav_home, R.id.nav_gallery, R.id.nav_slideshow)
                .setDrawerLayout(drawer)
                .build();
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment);
        NavigationUI.setupActionBarWithNavController(this, navController, mAppBarConfiguration);
        NavigationUI.setupWithNavController(navigationView, navController);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onSupportNavigateUp() {
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment);
        return NavigationUI.navigateUp(navController, mAppBarConfiguration)
                || super.onSupportNavigateUp();
    }

    private void initSpeedDial() {
        SpeedDialView speedDialView = findViewById(R.id.speedDial);
        SpeedDialOverlayLayout overlay = findViewById(R.id.speedDialOverlay);
        speedDialView.setOverlayLayout(overlay);

        createSpeedDialItem(speedDialView, R.id.fab_add_tv_show, R.drawable.ic_videocam_black_24dp, R.string.add_tv_show, R.color.primaryDarkColor, R.color.material_white_1000);
        createSpeedDialItem(speedDialView, R.id.fab_add_music, R.drawable.ic_music_note_white_24dp, R.string.add_music, R.color.primaryDarkColor, R.color.material_white_1000);
        createSpeedDialItem(speedDialView, R.id.fab_new_note, R.drawable.ic_note_white_24dp, R.string.add_note, R.color.primaryDarkColor, R.color.material_white_1000);

        final Toast toast = Toast.makeText(getApplicationContext(), "Replace with your own TV action", Toast.LENGTH_SHORT);
        final Intent createNoteIntent = new Intent(this, CreateNoteActivity.class);

        speedDialView.setOnActionSelectedListener(new SpeedDialView.OnActionSelectedListener() {
            @Override
            public boolean onActionSelected(SpeedDialActionItem speedDialActionItem) {
                switch (speedDialActionItem.getId()) {
                    case R.id.fab_add_tv_show:
                        toast.setText("Custom TV action");
                        toast.show();
                        return false;
                    case R.id.fab_add_music:
                        toast.setText("Custom Music action");
                        toast.show();
                        return false;
                    case R.id.fab_new_note:
                        startActivity(createNoteIntent);
                        return false;
                    default:
                        return false;
                }
            }
        });
        Log.d(TAG, "Speed Dial Initiation complete");
    }

    private void createSpeedDialItem(SpeedDialView speedDialView, int id, int icon, int label, int background, int foreground) {
        speedDialView.addActionItem(
                new SpeedDialActionItem.Builder(id, icon)
                        .setLabel(label)
                        .setFabBackgroundColor(ResourcesCompat.getColor(getResources(), background, getTheme()))
                        .setFabImageTintColor(ResourcesCompat.getColor(getResources(), foreground, getTheme()))
                        .create()
        );
    }
}
