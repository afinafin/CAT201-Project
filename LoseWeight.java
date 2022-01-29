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

public class LoseWeight extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lose_weight);
        setTitle("Lose Weight");
        SharedPreferences sp = getApplicationContext().getSharedPreferences("UserPrefs", MODE_PRIVATE);

        TextView currentweightShow = findViewById(R.id.viewCurrentWeight2);
        Float currentWeight = sp.getFloat("WEIGHT", 0);
        currentweightShow.setText(currentWeight + "KG");

        TextView caloriesMaintain = findViewById(R.id.caloriesMaintainShow2);
        caloriesMaintain.setText(sp.getInt("MAINTAIN", 0) + " calories");



        Button calculate = findViewById(R.id.calculateLoseWeight2);
        calculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                EditText UserAnswer = findViewById(R.id.UserTargetLoseWeight);
                Float targetLoseWeight = Float.parseFloat(UserAnswer.getText().toString());

                if (targetLoseWeight >= currentWeight) {
                    Toast.makeText(LoseWeight.this, "Target weight must less than current weight", Toast.LENGTH_SHORT).show();
                }
                else {

                    saveData(targetLoseWeight);
                    Intent intent = new Intent(LoseWeight.this, GainWeightChoice.class);
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
