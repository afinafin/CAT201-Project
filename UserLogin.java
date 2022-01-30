package com.example.cat201try2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class UserLogin extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_login);

            EditText LoginName, LoginPassword;
            Button login;

            LoginName = findViewById(R.id.UserNameLogin);
            LoginPassword = findViewById(R.id.UserPasswordLogin);
            login = findViewById(R.id.buttonLogin);

            login.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    //correct password, Username:Admin , Password:1234
                    if (LoginName.getText().toString().equals("Admin") && LoginPassword.getText().toString().equals("1234")) {

                        Toast.makeText(UserLogin.this, "Login Successful!", Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(UserLogin.this, WeightOption.class);
                        Intent intent2 = new Intent(UserLogin.this, MainCalorieDisplay.class);
                        SharedPreferences sp = getApplicationContext().getSharedPreferences("UserPrefs", MODE_PRIVATE);
                        int trigger = sp.getInt("WEIGHTTRIGGER",0);

                        if (trigger == 1 || trigger == 2 || trigger == 3)
                            startActivity(intent2);
                        else
                            startActivity(intent);

                    } else {
                        //incorrect password
                        Toast.makeText(UserLogin.this, "Login Failed!", Toast.LENGTH_SHORT).show();
                    }
                }
            });
        }
}



