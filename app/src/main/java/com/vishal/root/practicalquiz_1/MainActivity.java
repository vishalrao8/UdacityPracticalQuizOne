package com.vishal.root.practicalquiz_1;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    private EditText username;
    private EditText email;
    private EditText description;

    private SharedPreferences sharedPreferences;

    public static final String USERNAME = "USERNAME";
    public static final String EMAIL = "EMAIL";
    public static final String DESCRIPTION = "DESCRIPTION";
    public static final String SHARED_PREFERENCES = "STORE_ROOM";

    private Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        sharedPreferences = this.getSharedPreferences(SHARED_PREFERENCES, MODE_PRIVATE);

        username = findViewById(R.id.usernameEditText);
        email = findViewById(R.id.emailEditText);
        description = findViewById(R.id.descriptionEditText);

        if(savedInstanceState != null){

            if(savedInstanceState.containsKey(USERNAME))
                username.setText(savedInstanceState.getString(USERNAME));
            if(savedInstanceState.containsKey(EMAIL))
                email.setText(savedInstanceState.getString(EMAIL));
            if(savedInstanceState.containsKey(DESCRIPTION))
                description.setText(savedInstanceState.getString(DESCRIPTION));

        }

        intent = new Intent(this, DetailsActivity.class);
    }

    public void NextClicked(View view){

        sharedPreferences.edit().putString(USERNAME, username.getText().toString()).apply();
        sharedPreferences.edit().putString(EMAIL, username.getText().toString()).apply();
        sharedPreferences.edit().putString(DESCRIPTION, description.getText().toString()).apply();

        username.setText("");
        email.setText("");
        description.setText("");

        startActivity(intent);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        getMenuInflater().inflate(R.menu.menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        if(item.getItemId() == R.id.profile){

            startActivity(intent);
            return true;

        }

        return false;

    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);

        outState.putString(USERNAME, username.getText().toString());
        outState.putString(EMAIL, email.getText().toString());
        outState.putString(DESCRIPTION, description.getText().toString());

    }
}
