package com.example.quiz1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    Button toRegister;
    TextView studentList;
    String studentListItem;

    String name, code, score;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        toRegister = findViewById(R.id.RegisterButton);
        studentList = findViewById(R.id.StudentsList);

        name = getIntent().getStringExtra("name");
        code = getIntent().getStringExtra("code");
        score = getIntent().getStringExtra("score");

        if(name == null)
        {
            name = "";
        }
        if(code == null)
        {
            code = "";
        }
        if(score == null)
        {
            score = "";
        }
        else
        {
            studentListItem += name + ", " + code + " / pts: " + score;
        }

        studentList.setText(studentListItem);

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