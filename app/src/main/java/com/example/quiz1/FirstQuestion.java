package com.example.quiz1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.CheckBox;

public class FirstQuestion extends AppCompatActivity {

    Button continueBtn2;
    CheckBox checkBox1A, checkBox1B, checkBox1C;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first_question);

        continueBtn2 = findViewById(R.id.ContinueButton2);

        checkBox1A = findViewById(R.id.checkBoxA1);
        checkBox1B = findViewById(R.id.checkBoxA2);
        checkBox1C = findViewById(R.id.checkBoxA3);

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