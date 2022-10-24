package com.example.mycourses;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.mycourses.Database.AppDataBase;
import com.example.mycourses.Entity.User;

public class SignUpActivity extends AppCompatActivity {

    TextView txtSignIn;
    EditText name, email, pwd, confirmPWD;
    Button signUp;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        name = findViewById(R.id.edtSignUpFullName);
        email = findViewById(R.id.edtSignUpEmail);
        pwd = findViewById(R.id.edtSignUpPassword);
        confirmPWD = findViewById(R.id.edtSignUpConfirmPassword);
        signUp = findViewById(R.id.btnSignUp);

        signUp.setOnClickListener(e->{
            User user = new User();
            user.setFullName(name.getText().toString());
            user.setLogin(email.getText().toString());
            if (validateInput(user)){
                if (pwd.getText().toString().equals(confirmPWD.getText().toString())){
                    user.setPwd(pwd.getText().toString());
                    AppDataBase database = AppDataBase.getAppDatabase(getApplicationContext());
                    database.userDao().insertOne(user);
                    Toast.makeText(this, "User Registered", Toast.LENGTH_LONG).show();
                }else{
                    Toast.makeText(getApplicationContext(),"Error Password", Toast.LENGTH_LONG).show();
                }
            }else{
                Toast.makeText(getApplicationContext(),"Fill all fields", Toast.LENGTH_LONG).show();
            }
        });

        txtSignIn = findViewById(R.id.txtSignIn);
        txtSignIn.setOnClickListener(e-> { startActivity(new Intent(SignUpActivity.this, LoginActivity.class));
            finish();
        });
    }

    private Boolean validateInput (User user){
        return !user.getFullName().isEmpty() && !user.getLogin().isEmpty()
                && !user.getPwd().isEmpty();
    }
}