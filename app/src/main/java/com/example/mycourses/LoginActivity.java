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

public class LoginActivity extends AppCompatActivity {

    EditText email, pwd;
    TextView txtSignUp;
    Button signIn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        email = findViewById(R.id.edtSignInEmail);
        pwd = findViewById(R.id.edtSignInPassword);
        signIn = (Button) findViewById(R.id.btnSignIn);

        signIn.setOnClickListener(e->{
            String loginText =(email.getText().toString());
            String pwdText = (pwd.getText().toString());

            if (loginText.isEmpty() || pwdText.isEmpty()){
                Toast.makeText(getApplicationContext(),"Fill all fields", Toast.LENGTH_LONG).show();
            }
            else {
                AppDataBase database = AppDataBase.getAppDatabase(getApplicationContext());
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        User user = database.userDao().UserByLoginAndPWD(loginText, pwdText);
                        if (user == null) {
                            runOnUiThread(new Runnable() {
                                @Override
                                public void run() {
                                    Toast.makeText(getApplicationContext(), "Invalid Credentials",
                                            Toast.LENGTH_LONG).show();
                                }
                            });
                        }
                        else{
                            String s = "Student";
                            String firstName = user.getFirstName();
                            String lastName = user.getLastName();
                           if (s.equals(user.getType()))
                            {
                                startActivity(new Intent(LoginActivity.this, StudentHomeActivity.class)
                                        .putExtra("firstName",firstName)
                                        .putExtra("lastName",lastName)
                                        .putExtra("type",user.getType()));
                           }else{
                                startActivity(new Intent(LoginActivity.this, ProfessorActivity.class)
                                        .putExtra("firstName",firstName)
                                        .putExtra("lastName",lastName));
                            }
                            finish();

                        }
                    }
                }).start();
            }
        });

        txtSignUp = findViewById(R.id.txtSignUp);
        txtSignUp.setOnClickListener(e-> {
                Intent intent = new Intent(LoginActivity.this, SignUpActivity.class);
                startActivity(intent);
                finish();
        });
    }


}