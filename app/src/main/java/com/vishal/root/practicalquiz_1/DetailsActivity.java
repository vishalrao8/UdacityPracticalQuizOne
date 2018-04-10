package com.vishal.root.practicalquiz_1;

import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.widget.TextView;

public class DetailsActivity extends AppCompatActivity {

    private TextView userName;
    private TextView email;
    private TextView description;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);

        Toolbar toolBar = findViewById(R.id.toolbar);
        setSupportActionBar(toolBar);

        userName = findViewById(R.id.userNameTextView);
        email = findViewById(R.id.emailTextView);
        description = findViewById(R.id.descriptionTextView);

        SharedPreferences sharedPreferences = this.getSharedPreferences(MainActivity.SHARED_PREFERENCES, MODE_PRIVATE);
        userName.setText(sharedPreferences.getString(MainActivity.USERNAME,"Default"));
        email.setText(sharedPreferences.getString(MainActivity.EMAIL, "default"));
        description.setText(sharedPreferences.getString(MainActivity.DESCRIPTION, "default"));


        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }
}
