package com.example.cat201try2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class LoseWeightChoice extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lose_weight_choice);

        SharedPreferences sp = getApplicationContext().getSharedPreferences("UserPrefs", MODE_PRIVATE);
        SharedPreferences.Editor editor = sp.edit();

        Float current = sp.getFloat("WEIGHT",0);
        Float gain = sp.getFloat("LOSE",0);


        TextView showCurrentWeight = findViewById(R.id.textViewCurrent);
        showCurrentWeight.setText("Current Weight: "+current+ "kg");

        TextView showTargetWeight = findViewById(R.id.textViewLose);
        showTargetWeight.setText("Target Weight: "+gain+ "kg");


        Button deficit1 = findViewById(R.id.deficit1);
        deficit1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                int total = -300 + sp.getInt("MAINTAIN", 0);

                editor.putInt("GOAL", minCalCheck(total));
                editor.commit();

                Intent intent = new Intent(LoseWeightChoice.this, MainCalorieDisplay.class);
                startActivity(intent);
            }
        });

        Button deficit2 = findViewById(R.id.deficit2);
        deficit2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int total = -500 + sp.getInt("MAINTAIN", 0);


                editor.putInt("GOAL", minCalCheck(total));
                editor.commit();

                Intent intent = new Intent(LoseWeightChoice.this, MainCalorieDisplay.class);
                startActivity(intent);
            }
        });
//
        Button deficit3 = findViewById(R.id.deficit3);
        deficit3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int total = -700 + sp.getInt("MAINTAIN", 0);

                editor.putInt("GOAL", minCalCheck(total));
                editor.commit();

                Intent intent = new Intent(LoseWeightChoice.this, MainCalorieDisplay.class);
                startActivity(intent);
            }
        });

        Button deficit44 = findViewById(R.id.deficit4);
        deficit44.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int total = -1100 + sp.getInt("MAINTAIN", 0);
                editor.putInt("GOAL", minCalCheck(total));
                editor.commit();

                Intent intent = new Intent(LoseWeightChoice.this, MainCalorieDisplay.class);
                startActivity(intent);
            }
        });

    }

    public int minCalCheck (int input){
        int result;

        if(input <= 1200){
            result = 1200;
        }
        else
            result = input;

        return result;
    }

}