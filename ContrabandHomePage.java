package com.example.underground_railroad_app;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class ContrabandHomePage extends AppCompatActivity {
    //public boolean registfinished = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contraband_home_page);
    }
    public void setReservation(View view) {
        Intent intent4 = new Intent(this, AskCoords.class);
        startActivity(intent4);
        //registfinished = true;
    }
    public void goToCond(View view) {
        Intent intent4 = new Intent(this, MeetCond.class);
        //if (registfinished) {
            startActivity(intent4);
        //}
    }
    public void goToMess(View view) {
        Intent intent4 = new Intent(this, ContraDms.class);
        //if (registfinished) {
            startActivity(intent4);
        //}
    }
    public void LOGOUT(View view) {
        Intent intent4 = new Intent(this, MainActivity.class);
        startActivity(intent4);
        //registfinished = true;
    }

}