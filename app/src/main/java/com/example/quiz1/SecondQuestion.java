package com.example.quiz1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

public class SecondQuestion extends AppCompatActivity {

    Button endBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second_question);

        endBtn = findViewById(R.id.endButton);

        endBtn.setOnClickListener(
                (view) ->
                {
                    switchScreen();
                }
        );
    }

    public void switchScreen()
    {
        Intent switchActivity = new Intent(this, MainActivity.class);
        startActivity(switchActivity);
    }
}