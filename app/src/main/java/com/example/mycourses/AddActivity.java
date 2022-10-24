package com.example.mycourses;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;

public class AddActivity extends AppCompatActivity {

    ImageView logout;
    Button back;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add);


        logout = (ImageView) findViewById(R.id.icSignOut2);
        logout.setOnClickListener(e->{
                startActivity(new Intent(getApplicationContext(), LoginActivity.class));
        });

        back = (Button) findViewById(R.id.btnback);
        back.setOnClickListener(e->{
                startActivity(new Intent(getApplicationContext(), ListActivity.class));
        });

    }
}