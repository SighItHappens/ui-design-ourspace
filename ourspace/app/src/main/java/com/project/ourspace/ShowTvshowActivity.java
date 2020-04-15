package com.project.ourspace;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.ConstraintSet;

import android.content.Intent;
import android.graphics.Point;
import android.os.Bundle;
import android.util.TypedValue;
import android.view.Display;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.LinearLayout;
import android.widget.Space;
import android.widget.TextView;

import java.lang.reflect.Array;

public class ShowTvshowActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_tvshow);
        final float scale = getResources().getDisplayMetrics().density;
        final float text_size = 18;

        Intent intent = getIntent();
        int number_of_season = intent.getIntExtra("number_of_season", 3);
        int number_of_member = intent.getIntExtra("number_of_member", 2);
        int number_of_episode = intent.getIntExtra("number_of_episode", 10);
        String title = intent.getStringExtra("show_title");
        double temp_progresses[] = intent.getDoubleArrayExtra("show_progresses");
        String members[] = new String[number_of_member];
        for (int q=0; q<number_of_member; q++) {
            members[q] = "None";
        }

        Display display = getWindowManager(). getDefaultDisplay();
        Point size = new Point();
        display. getSize(size);
        final int screen_width = size.x;
        final int screen_height = size.y;

        ActionBar actionbar = this.getSupportActionBar();
        assert actionbar != null;
        if (title == null) { title = "Name of TV show"; }
        actionbar.setTitle(title);

        members[0] = "Me"; members[1] = "Sister";

        //progresses[users][seasons]
        double progresses[][] = new double[2][number_of_season];
        for (int i=0; i<number_of_member; i++) {
            for (int j=0; j<number_of_season; j++) {
                progresses[i][j] = 0;
            }
        }
        if(temp_progresses == null) {
            progresses[0][0] = 1; progresses[0][1] = 0.75; progresses[0][2] = 0;
            progresses[1][0] = 1; progresses[1][1] = 1; progresses[1][2] = 0.5;
        } else {
            for (int i=0; i<temp_progresses.length; i++) {
                int x = i / number_of_season;
                int y = i % number_of_season;
                progresses[x][y] = temp_progresses[i];
            }
        }

        /* Status chart part: */
        ConstraintLayout constraint = findViewById(R.id.graph_layout);
        final int con_width = (int)(screen_width * 0.8);
        final int con_height = (int)(screen_height * 0.05);
        for (int i=0; i<number_of_member; i++) {
            double progress_sum = 0;
            for (int j=0; j<number_of_season; j++) {
                progress_sum += progresses[i][j];
            }
            double progress = progress_sum / (double)number_of_season ;
            TextView circle = new TextView(this);
            circle.setId(View.generateViewId());
            circle.setTextColor(0xFF000000);
            circle.setText("\u25cf");
            circle.setTextSize(22);
            circle.setLayoutParams(new ConstraintLayout.LayoutParams(
                    LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT
            ));
            constraint.addView(circle);

            TextView name = new TextView(this);
            name.setId(View.generateViewId());
            name.setGravity(Gravity.CENTER);
            name.setTextColor(0xFF000000);
            name.setText(members[i]);
            name.setTextSize(14);
            name.setLayoutParams(new ConstraintLayout.LayoutParams(
                    LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT
            ));
            constraint.addView(name);

            ConstraintSet set = new ConstraintSet();
            set.clone(constraint);
            set.connect(circle.getId(), ConstraintSet.LEFT, ConstraintSet.PARENT_ID, ConstraintSet.LEFT,(int)(progress*con_width));
            set.connect(name.getId(), ConstraintSet.LEFT, ConstraintSet.PARENT_ID, ConstraintSet.LEFT,(int)(0.98*progress*con_width));
            set.connect(name.getId(), ConstraintSet.TOP, ConstraintSet.PARENT_ID, ConstraintSet.TOP,(int)(0.6*con_height));
            set.applyTo(constraint);
        }

        final Intent test = new Intent(this, ChangeTvshowProgressActivity.class);
        double temp_pro[] = new double[number_of_member*number_of_season];
        int count = 0;
        for (int i=0; i<number_of_member; i++) {
            for (int j=0; j<number_of_season; j++) {
                temp_pro[count] = progresses[i][j];
                count++;
            }
        }
        test.putExtra("show_progresses", temp_pro);
//        test.putExtra("selected_season", 2);
//        cardView.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                startActivity(test);
//            }
//        });


        /* Season status part: */
        LinearLayout vertical = findViewById(R.id.vertical_layout);
        // Setting header
        Space space = findViewById(R.id.space);
        space.setLayoutParams(new LinearLayout.LayoutParams(
                (int)(75*scale), LayoutParams.WRAP_CONTENT, 1
        ));
        LinearLayout horizon = findViewById(R.id.horizon_layout);
        for (int j=0; j<number_of_season; j++) {
            TextView text = new TextView(this);
            text.setTextSize(text_size);
            text.setTextColor(0xFF000000);
            text.setGravity(Gravity.CENTER);
            text.setLayoutParams(new LinearLayout.LayoutParams(
                    LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT, 1
            ));
            text.setText(Integer.toString(j+1));
            final int selected_season = j+1;
            text.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    test.putExtra("selected_season", selected_season);
                    startActivity(test);
                }
            });
            horizon.addView(text);
        }
        // Setting list of progresses
        for (int i=0; i<number_of_member; i++) {
            LinearLayout hori = new LinearLayout(this);
            hori.setOrientation(LinearLayout.HORIZONTAL);
            LinearLayout.LayoutParams hori_lay = new LinearLayout.LayoutParams(
                    LayoutParams.MATCH_PARENT, LayoutParams.WRAP_CONTENT, 1
            );
            hori_lay.setMargins(0, (int)(30*scale),0,0 );
            hori.setLayoutParams(hori_lay);
            vertical.addView(hori);
            TextView name = new TextView(this);
            name.setTextSize(text_size);
            name.setTextColor(0xFF000000);
            name.setGravity(Gravity.CENTER);
            name.setLayoutParams(new LinearLayout.LayoutParams(
                    (int)(75*scale), LayoutParams.WRAP_CONTENT, 1
            ));
            name.setText(members[i]);
            hori.addView(name);
            for (int j=0; j<number_of_season; j++) {
                TextView progress = new TextView(this);
                progress.setTextSize(text_size+4);
                progress.setGravity(Gravity.CENTER);
                progress.setLayoutParams(new LinearLayout.LayoutParams(
                        LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT, 1
                ));
                int color = 0xFF808080;
                if (progresses[i][j] == 1) {
                    color = 0xFF008000;
                } else if (progresses[i][j] > 0) {
                    color = 0xFFECCD00;
                }
                progress.setTextColor(color);
                progress.setText("\u25cf");
                final int selected_season = j+1;
                progress.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        test.putExtra("selected_season", selected_season);
                        startActivity(test);
                    }
                });
                hori.addView(progress);
            }
        }

    }
}
