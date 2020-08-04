package com.example.underground_railroad_app;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class ContrabandRegistration extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contraband_registration);
        TextView errMessageUP = (TextView) findViewById(R.id.errRegist2);
        errMessageUP.setVisibility(View.INVISIBLE);
    }
    public void Register(View view) {
        TextView errMessageUP = (TextView) findViewById(R.id.errRegist2);
        EditText username = (EditText) findViewById(R.id.ownUsername2);
        EditText password = (EditText) findViewById(R.id.ownPass2);
        EditText pin = (EditText) findViewById(R.id.editTextTextPersonName);
        if (!username.getText().toString().equals("") && !password.getText().toString().equals("") && (pin.getText().toString().length() == 6)) {
            Intent intent4 = new Intent(this, ContrabandHomePage.class);
            startActivity(intent4);
        }
        else {
            errMessageUP.setVisibility(View.VISIBLE);
        }

    }
}