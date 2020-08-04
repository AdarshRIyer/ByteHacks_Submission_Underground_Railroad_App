package com.example.underground_railroad_app;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

import java.util.Random;

public class MeetCond extends AppCompatActivity {

    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_meet_cond);
        TextView condName = (TextView) findViewById(R.id.CondView);
        condName.setText("");
        long random = Math.round(Math.random()*9+1);
        String[] CondNames = new String[10];
        CondNames[0] = "Oshea Victor"; CondNames[1] = "Tyson Sumner"; CondNames[2] = "Lia Dallas"; CondNames[3] ="Janelle Elwes"; CondNames[4] = "Olabode Thorley";
        CondNames[5] ="Yakubu Cook"; CondNames[6] ="Tracey Nielson"; CondNames[7] ="Sizwe Adebayo"; CondNames[8] ="Glenda Honeycutt"; CondNames[9] ="Damian Garrel";
        Random generator = new Random();
        int randomIndex = generator.nextInt(CondNames.length);
        condName.setText(CondNames[randomIndex]);
    }
    public void LOGOUT(View view) {
        Intent intent4 = new Intent(this, MainActivity.class);
        startActivity(intent4);
    }
    public void GoToContraDms(View view) {
        Intent intent4 = new Intent(this, ContraDms.class);
        startActivity(intent4);
    }
    public void GoHome(View view) {
        Intent intent4 = new Intent(this, ContrabandHomePage.class);
        startActivity(intent4);
    }


}