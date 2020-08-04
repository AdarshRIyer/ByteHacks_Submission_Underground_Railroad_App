package com.example.underground_railroad_app;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import java.util.Random;

public class AvailableSupplies extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_available_supplies);

        Intent intent = getIntent();

    }
    public void goHome(View view) {
        Intent intent4 = new Intent(this, OwnerHomePage.class);
        startActivity(intent4);
    }
    public void LOGOUT(View view) {
        Intent intent4 = new Intent(this, MainActivity.class);
        startActivity(intent4);
    }
}