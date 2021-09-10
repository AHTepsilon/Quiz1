package com.example.quiz1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

public class RegisterScreen extends AppCompatActivity {

    Button continueBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register_screen);

        continueBtn = findViewById(R.id.ContinueButton1);

        continueBtn.setOnClickListener(
                (view) ->
                {
                    switchScreen();
                }
        );
    }

    public void switchScreen()
    {
        Intent switchActivity = new Intent(this, FirstQuestion.class);
        startActivity(switchActivity);
    }
}