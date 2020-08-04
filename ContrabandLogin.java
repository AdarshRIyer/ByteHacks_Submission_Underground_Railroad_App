package com.example.underground_railroad_app;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import java.util.Map;

public class ContrabandLogin extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contraband_login);

        Intent intent = getIntent();

        TextView PassErr = (TextView) findViewById(R.id.errPass2);
        PassErr.setVisibility(View.INVISIBLE);


    }
    public void contraLogin(View view) {
        EditText contra1 = (EditText) findViewById(R.id.contraUsername);
        EditText contra2 = (EditText) findViewById(R.id.contraPassword);
        TextView PassErr = (TextView) findViewById(R.id.errPass2);
        if (contra1.getText().toString().equals("Username") && contra2.getText().toString().equals("password")) {
            Intent intent2 = new Intent(this, ContrabandHomePage.class);
            startActivity(intent2);
        }
        else {
            PassErr.setVisibility(View.VISIBLE);
        }
    }
    public void ContraRegister(View view) {
        Intent intent4 = new Intent(this, ContrabandRegistration.class);
        startActivity(intent4);
    }
}