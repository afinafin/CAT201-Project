package com.example.cat201try2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.TextView;

public class MaintainWeight extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maintain_weight);
        setTitle("Maintain Weight");

        SharedPreferences sp = getApplicationContext().getSharedPreferences("UserPrefs", MODE_PRIVATE);

        TextView calories = findViewById(R.id.CaloriesMaintain);
        calories.setText(sp.getInt("MAINTAIN",0)+" calories");

    }
}
