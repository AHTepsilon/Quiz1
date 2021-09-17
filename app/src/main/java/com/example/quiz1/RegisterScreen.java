package com.example.quiz1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;

import com.google.gson.Gson;

public class RegisterScreen extends AppCompatActivity {

    Button continueBtn;
    EditText textName, textCode;

    String name, code, nameOrig, codeOrig;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register_screen);

        continueBtn = findViewById(R.id.ContinueButton1);
        textName = findViewById(R.id.nameText);
        textCode = findViewById(R.id.codeText);

        continueBtn.setOnClickListener(
                (view) ->
                {
                    switchScreen();
                }
        );

        Log.d("<<<" ,nameOrig + ", " + codeOrig);
    }

    public void switchScreen()
    {
        name = textName.getText().toString();
        code = textCode.getText().toString();

        nameOrig = getIntent().getStringExtra("nameOrig");
        codeOrig = getIntent().getStringExtra("codeOrig");


        Log.d("<<<" ,nameOrig + ", " + codeOrig);
        Log.d("<<<", name + ", " + code);


        if((!name.isEmpty() && !code.isEmpty()) || !(code == codeOrig))
        {
            Intent switchActivity = new Intent(this, FirstQuestion.class);
            switchActivity.putExtra("name", name);
            switchActivity.putExtra("code", code);
            startActivity(switchActivity);
        }
    }

    @Override
    protected void onPause()
    {
        super.onPause();

    }

    @Override
    protected void onResume() {
        super.onResume();

    }
}