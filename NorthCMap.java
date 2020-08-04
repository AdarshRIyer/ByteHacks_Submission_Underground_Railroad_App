package com.example.underground_railroad_app;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class NorthCMap extends AppCompatActivity {
    public static boolean houseSelected = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_north_c_map);

        TextView first = (TextView) findViewById(R.id.textView48);
        TextView second = (TextView) findViewById(R.id.textView10);
        TextView third = (TextView) findViewById(R.id.textView46);
        TextView fourth = (TextView) findViewById(R.id.textView47);
        first.setVisibility(View.INVISIBLE);
        second.setVisibility(View.INVISIBLE);
        third.setVisibility(View.INVISIBLE);
        fourth.setVisibility(View.INVISIBLE);


    }

    public void showDetails(View view) {

        boolean selected = false;

        TextView first = (TextView) findViewById(R.id.textView30);
        TextView second = (TextView) findViewById(R.id.textView21);
        TextView third = (TextView) findViewById(R.id.textView20);
        TextView fourth = (TextView) findViewById(R.id.textView22);

        if (Math.round(Math.random() * 3 + 1) == 1) {
            selected = true;
            first.setVisibility(View.VISIBLE);
            second.setVisibility(View.INVISIBLE);
            third.setVisibility(View.INVISIBLE);
            fourth.setVisibility(View.INVISIBLE);
        }
        if (Math.round(Math.random() * 3 + 1) == 2) {
            selected = true;
            first.setVisibility(View.INVISIBLE);
            second.setVisibility(View.VISIBLE);
            third.setVisibility(View.INVISIBLE);
            fourth.setVisibility(View.INVISIBLE);
        }
        if (Math.round(Math.random() * 3 + 1) == 3) {
            selected = true;
            first.setVisibility(View.INVISIBLE);
            second.setVisibility(View.INVISIBLE);
            third.setVisibility(View.VISIBLE);
            fourth.setVisibility(View.INVISIBLE);
        }
        if (Math.round(Math.random() * 3 + 1) == 4) {
            selected = true;
            first.setVisibility(View.INVISIBLE);
            second.setVisibility(View.INVISIBLE);
            third.setVisibility(View.INVISIBLE);
            fourth.setVisibility(View.VISIBLE);
        }

        if (selected) {
            houseSelected = true;
        }
    }
    public void showDetails2(View view) {
        if (houseSelected) {
            Intent intent4 = new Intent(this, MeetCond.class);
            startActivity(intent4);
        }

    }
    public void LOGOUT(View view) {
        Intent intent4 = new Intent(this, MainActivity.class);
        startActivity(intent4);
    }
}