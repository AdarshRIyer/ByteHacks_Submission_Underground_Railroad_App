package com.example.underground_railroad_app;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class ConductorLogin extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_conductor_login);

        Intent intent = getIntent();

        TextView PassErr = (TextView) findViewById(R.id.errPass);
        PassErr.setVisibility(View.INVISIBLE);


    }
    public void condLogin(View view) {
        EditText contra1 = (EditText) findViewById(R.id.CondUsername);
        EditText contra2 = (EditText) findViewById(R.id.CondPassword);
        TextView PassErr = (TextView) findViewById(R.id.errPass);
        if (contra1.getText().toString().equals("Username") && contra2.getText().toString().equals("password")) {
            Intent intent2 = new Intent(this, NextAssigment.class);
            startActivity(intent2);
        }
        else {
            PassErr.setVisibility(View.VISIBLE);
        }
    }
    public void CondtraRegister(View view) {
        Intent intent4 = new Intent(this, ConductorRegistration.class);
        startActivity(intent4);
    }
}