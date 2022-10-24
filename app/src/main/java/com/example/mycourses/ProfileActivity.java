package com.example.mycourses;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

public class ProfileActivity extends AppCompatActivity {

    Button logout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        logout = (Button) findViewById(R.id.signOut);
        logout.setOnClickListener(e->{
                startActivity(new Intent(ProfileActivity.this, LoginActivity.class));
                finish();
            });
    }
}