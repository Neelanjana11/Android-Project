package com.neelanjana.registration;

import android.content.pm.PackageManager;
import android.location.Location;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapFragment;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.Circle;
import com.google.android.gms.maps.model.CircleOptions;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

public class MarkGoogleMapActivity extends AppCompatActivity {

    private Circle mCircle;
    private Marker mMarker;
    private GoogleMap mGoogleMap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mark_google_map);
        MapFragment mapFragment = (MapFragment) getFragmentManager()
                .findFragmentById(R.id.mapFragment);


        //      mGoogleMap.setMyLocationEnabled(true);

    }



    private void setUpMap() {
    }

    private void updateMarkerWithCircle(LatLng position) {
        mCircle.setCenter(position);
        mMarker.setPosition(position);
    }

    private void drawMarkerWithCircle(LatLng position){
        double radiusInMeters = 100.0;
        int strokeColor = 0xffff0000; //red outline
        int shadeColor = 0x44ff0000; //opaque red fill

        CircleOptions circleOptions = new CircleOptions().center(position).radius(radiusInMeters).fillColor(shadeColor).strokeColor(strokeColor).strokeWidth(8);
        mCircle = mGoogleMap.addCircle(circleOptions);

        MarkerOptions markerOptions = new MarkerOptions().position(position);
        mMarker = mGoogleMap.addMarker(markerOptions);
    }
}
