package com.example.quiz1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.CheckBox;

import com.example.quiz1.model.Student;
import com.google.gson.Gson;

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
            Student stdnt = new Student(name, code, String.valueOf(newScore));

            Gson gson = new Gson();
            String json = gson.toJson(stdnt);

            Log.d(">>>", "" + json);
            Log.d("score", String.valueOf(newScore));

            SharedPreferences preferences = getApplicationContext().getSharedPreferences("prefs", MODE_PRIVATE);
            SharedPreferences.Editor editor = preferences.edit();
            editor.putString("lastName", name);
            editor.putString("lastCode", code);
            editor.putString("lastScore", String.valueOf(newScore));

            editor.commit();

            Intent switchActivity = new Intent(this, MainActivity.class);
            switchActivity.putExtra("name", name);
            switchActivity.putExtra("code", code);
            switchActivity.putExtra("score", String.valueOf(newScore));
            switchActivity.putExtra("json", json);
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

    public void loadPreferences()
    {

    }
}