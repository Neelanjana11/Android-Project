package com.neelanjana.benchmarkalgo;

import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

public class Lifecycle_Activity extends Activity{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.i("Created","Activity Created");
        Toast.makeText(getApplicationContext(), "Activity Created", Toast.LENGTH_LONG).show();
    }

    @Override
    protected void onStart() {
        super.onStart();
        // The activity is about to become visible.
        Log.i("Started","Activity Started");
        Toast.makeText(getApplicationContext(), "Activity Started", Toast.LENGTH_LONG).show();
    }
    @Override
    protected void onResume() {
        super.onResume();
        // The activity has become visible (it is now "resumed").
        Log.i("Resumed","Activity Resumed");
        Toast.makeText(getApplicationContext(), "Activity Resumed", Toast.LENGTH_LONG).show();
    }
    @Override
    protected void onPause() {
        super.onPause();
        // Another activity is taking focus (this activity is about to be "paused").
        Log.i("Paused","Activity Paused");
        Toast.makeText(getApplicationContext(), "Activity Paused", Toast.LENGTH_LONG).show();
    }
    @Override
    protected void onStop() {
        super.onStop();
        // The activity is no longer visible (it is now "stopped")
        Log.i("Stopped","Activity Stopped");
        Toast.makeText(getApplicationContext(), "Activity Stopped", Toast.LENGTH_LONG).show();
    }
    @Override
    protected void onDestroy() {
        super.onDestroy();
        // The activity is about to be destroyed.
        Log.i("Destroyed","Activity Destroyed");
        Toast.makeText(getApplicationContext(), "Activity Destroyed", Toast.LENGTH_LONG).show();

    }
}
