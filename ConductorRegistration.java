package com.example.underground_railroad_app;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class ConductorRegistration extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_conductor_registration);
        TextView errMessageUP = (TextView) findViewById(R.id.errRegist3);
        errMessageUP.setVisibility(View.INVISIBLE);
    }
    public void Register(View view) {
        TextView errMessageUP = (TextView) findViewById(R.id.errRegist3);
        EditText username = (EditText) findViewById(R.id.ownUsername3);
        EditText password = (EditText) findViewById(R.id.ownPass3);
        if (!username.getText().toString().equals("") && !password.getText().toString().equals("")) {
            Intent intent4 = new Intent(this, NextAssigment.class);
            startActivity(intent4);
        }
        else {
            errMessageUP.setVisibility(View.VISIBLE);
        }
    }
}