package com.example.mycourses;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.example.mycourses.DAO.UserDAO;
import com.example.mycourses.Database.AppDataBase;
import com.example.mycourses.Entity.User;

public class SignUpActivity extends AppCompatActivity {

    TextView txtSignIn;
    EditText firstname, lastname ,email, pwd;
    Button signUp;
    RadioGroup radioGroup;
    RadioButton radioButton;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        firstname = findViewById(R.id.edtSignUpFirstName);
        lastname = findViewById(R.id.edtSignUpLastName);
        email = findViewById(R.id.edtSignUpEmail);
        pwd = findViewById(R.id.edtSignUpPassword);
        signUp = findViewById(R.id.btnSignUp);
        radioGroup = findViewById(R.id.radio_group);
        radioButton =findViewById(radioGroup.getCheckedRadioButtonId());


        signUp.setOnClickListener(e->{
            String firstNameText =firstname.getText().toString();
            String lastNameText = lastname.getText().toString();
            String loginText = email.getText().toString();
            String pwdText = pwd.getText().toString();
            String typeText = radioButton.getText().toString();


            if (firstNameText.isEmpty() || lastNameText.isEmpty()
                    || loginText.isEmpty() || pwdText.isEmpty()){
                Toast.makeText(getApplicationContext(),"Fill all fields", Toast.LENGTH_LONG).show();

            }
            else {
                AppDataBase database = AppDataBase.getAppDatabase(getApplicationContext());
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        User user = database.userDao().UserByLoginAndPWD(loginText, pwdText);
                        if(user != null){
                            runOnUiThread(new Runnable() {
                                @Override
                                public void run() {
                                    Toast.makeText(getApplicationContext(), "User exist",
                                            Toast.LENGTH_LONG).show();
                                }
                            });
                        }
                        else{
                            runOnUiThread(new Runnable() {
                                @Override
                                public void run() {
                                    User u = new User();
                                    u.setLogin(loginText);
                                    u.setPwd(pwdText);
                                    u.setFirstName(firstNameText);
                                    u.setLastName(lastNameText);
                                    u.setType(typeText);

                                    database.userDao().insertOne(u);
                                    Toast.makeText(getApplicationContext(), "User Registered",
                                            Toast.LENGTH_LONG).show();

                                    startActivity(new Intent(SignUpActivity.this, LoginActivity.class));
                                    finish();
                                }
                            });
                        }
                    }
                }).start();
            }
        });

        txtSignIn = findViewById(R.id.txtSignIn);
        txtSignIn.setOnClickListener(e-> { startActivity(new Intent(SignUpActivity.this,
                LoginActivity.class));
            finish();
        });
    }

    public void checkButton(View view) {
        radioButton =findViewById(radioGroup.getCheckedRadioButtonId());

    }
}