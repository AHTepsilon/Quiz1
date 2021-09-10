package com.example.quiz1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.CheckBox;

public class SecondQuestion extends AppCompatActivity {

    Button endBtn;
    CheckBox checkBox2A, checkBox2B, checkBox2C;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second_question);

        endBtn = findViewById(R.id.endButton);

        checkBox2A = findViewById(R.id.checkBoxB1);
        checkBox2B = findViewById(R.id.checkBoxB2);
        checkBox2C = findViewById(R.id.checkBoxB3);

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