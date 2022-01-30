package com.example.cat201try2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class LoseWeight extends AppCompatActivity {

//    int tdee,option;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lose_weight);
        setTitle("Lose Weight");

        //EditText UserAnswer = findViewById(R.id.UserTargetLoseWeight);
        //int targetLoseWeight = Integer.parseInt(UserAnswer.getText().toString());
        SharedPreferences sp = getSharedPreferences("UserPrefs", MODE_PRIVATE);

        TextView currentWeightShow = findViewById(R.id.viewCurrentWeight);
        Float currentWeight = sp.getFloat("WEIGHT", 0);
        currentWeightShow.setText(currentWeight + "KG");

        TextView caloriesMaintain = findViewById(R.id.caloriesMaintainShow);
        caloriesMaintain.setText(sp.getInt("MAINTAIN", 0) + " calories");



        Button calc = findViewById(R.id.calculate);
        calc.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view) {

                EditText UserAnswer = findViewById(R.id.UserTargetLoseWeight);
                Float targetGainWeight = Float.parseFloat(UserAnswer.getText().toString());

                if (targetGainWeight >= currentWeight) {
                    Toast.makeText(LoseWeight.this, "Target weight must lower than current weight", Toast.LENGTH_SHORT).show();
                }
                else {

                    saveData(targetGainWeight);
                    Intent intent = new Intent(LoseWeight.this, LoseWeightChoice.class);
                    startActivity(intent);
                }


            }
        });

        }

        public void saveData(Float x){

            SharedPreferences sp2 = getSharedPreferences("UserPrefs", MODE_PRIVATE);
            SharedPreferences.Editor editor = sp2.edit();

            editor.putFloat("LOSE",x);
            editor.commit();
        }




}
