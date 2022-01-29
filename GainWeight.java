package com.example.cat201try2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class GainWeight extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gain_weight);
        setTitle("Gain Weight");

        SharedPreferences sp = getApplicationContext().getSharedPreferences("UserPrefs", MODE_PRIVATE);

        TextView currentWeightShow = findViewById(R.id.viewCurrentWeight);
        Float currentWeight = sp.getFloat("WEIGHT", 0);
        currentWeightShow.setText(currentWeight + "KG");

        TextView caloriesMaintain = findViewById(R.id.caloriesMaintainShow);
        caloriesMaintain.setText(sp.getInt("MAINTAIN", 0) + " calories");



        Button calculate = findViewById(R.id.calculate);
        calculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                EditText UserAnswer = findViewById(R.id.UserTargetGainWeight);
                Float targetGainWeight = Float.parseFloat(UserAnswer.getText().toString());

                if (targetGainWeight <= currentWeight) {
                    Toast.makeText(GainWeight.this, "Target weight must greater than current weight", Toast.LENGTH_SHORT).show();
                }
                else {

                    saveData(targetGainWeight);
                    Intent intent = new Intent(GainWeight.this, GainWeightChoice.class);
                    startActivity(intent);
                }
            }
        });

    }

    public void saveData(Float x){

        SharedPreferences sp2 = getSharedPreferences("UserPrefs", MODE_PRIVATE);
        SharedPreferences.Editor editor = sp2.edit();

        editor.putFloat("GAIN",x);
        editor.commit();
    }



    }
