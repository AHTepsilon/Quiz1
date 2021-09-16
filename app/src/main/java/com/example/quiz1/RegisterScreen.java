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

    String name, code;

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
    }

    public void switchScreen()
    {
        name = textName.getText().toString();
        code = textCode.getText().toString();

        if(!name.isEmpty() && !code.isEmpty())
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