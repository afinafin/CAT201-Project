package com.example.cat201try2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Toast;
import android.widget.Spinner;

public  class UpdateMeals extends AppCompatActivity {

    //initialize just to check working
    int mealCal, inputValue;
    String state;
    Button mealSaveBtn, mealCancelBtn, display;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.update_meals);
        setTitle("UPDATE MEALS");

        mealSaveBtn = findViewById(R.id.saveMeal);
        mealCancelBtn = findViewById(R.id.cancelMeal);
        SharedPreferences sp = getSharedPreferences("UserPrefs", MODE_PRIVATE);
        SharedPreferences.Editor editor = sp.edit();


        Spinner mealSpinner = (Spinner) findViewById(R.id.mealSpinner);
        ArrayAdapter<String> myAdapter = new ArrayAdapter<String>(UpdateMeals.this, android.R.layout.simple_list_item_1, getResources().getStringArray(R.array.meals));
        myAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        mealSpinner.setAdapter(myAdapter);

        mealSaveBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                state = mealSpinner.getSelectedItem().toString();
                Toast.makeText(getApplicationContext(), state + " is selected", Toast.LENGTH_SHORT).show();

                editor.putInt("INTAKE",saveData(state));
                editor.putInt("BURN",0);
                editor.commit();

                Intent intent = new Intent(UpdateMeals.this, MainCalorieDisplay.class);
                startActivity(intent);

            }
        });

        mealCancelBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                editor.putInt("INTAKE",0);
                editor.putInt("BURN",0);
                editor.commit();
                Intent intent = new Intent(UpdateMeals.this, MainCalorieDisplay.class);
                startActivity(intent);
            }

        });

    }

    public int saveData(String input){
        int cal;
        if (input.equals("Nasi Lemak")){
            cal = 490;
        }
        else if (input.equals("Half Boiled Egg")){
            cal = 68;
        }
        else if (input.equals("White Gardenia(2 slices)")){
            cal = 160;
        }
        else if (input.equals("Chicken Salad")){
            cal = 230;
        }
        else if (input.equals("Spaghetti Bolognese")){
            cal = 488;
        }
        else if (input.equals("Chicken Breast Grilled")){
            cal = 220;
        }
        else
            cal=0;

        return cal;

    }

}

