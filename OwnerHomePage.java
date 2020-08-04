package com.example.underground_railroad_app;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class OwnerHomePage extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_owner_home_page);
    }
    public void LOGOUT(View view) {
        Intent intent4 = new Intent(this, MainActivity.class);
        startActivity(intent4);
    }
    public void viewSupplies(View view) {
        Intent intent4 = new Intent(this, AvailableSupplies.class);
        startActivity(intent4);
    }
    public void viewReservations(View view) {
        long random = Math.round((Math.random()*4)+1);
        if (random == 1) {
            Intent intent2 = new Intent(this, viewReserv.class);
            startActivity(intent2);
        }
        if (random == 2) {
            Intent intent2 = new Intent(this, viewReserv2.class);
            startActivity(intent2);
        }
        if (random == 3) {
            Intent intent2 = new Intent(this, viewReserv3.class);
            startActivity(intent2);
        }
        if (random == 4) {
            Intent intent2 = new Intent(this, viewReserv4.class);
            startActivity(intent2);
        }
    }
    public void viewMessages(View view) {
        Intent intent4 = new Intent(this, owndms.class);
        startActivity(intent4);
    }

}