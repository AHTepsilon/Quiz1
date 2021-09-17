package com.example.quiz1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.TextView;

import com.example.quiz1.model.Student;
import com.google.gson.Gson;

public class MainActivity extends AppCompatActivity {

    Button toRegister;
    TextView studentList;
    String studentListItem;

    String name, code, score, json;
    String userName, userCode, userGrade;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        toRegister = findViewById(R.id.RegisterButton);
        studentList = findViewById(R.id.StudentsList);

        name = getIntent().getStringExtra("name");
        code = getIntent().getStringExtra("code");
        score = getIntent().getStringExtra("score");
        json = getIntent().getStringExtra("json");

        SharedPreferences prefer = getSharedPreferences("prefs", MODE_PRIVATE);

        userName = prefer.getString("lastName", "NO_NAME");
        userCode = prefer.getString("lastCode", "NO_CODE");
        userGrade = prefer.getString("lastScore", "0");

        /*SharedPreferences preferences = getSharedPreferences("prefs", MODE_PRIVATE);
        String jsonSP = preferences.getString("lastName", "NO_OBJ");*/

        studentListItem = "";

        loadPreferences();

        if(userName != null && userCode != null && userGrade != null)
        {
            studentListItem += userName + ", " + userCode + ", " + userGrade;
        }

       /* if(jsonSP == "NO_OBJ")
        {

        }
        else
        {
            Gson gson = new Gson();
            studentListItem += jsonSP;
        }*/

        //else
        //{
        //    studentListItem = "";
       // }

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
        switchActivity.putExtra("nameOrig", userName);
        switchActivity.putExtra("codeOrig", userCode);
        startActivity(switchActivity);
    }

    public void loadPreferences()
    {
       /* SharedPreferences preferences = getSharedPreferences("prefs", MODE_PRIVATE);

        String userName = preferences.getString("lastName", "NO_NAME");
        String userCode = preferences.getString("lastCode", "NO_CODE");
        String userGrade = preferences.getString("lastScore", "0");

        studentListItem += userName + ", " + userCode + ", " + userGrade;*/
    }

}