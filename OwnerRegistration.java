package com.example.underground_railroad_app;

import android.Manifest;
import android.annotation.SuppressLint;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Color;
import android.location.Location;
import android.location.LocationManager;
import android.provider.Settings;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class OwnerRegistration extends AppCompatActivity {
    private static final int REQUEST_LOCATION = 1;
    Button btnGetLocation;
    TextView showLocation;
    LocationManager locationManager;
    String latitude, longitude;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_owner_registration);
        TextView errMessageUP = (TextView) findViewById(R.id.errRegist);
        errMessageUP.setVisibility(View.INVISIBLE);
        TextView errMessage4 = (TextView) findViewById(R.id.errCoords4);
        errMessage4.setVisibility(View.INVISIBLE);

        ActivityCompat.requestPermissions( this, new String[] {Manifest.permission.ACCESS_FINE_LOCATION}, REQUEST_LOCATION);
        showLocation = findViewById(R.id.showLocation);
        btnGetLocation = findViewById(R.id.btnGetLocation);
        btnGetLocation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                LocationManager nManager = (LocationManager) getSystemService(Context.LOCATION_SERVICE);
                try {
                    if (!locationManager.isProviderEnabled(LocationManager.GPS_PROVIDER)) {
                        OnGPS();
                    } else {
                        getLocation();
                    }
                }
                catch (NullPointerException e) {
                    showLocation.setTextColor(Color.rgb(255, 0, 0));
                    showLocation.setText(R.string.ErrVirtualDevice);
                }

            }
        });
    }

    private void OnGPS() {
        final AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage("Enable GPS").setCancelable(false).setPositiveButton("Yes", new  DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                startActivity(new Intent(Settings.ACTION_LOCATION_SOURCE_SETTINGS));
            }
        }).setNegativeButton("No", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.cancel();
            }
        });
        final AlertDialog alertDialog = builder.create();
        alertDialog.show();
    }
    @SuppressLint("SetTextI18n")
    private void getLocation() {
        if (ActivityCompat.checkSelfPermission(
                OwnerRegistration.this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(
                OwnerRegistration.this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.ACCESS_FINE_LOCATION}, REQUEST_LOCATION);
        } else {
            Location locationGPS = locationManager.getLastKnownLocation(LocationManager.GPS_PROVIDER);
            if (locationGPS != null) {
                double lat = locationGPS.getLatitude();
                double longi = locationGPS.getLongitude();
                latitude = String.valueOf(lat);
                longitude = String.valueOf(longi);
                showLocation.setText("Your Location: " + "\n" + "Latitude: " + latitude + "\n" + "Longitude: " + longitude);
            } else {
                Toast.makeText(this, "Unable to find location.", Toast.LENGTH_SHORT).show();
            }
        }
    }







    public void Register(View view) {
        TextView errMessage4 = (TextView) findViewById(R.id.errCoords4);
        EditText degw = (EditText) findViewById(R.id.editTextNumberDecimal6);
        EditText degn = (EditText) findViewById(R.id.editTextNumberDecimal7);
        boolean ok1 = false;
        TextView errMessageUP = (TextView) findViewById(R.id.errRegist);
        if ((!degw.getText().toString().equals("")) && (!degn.getText().toString().equals(""))) {
            double lat = Double.parseDouble(degn.getText().toString());
            double longi = Double.parseDouble(degw.getText().toString());
            if ((longi <= 84.0) && (longi >= 75.4) && (lat <= 40.0) && (lat >= 32.0)){
                ok1 = true;
            }
            else {
                errMessage4.setVisibility(View.VISIBLE);
            }
        }
        else {
            errMessage4.setVisibility(View.VISIBLE);
        }
        EditText username = (EditText) findViewById(R.id.ownUsername5);
        EditText password = (EditText) findViewById(R.id.ownPass5);
        boolean ok2 = false;

        if (!username.getText().toString().equals("") && !password.getText().toString().equals("")) {
            ok2 = true;
        }
        else {
            errMessageUP.setVisibility(View.VISIBLE);
        }
        if (ok1 && ok2) {
            Intent intent4 = new Intent(this, OwnerHomePage.class);
            startActivity(intent4);
        }

    }
}
