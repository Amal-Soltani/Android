package com.example.mycourses;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class StudentHomeActivity extends AppCompatActivity {

    TextView name,lastname,type;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student_home);

        name = findViewById(R.id.studentFirstName);
        lastname = findViewById(R.id.studentLastName);
        type = findViewById(R.id.studentType);
        name.setText(getIntent().getStringExtra("firstName"));
        lastname.setText(getIntent().getStringExtra("lastName"));
        type.setText(getIntent().getStringExtra("type"));
    }
}