package com.project.ourspace;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProviders;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;
import com.project.ourspace.data.LoginDataSource;
import com.project.ourspace.data.LoginRepository;
import com.project.ourspace.data.model.LoggedInUser;
import com.project.ourspace.ui.login.LoginViewModel;
import com.project.ourspace.ui.login.LoginViewModelFactory;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

public class CreateNoteActivity extends AppCompatActivity {

    private static final String TAG = "CreateNoteActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_note);

        SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm");
        Date today = Calendar.getInstance().getTime();

        TextView statusText = findViewById(R.id.createNoteStatusText);
        statusText.setText("Last saved at " + dateFormat.format(today));
    }

    public void createNote(View view) {
        Intent homeScreenIntent = new Intent(this, MainActivity.class);

        EditText noteContent = findViewById(R.id.createNoteContentText);
        String contentString = noteContent.getText().toString();

        TextInputLayout noteTitle = findViewById(R.id.createNoteTitleText);
        String titleString = noteTitle.getEditText().getText().toString();

        LoggedInUser userDetails = LoginRepository.getInstance().getUserDetails();

        Log.d(TAG, "Retrieved Note Owner: " + userDetails.getDisplayName());
        Log.d(TAG, "Retrieved Title Text: " + titleString);
        Log.d(TAG, "Retrieved Content Text: " + contentString);

        startActivity(homeScreenIntent);
    }
}
