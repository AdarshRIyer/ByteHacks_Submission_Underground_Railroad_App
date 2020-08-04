package com.example.underground_railroad_app;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public void CondLogin(View view) {
        Intent intent = new Intent(this, ConductorLogin.class);
        startActivity(intent);
    }
    public void ContraLogin(View view) {
        Intent intent = new Intent(this, ContrabandLogin.class);
        startActivity(intent);
    }
    public void OwnerLogin(View view) {
        Intent intent = new Intent(this, OwnerLogin.class);
        startActivity(intent);
    }
}