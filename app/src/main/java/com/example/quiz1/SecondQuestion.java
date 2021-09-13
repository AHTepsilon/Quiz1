package com.example.quiz1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.CheckBox;

public class SecondQuestion extends AppCompatActivity {

    Button endBtn;
    CheckBox checkBox2A, checkBox2B, checkBox2C;

    int newScore;
    String scoreString;

    String name, code;

    boolean box1AChecked;
    boolean box1BChecked;
    boolean box1CChecked;

    boolean box2AChecked;
    boolean box2BChecked;
    boolean box2CChecked;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second_question);

        name = getIntent().getStringExtra("name");
        code = getIntent().getStringExtra("code");

        box1AChecked = getIntent().getBooleanExtra("firstQuestionResult", false);
        box1BChecked = getIntent().getBooleanExtra("secondQuestionResult", false);
        box1CChecked = getIntent().getBooleanExtra("thirdQuestionResult", false);

        scoreString = getIntent().getStringExtra("score");

        newScore = Integer.parseInt(scoreString);

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
        checkBoxes();

        if(box2AChecked || box2BChecked || box2CChecked) {
            Log.d("score", String.valueOf(newScore));

            Intent switchActivity = new Intent(this, MainActivity.class);
            switchActivity.putExtra("name", name);
            switchActivity.putExtra("code", code);
            switchActivity.putExtra("score", String.valueOf(newScore));
            startActivity(switchActivity);
        }
    }

    public void checkBoxes()
    {
        box2AChecked = checkBox2A.isChecked();
        box2BChecked = checkBox2B.isChecked();
        box2CChecked = checkBox2C.isChecked();

        if(box2AChecked)
        {
            newScore += 3;
        }

        if(box2BChecked)
        {
            newScore += 3;
        }

        if(box2CChecked)
        {
            newScore += 0;
        }
    }
}