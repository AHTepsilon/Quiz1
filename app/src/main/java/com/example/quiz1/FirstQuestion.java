package com.example.quiz1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.CheckBox;

public class FirstQuestion extends AppCompatActivity {

    Button continueBtn2;
    CheckBox checkBox1A, checkBox1B, checkBox1C;
    int score;
    String scoreString;

    boolean box1AChecked;
    boolean box1BChecked;
    boolean box1CChecked;

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
        checkBoxes();

        scoreString = String.valueOf(score);

        Intent switchActivity = new Intent(this, SecondQuestion.class);
        switchActivity.putExtra("firstQuestionResult", box1AChecked);
        switchActivity.putExtra("secondQuestionResult", box1BChecked);
        switchActivity.putExtra("thirdQuestionResult", box1CChecked);
        switchActivity.putExtra("score", scoreString);

        startActivity(switchActivity);
    }

    public void checkBoxes()
    {
        box1AChecked = checkBox1A.isChecked();
        box1BChecked = checkBox1B.isChecked();
        box1CChecked = checkBox1C.isChecked();

        if(box1AChecked)
        {
            score += 1;
        }

        if(box1BChecked)
        {
            score += 3;
        }

        if(box1CChecked)
        {
            score += 0;
        }
    }
}