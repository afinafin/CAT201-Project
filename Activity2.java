package com.example.cat201try2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Activity2 extends AppCompatActivity {

    Button buttonLoseWeight, buttonGainWeight;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_2);
        setTitle("Calories - MAINTAIN");

        SharedPreferences sp = getApplicationContext().getSharedPreferences("UserPrefs", MODE_PRIVATE);

        TextView calories = findViewById(R.id.CaloriesMaintain);
        calories.setText(sp.getString("MAINTAIN","")+" calories");

        buttonLoseWeight=findViewById(R.id.buttonLoseWeight);
        buttonLoseWeight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent1 = new Intent(Activity2.this, LoseWeight.class);
                startActivity(intent1);
            }
        });

        buttonGainWeight=findViewById(R.id.buttonGainWeight);
        buttonGainWeight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent2 = new Intent(Activity2.this, GainWeight.class);
                startActivity(intent2);
            }
        });
    }





}

