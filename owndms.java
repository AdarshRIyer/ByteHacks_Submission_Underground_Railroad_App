package com.example.underground_railroad_app;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

public class owndms extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_owndms);

        Intent intent = getIntent();

        TextView texttosend = (TextView) findViewById(R.id.message_body16);
        texttosend.setVisibility(View.INVISIBLE);

    }
    public void LOGOUT(View view) {
        Intent intent4 = new Intent(this, MainActivity.class);
        startActivity(intent4);
    }
    public void sendText(View view) {
        EditText typefield = (EditText) findViewById(R.id.condSendMsgs);
        TextView texttosend = (TextView) findViewById(R.id.message_body16);
        texttosend.setText(typefield.getText());
        texttosend.setVisibility(View.VISIBLE);
        typefield.setText("");
    }
    public void GoHome(View view) {
        Intent intent4 = new Intent(this, NextAssigment.class);
        startActivity(intent4);
    }
}