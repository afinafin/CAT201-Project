package com.example.cat201try2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class UserLogin extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_login);

        EditText LoginName, LoginPassword;
        Button login;

        LoginName=findViewById(R.id.UserNameLogin);
        LoginPassword=findViewById(R.id.UserPasswordLogin);
        login=findViewById(R.id.buttonLogin);

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //correct password, Username:Admin , Password:1234
                if(LoginName.getText().toString().equals("Admin") && LoginPassword.getText().toString().equals("1234")) {
                    
                    Toast.makeText(UserLogin.this, "Login Successful!",Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(UserLogin.this, MainActivity.class);
                    startActivity(intent);
                    
                } else
                {
                        //incorrect password
                    Toast.makeText(UserLogin.this, "Login Failed!",Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
