package com.neelanjana.registration;

import android.graphics.Color;
import android.support.v4.app.FragmentActivity;
import android.os.Bundle;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.Circle;
import com.google.android.gms.maps.model.CircleOptions;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.maps.model.Polygon;
import com.google.android.gms.maps.model.PolygonOptions;

import java.util.Arrays;
import java.util.List;

public class GoogleMapsActivity extends FragmentActivity implements OnMapReadyCallback{

    private GoogleMap mMap;
    Circle shape;
    Polygon poly;
 //   private Circle circle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_google_maps_layout);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
//        mMap.setOnMapClickListener(this);
//        mMap.setOnMapLongClickListener(this);
 //       drawCircle(new LatLng(-33.87365,151.20689));

    }


    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera. In this case,
     * we just add a marker near Sydney, Australia.
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     */
    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;

        // Add a marker in Sydney and move the camera
        LatLng sydney = new LatLng(12.900, 77.59);
        mMap.addMarker(new MarkerOptions().position(sydney).title("Marker in Sydney"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(sydney));

        LatLng s = new LatLng(12.9716, 77.5946);

        CircleOptions options = new CircleOptions();
        options.center(s);
        options.fillColor(0x44ff0000);
        options.strokeColor(Color.RED);
        options.strokeWidth( 10 ).radius(10000);
        shape = mMap.addCircle(options);

        LatLng lat = new LatLng(22.7244,88.3288);
        MarkerOptions marker=new MarkerOptions(); marker.position(lat);
             mMap.addMarker(marker);

 /*       LatLng latLng = new LatLng(22.5726,88.3639);
        PolygonOptions options1 = new PolygonOptions();
        options1.add(new LatLng(22.4726,88.3639),
                new LatLng(22.5726,88.3639),
                new LatLng(22.5726,88.3639),
                new LatLng(22.4726,88.3639),
                new LatLng(22.4726,88.36));
        options1.fillColor(0x44ff0000);
        options1.strokeColor(Color.BLUE);
        options1.strokeWidth( 10 );
        poly = mMap.addPolygon(options1);*/

        mMap.addPolygon(new PolygonOptions()
                .addAll(createRectangle(new LatLng(22.4726,88.3639), 10, 7))
                .fillColor(Color.WHITE)
                .strokeColor(Color.RED));
    }

    private List<LatLng> createRectangle(LatLng center, double halfWidth, double halfHeight) {
        return Arrays.asList(new LatLng(center.latitude - halfHeight, center.longitude - halfWidth),
                new LatLng(center.latitude - halfHeight, center.longitude + halfWidth),
                new LatLng(center.latitude + halfHeight, center.longitude + halfWidth),
                new LatLng(center.latitude + halfHeight, center.longitude - halfWidth),
                new LatLng(center.latitude - halfHeight, center.longitude - halfWidth));
    }




//    public void drawCircle(LatLng latLng) {
   //    //add circle

  //  }


}










