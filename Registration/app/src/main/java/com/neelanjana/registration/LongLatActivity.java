package com.neelanjana.registration;

import android.content.Context;
import android.content.pm.PackageManager;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class LongLatActivity extends AppCompatActivity {

    private static final long MINIMUM_DISTANCE_CHANGE_FOR_UPDATES = 1; // in Meters
    private static final long MINIMUM_TIME_BETWEEN_UPDATES = 1000; // in Milliseconds
    protected LocationManager locationManager;
    protected Button btnLocation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_long_lat);

        btnLocation = (Button) findViewById(R.id.btnLocation);
        locationManager = (LocationManager) getSystemService(Context.LOCATION_SERVICE);

        if (ActivityCompat.checkSelfPermission(this, android.Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this, android.Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            // TODO: Consider calling
            //    ActivityCompat#requestPermissions
            // here to request the missing permissions, and then overriding
            //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
            //                                          int[] grantResults)
            // to handle the case where the user grants the permission. See the documentation
            // for ActivityCompat#requestPermissions for more details.
            return;
        }
        locationManager.requestLocationUpdates(LocationManager.GPS_PROVIDER, MINIMUM_TIME_BETWEEN_UPDATES, MINIMUM_DISTANCE_CHANGE_FOR_UPDATES, new MyLocationListener());

        btnLocation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showCurrentLocation();
            }
        });
    }

    protected void showCurrentLocation() {
        if (ActivityCompat.checkSelfPermission(this, android.Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this, android.Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            // TODO: Consider calling
            //    ActivityCompat#requestPermissions
            // here to request the missing permissions, and then overriding
            //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
            //                                          int[] grantResults)
            // to handle the case where the user grants the permission. See the documentation
            // for ActivityCompat#requestPermissions for more details.
            return;
        }
        Location location = locationManager.getLastKnownLocation(LocationManager.GPS_PROVIDER);
        if (location != null) {
            String message = String.format("Current Location \n Longitude: %1$s \n Latitude: %2$s",
                    location.getLongitude(), location.getLatitude());
            Toast.makeText(LongLatActivity.this, message,
                    Toast.LENGTH_LONG).show();
        }
    }

    private class MyLocationListener implements LocationListener {

        @Override
        public void onLocationChanged(Location location) {
            String message = String.format(
                    "New Location \n Longitude: %1$s \n Latitude: %2$s",
                    location.getLongitude(), location.getLatitude()
            );
            Toast.makeText(LongLatActivity.this, message, Toast.LENGTH_LONG).show();

        }

        @Override
        public void onStatusChanged(String provider, int status, Bundle extras) {
            Toast.makeText(LongLatActivity.this, "Provider status changed",
                    Toast.LENGTH_LONG).show();

        }

        @Override
        public void onProviderEnabled(String provider) {
            Toast.makeText(LongLatActivity.this,
                    "Provider disabled by the user. GPS turned off",
                    Toast.LENGTH_LONG).show();

        }

        @Override
        public void onProviderDisabled(String provider) {
            Toast.makeText(LongLatActivity.this,
                    "Provider enabled by the user. GPS turned on",
                    Toast.LENGTH_LONG).show();

        }
    }
}
