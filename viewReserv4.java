package com.example.underground_railroad_app;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class viewReserv4 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_reserv4);
    }
    public void GoHome(View view) {
        Intent intent4 = new Intent(this, OwnerHomePage.class);
        startActivity(intent4);
    }
    public void LOGOUT(View view) {
        Intent intent4 = new Intent(this, MainActivity.class);
        startActivity(intent4);
    }
}