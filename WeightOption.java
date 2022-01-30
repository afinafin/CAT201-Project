package com.example.cat201try2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class WeightOption extends AppCompatActivity {

    Button maintainWeight, gainWeight, loseWeight;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_weight_option);
        SharedPreferences sp = getApplicationContext().getSharedPreferences("UserPrefs", MODE_PRIVATE);
        SharedPreferences.Editor editor = sp.edit();

        maintainWeight=findViewById(R.id.buttonMaintainWeight);
        maintainWeight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                editor.putInt("WEIGHTTRIGGER",1);
                editor.commit();
                Intent intent = new Intent(WeightOption.this, MaintainWeight.class);
                startActivity(intent);
            }
        });

        loseWeight=findViewById(R.id.buttonLoseWeight);
        loseWeight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent2 = new Intent(WeightOption.this, LoseWeight.class);
                startActivity(intent2);

            }
        });

        gainWeight=findViewById(R.id.buttonGainWeight);
        gainWeight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent3 = new Intent(WeightOption.this, GainWeight.class);
                startActivity(intent3);
            }
        });

    }
}
