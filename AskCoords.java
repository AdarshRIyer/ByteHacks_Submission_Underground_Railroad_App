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
import android.os.Bundle;
import android.provider.Settings;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class AskCoords extends AppCompatActivity {
    public static final String EXTRA_MESSAGE = "com.example.myfirstapp.MESSAGE";
    private static final int REQUEST_LOCATION = 1;
    Button btnGetLocation;
    TextView showLocation;
    LocationManager locationManager;
    String latitude, longitude;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ask_coords);

        TextView errMessage = (TextView) findViewById(R.id.ErrCoords);
        errMessage.setVisibility(View.INVISIBLE);
        //showLocation.setTextColor(Color.rgb(100, 100, 100));
        //
        Intent intent2 = getIntent();
        //System.out.println("Started!");
        ActivityCompat.requestPermissions( this, new String[] {Manifest.permission.ACCESS_FINE_LOCATION}, REQUEST_LOCATION);
        showLocation = findViewById(R.id.showLocation2);
        btnGetLocation = findViewById(R.id.btnGetLocation2);
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
                AskCoords.this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(
                AskCoords.this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
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




    public void goToMap(View view) {
        TextView errMessage = (TextView) findViewById(R.id.ErrCoords);
        errMessage.setVisibility(View.INVISIBLE);
        EditText longitude = (EditText) findViewById(R.id.editTextNumberDecimal2);
        EditText latitude = (EditText) findViewById(R.id.editTextNumberDecimal4);
        //System.out.println(latitude); System.out.println(longitude);
        if ((!longitude.getText().toString().equals("")) && (!latitude.getText().toString().equals(""))) {
            double lat = Double.parseDouble(latitude.getText().toString());
            double longi = Double.parseDouble(longitude.getText().toString());
            if ((longi <= 84.0) && (longi >= 75.4)){
                if ((lat > 36.6) && (lat < 39.5)) {
                    Intent intent3 = new Intent(this, VirginiaMap.class);
                    startActivity(intent3);
                }
                if(lat <= 36.6 && lat>=32.0) {
                    if (longi>= 79.0 && lat <= 34.8) {
                        Intent intent3 = new Intent(this, SouthCMap.class);
                        startActivity(intent3);
                    }
                    else {
                        Intent intent3 = new Intent(this, NorthCMap.class);
                        startActivity(intent3);
                    }
                }
            }
            else {
                errMessage.setVisibility(View.VISIBLE);
            }
        }
        else {
            errMessage.setVisibility(View.VISIBLE);
        }


        //System.out.println("DEBUG");
        //System.out.println(lat);
        //System.out.println(longi);
        //System.out.println("END DEBUG");




    }
    public void LOGOUT(View view) {
        Intent intent4 = new Intent(this, MainActivity.class);
        startActivity(intent4);
    }
}