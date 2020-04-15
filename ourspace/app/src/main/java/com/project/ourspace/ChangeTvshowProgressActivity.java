package com.project.ourspace;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.Arrays;

public class ChangeTvshowProgressActivity extends AppCompatActivity {
    float scale;
    final float text_size = 18;

    // Intent values
    int number_of_member;
    int number_of_season;
    int number_of_episode;
    int selected_season;
    double temp_progresses[];

    int checkBoxIDs_Me[];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_change_tvshow_progress);
        scale = getResources().getDisplayMetrics().density;

        Intent intent = getIntent();
        number_of_member = intent.getIntExtra("number_of_member", 2);
        number_of_season = intent.getIntExtra("number_of_season", 3);
        number_of_episode = intent.getIntExtra("number_of_episode", 10);
        selected_season = intent.getIntExtra("selected_season", 1);
        String title = intent.getStringExtra("show_title");
        temp_progresses = intent.getDoubleArrayExtra("show_progresses");

        checkBoxIDs_Me = new int[number_of_episode];

        double progresses[][] = new double[number_of_member][number_of_season];
        for (int i=0; i<number_of_member; i++) {
            for (int j=0; j<number_of_season; j++) {
                progresses[i][j] = 0;
            }
        }
        if (temp_progresses != null) {
            for (int i=0; i<temp_progresses.length; i++) {
                int x = i / number_of_season;
                int y = i % number_of_season;
                progresses[x][y] = temp_progresses[i];
            }
        }
        String members[] = new String[number_of_member];
        for (int q=0; q<number_of_member; q++) {
            members[q] = "None";
        }
        members[0] = "Me"; members[1] = "Sister";
        int watched_episode[] = new int[number_of_member];
        for (int i=0; i<number_of_member; i++) {
            watched_episode[i] = (int)(progresses[i][selected_season-1] * number_of_episode);
        }

        final Button addChanges = findViewById(R.id.addChanges);
        View.OnClickListener listen = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addChanges.setVisibility(View.VISIBLE);
            }
        };

        /* ActionBar Part: */
        ActionBar actionBar = getSupportActionBar();
        assert actionBar != null;
        if (title == null) { title = "Name of TV show"; }
        actionBar.setTitle(title);

        /* TextView Part: */
        TextView seasonTitle = findViewById(R.id.season_title);
        String t = "Season " + selected_season;
        seasonTitle.setText(t);

        LinearLayout non_scro = findViewById(R.id.non_scroll_linear);
        LinearLayout horizon = new LinearLayout(this);
        horizon.setOrientation(LinearLayout.HORIZONTAL);
        TextView space = new TextView(this);
        space.setLayoutParams(new LinearLayout.LayoutParams(
                (int)(100*scale), LayoutParams.WRAP_CONTENT, 1
        ));
        space.setText("  ");
        horizon.addView(space);
        for (int i=0; i<number_of_member; i++) {
            TextView name = new TextView(this);
            name.setTextSize(text_size);
            name.setTextColor(0xFF000000);
            name.setLayoutParams(new LinearLayout.LayoutParams(
                    (int)(80*scale), LayoutParams.WRAP_CONTENT, 1
            ));
            name.setText(members[i]);
            horizon.addView(name);
        }
        non_scro.addView(horizon);

        /* Scroll Linear Part: */
        LinearLayout scroll = findViewById(R.id.scroll_linear);
        for (int k=0; k<number_of_episode; k++) {
            LinearLayout hori = new LinearLayout(this);
            hori.setOrientation(LinearLayout.HORIZONTAL);
            LinearLayout.LayoutParams hori_lay = new LinearLayout.LayoutParams(
                    LayoutParams.MATCH_PARENT, LayoutParams.WRAP_CONTENT, 1
            );
            hori_lay.setMargins(0, (int)(30*scale),0,0 );
            hori.setLayoutParams(hori_lay);
            scroll.addView(hori);

            TextView epi = new TextView(this);
            epi.setTextSize(text_size);
            epi.setTextColor(0xFF000000);
            epi.setGravity(Gravity.CENTER);
            epi.setLayoutParams(new LinearLayout.LayoutParams(
                    (int)(100*scale), LayoutParams.WRAP_CONTENT, 1
            ));
            String str = "Ep. " + (k+1);
            epi.setText(str);
            hori.addView(epi);
            for (int i=0; i<number_of_member; i++) {
                CheckBox checkBox = new CheckBox(this);
                checkBox.setLayoutParams(new LinearLayout.LayoutParams(
                        (int)(80*scale), LayoutParams.WRAP_CONTENT, 1
                ));
                checkBox.setText("");
                System.out.println(watched_episode[i]);
                if ((k+1) <= watched_episode[i]) {
                    checkBox.setChecked(true);
                }
                if (i != 0) {
                    checkBox.setEnabled(false);
                } else {
                    checkBox.setOnClickListener(listen);
                    checkBox.setId(View.generateViewId());
                    checkBoxIDs_Me[k] = checkBox.getId();
                }
                hori.addView(checkBox);
            }
        }
    }
    public void clickButton (View view) {
        Intent intent2 = new Intent(this, ShowTvshowActivity.class);
        int count = 0;
        for (int k=0; k<number_of_episode; k++) {
            CheckBox c = findViewById(checkBoxIDs_Me[k]);
            if(c.isChecked()) {
                count++;
            }
        }
        double new_progress = (double)count / (double)number_of_episode;
        temp_progresses[selected_season-1] = new_progress;
        intent2.putExtra("show_progresses", temp_progresses);
        startActivity(intent2);
    }
}
