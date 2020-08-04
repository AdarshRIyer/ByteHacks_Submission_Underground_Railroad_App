package com.example.underground_railroad_app;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class OwnerLogin extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_owner_login);

        Intent intent = getIntent();

        TextView PassErr = (TextView) findViewById(R.id.errPass3);
        PassErr.setVisibility(View.INVISIBLE);
    }
    public void ownLogin(View view) {
        EditText own1 = (EditText) findViewById(R.id.ownUsername);
        EditText own2 = (EditText) findViewById(R.id.ownPass);
        TextView PassErr = (TextView) findViewById(R.id.errPass3);
        if (own1.getText().toString().equals("Username") && own2.getText().toString().equals("password")) {
            Intent intent2 = new Intent(this, OwnerHomePage.class);
            startActivity(intent2);
        }
        else {
            PassErr.setVisibility(View.VISIBLE);
        }
    }
    public void OwnRegister(View view) {
        Intent intent4 = new Intent(this, OwnerRegistration.class);
        startActivity(intent4);
    }
}