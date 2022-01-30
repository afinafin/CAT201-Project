package com.example.cat201try2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class WelcomePage extends AppCompatActivity {

    String firstStart = "yes";

    protected void onResume(){
        super.onResume();
        SharedPreferences sp = getSharedPreferences(getString(R.string.app_name), Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sp.edit();

        SharedPreferences sp2 = getSharedPreferences("UserPrefs", MODE_PRIVATE);
        SharedPreferences.Editor editor2 = sp2.edit();


        if (!sp.getBoolean(firstStart, false)){
            editor.putBoolean(firstStart, Boolean.TRUE);

            editor.apply();
        }
        else {
            editor2.putInt("INTAKE",0);
            editor2.commit();
            editor2.putInt("BURN",0);
            editor2.commit();

            Intent intent = new Intent(WelcomePage.this, UserLogin.class);
            startActivity(intent);

        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome_page);
        setTitle("Welcome");


        Button next = findViewById(R.id.buttonWelcome);
        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                Intent intent = new Intent(WelcomePage.this, MainActivity.class);
                startActivity(intent);
            }
        });

    }
}