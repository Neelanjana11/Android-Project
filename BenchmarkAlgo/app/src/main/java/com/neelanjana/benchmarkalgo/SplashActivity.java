package com.neelanjana.benchmarkalgo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.os.Handler;

public class SplashActivity extends AppCompatActivity {

    private static int secondsDelayed = 3000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_layout);
            new Handler().postDelayed(new Runnable() {
                public void run() {
                    startActivity(new Intent(getBaseContext(), Navigation.class));
                    finish();
                }
            }, secondsDelayed);
    }
}
