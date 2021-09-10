package com.example.quiz1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button toRegister;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        toRegister = findViewById(R.id.RegisterButton);

        toRegister.setOnClickListener(
                (view) ->
                {
                    switchScreen();
                }
        );
    }

    public void switchScreen()
    {
        Intent switchActivity = new Intent(this, RegisterScreen.class);
        startActivity(switchActivity);
    }
}