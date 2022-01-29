package com.example.cat201try2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class GainWeightChoice extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gain_weight_choice);
        setTitle("Select Calories");

        SharedPreferences sp = getApplicationContext().getSharedPreferences("UserPrefs", MODE_PRIVATE);
        Float current = sp.getFloat("WEIGHT",0);
        Float gain = sp.getFloat("GAIN",0);


        TextView showCurrentWeight = findViewById(R.id.textViewCurrent);
        showCurrentWeight.setText("Current Weight: "+current+ "kg");

        TextView showTargetWeight = findViewById(R.id.textViewGain);
        showTargetWeight.setText("Target Weight: "+gain+ "kg");

        /*
        Button increase1 = findViewById(R.id.increase1);
        increase1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(GainWeightChoice.this, caloriesIncrease1.class);
                intent.putExtra("CALORIES",1);
                startActivity(intent);
            }
        });

        Button increase2 = findViewById(R.id.increase2);
        increase2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(GainWeightChoice.this, caloriesIncrease1.class);
                intent.putExtra("CALORIES",2);
                startActivity(intent);
            }
        });

        Button increase3 = findViewById(R.id.increase3);
        increase3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(GainWeightChoice.this, caloriesIncrease1.class);
                intent.putExtra("CALORIES",3);
                startActivity(intent);
            }
        });

        Button increase4 = findViewById(R.id.increase4);
        increase4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(GainWeightChoice.this, caloriesIncrease1.class);
                intent.putExtra("CALORIES",4);
                startActivity(intent);
            }
        });


         */
    }





}
