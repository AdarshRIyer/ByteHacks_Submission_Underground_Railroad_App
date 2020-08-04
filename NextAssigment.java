package com.example.underground_railroad_app;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class NextAssigment extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_next_assigment);
    }
    public void LOGOUT(View view) {
        Intent intent4 = new Intent(this, MainActivity.class);
        startActivity(intent4);
    }
    public void goToCondMessages(View view) {
        Intent intent4 = new Intent(this, condDms.class);
        startActivity(intent4);
    }
    public void viewCerts(View view) {
        long random = Math.round((Math.random()*4)+1);
        if (random == 1) {
            Intent intent2 = new Intent(this, Group1Certificates.class);
            startActivity(intent2);
        }
        if (random == 2) {
            Intent intent2 = new Intent(this, Group2Certificates.class);
            startActivity(intent2);
        }
        if (random == 3) {
            Intent intent2 = new Intent(this, Group3Certificates.class);
            startActivity(intent2);
        }
        if (random == 4) {
            Intent intent2 = new Intent(this, Group4Certificates.class);
            startActivity(intent2);
        }
    }
    public void goToMapToContras(View view) {
        Intent intent4 = new Intent(this, MapToContras.class);
        startActivity(intent4);
    }

}