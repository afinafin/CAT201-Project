package com.example.cat201try2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class UpdateExercise extends AppCompatActivity {

    //initialize just to check calculation working or not
    int burnCal;
    Button exerciseSaveBtn, exerciseCancelBtn, watchVideo;
    EditText updateCalBurn;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.update_exercise);
        setTitle("UPDATE EXERCISE");

        SharedPreferences sp = getApplicationContext().getSharedPreferences("UserPrefs", MODE_PRIVATE);
        SharedPreferences.Editor editor = sp.edit();

        exerciseSaveBtn = findViewById(R.id.saveExercise);
        exerciseCancelBtn = findViewById(R.id.cancelExercise);
        watchVideo = findViewById(R.id.watchVideo);
        updateCalBurn = findViewById(R.id.burnInput);


        exerciseSaveBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                burnCal = Integer.parseInt(updateCalBurn.getText().toString());

                editor.putInt("BURN", burnCal);
                editor.commit();

                Intent intent = new Intent(UpdateExercise.this, MainCalorieDisplay.class);
                startActivity(intent);
            }
        });

        watchVideo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(UpdateExercise.this, WatchVideo.class);
                startActivity(intent);
            }

        });

        exerciseCancelBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                editor.putInt("BURN", 0);
                editor.commit();
                Intent intent = new Intent(UpdateExercise.this, MainCalorieDisplay.class);
                startActivity(intent);
            }

        });
    }
}