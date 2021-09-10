package com.example.quiz1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

public class FirstQuestion extends AppCompatActivity {

    Button continueBtn2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first_question);

        continueBtn2 = findViewById(R.id.ContinueButton2);

        continueBtn2.setOnClickListener(
                (view) ->
                {
                    switchScreen();
                }
        );
    }

    public void switchScreen()
    {
        Intent switchActivity = new Intent(this, SecondQuestion.class);
        startActivity(switchActivity);
    }
}