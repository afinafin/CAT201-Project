package com.example.cat201try2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.TextView;

public class LoseWeight extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lose_weight);
        setTitle("Lose Weight");

        SharedPreferences sp = getApplicationContext().getSharedPreferences("UserPrefs", MODE_PRIVATE);

        TextView viewWeight = findViewById(R.id.viewWeight2);
        viewWeight.setText(sp.getFloat("WEIGHT",0)+" kg");

        /*
        EditText InputLoseWeight;
        InputLoseWeight = findViewById(R.id.UserTargetLoseWeight);
*/


    }
}
