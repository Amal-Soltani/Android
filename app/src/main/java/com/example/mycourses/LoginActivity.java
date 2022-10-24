package com.example.mycourses;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

public class LoginActivity extends AppCompatActivity {

    TextView txtSignUp;
    Button signIn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        txtSignUp = findViewById(R.id.txtSignUp);
        txtSignUp.setOnClickListener(e-> {
                Intent intent = new Intent(LoginActivity.this, SignUpActivity.class);
                startActivity(intent);
                finish();
        });

        signIn = (Button) findViewById(R.id.btnSignIn);
        signIn.setOnClickListener(e->{
                startActivity(new Intent(LoginActivity.this, ListActivity.class));

        });
    }
}