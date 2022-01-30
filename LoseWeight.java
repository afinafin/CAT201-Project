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

//        TextView result = findViewById(R.id.result);

//        old method spinner weight
//        Spinner optionWeight = (Spinner) findViewById(R.id.spinner);
//        ArrayAdapter adapter = new ArrayAdapter(this, android.R.layout.simple_spinner_item, getResources().getStringArray(R.array.recWeight));
//        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
//        optionWeight.setAdapter(adapter);

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

                //old method lose weight calc
//                option = optionWeight.getSelectedItemPosition();
//
//                tdee = sp.getInt("MAINTAIN",0);
//                editor.putInt("MAINTAIN",kiraKal(option, tdee));
//                editor.commit();
//
//                Intent intent1 = new Intent(LoseWeight.this, Activity2.class);
//                startActivity(intent1);
//                result.setText((int) option + " ");
            }
        });

        }

        public void saveData(Float x){

            SharedPreferences sp2 = getSharedPreferences("UserPrefs", MODE_PRIVATE);
            SharedPreferences.Editor editor = sp2.edit();

            editor.putFloat("LOSE",x);
            editor.commit();
        }

//    old method calc
//    public int kiraKal(int input, int cal){
//        int result;
//
//        if (input == 0){
//            result = cal - 350;
//        }
//        else if (input == 1){
//            result = cal - 500;
//        }
//        else if (input == 2){
//            result = cal - 850;
//        }
//        else
//            result = cal - 1100;
//
//        if(result <=1200){
//            result = 1200;
//        }
//
//        return result;
//    };



}
