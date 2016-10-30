package com.neelanjana.benchmarkalgo;

import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.TaskStackBuilder;
import android.content.Context;
import android.content.Intent;
import android.net.wifi.WifiManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.app.NotificationCompat;
import android.widget.CompoundButton;
import android.widget.TextView;
import android.widget.ToggleButton;

public class ToggleWifiActivity extends AppCompatActivity {

    private ToggleButton tbWifi;
    private TextView tvWifi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_toggle_wifi_layout);
        tbWifi = (ToggleButton) findViewById(R.id.tbWifi);

        tvWifi = (TextView) findViewById(R.id.tvWifi);


        tbWifi.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean checked) {
                if (checked) {
                    tvWifi.setText("WiFi is ON");
                    WifiManager wifi = (WifiManager) getSystemService(Context.WIFI_SERVICE);
                    wifi.setWifiEnabled(true);
                } else {
                    tvWifi.setText("WiFi is OFF");
                    WifiManager wifi = (WifiManager) getSystemService(Context.WIFI_SERVICE);
                    wifi.setWifiEnabled(false);
                }
            }
        });

        if (tbWifi.isChecked()) {
            tvWifi.setText("WiFi is ON");
            WifiManager wifi = (WifiManager) getSystemService(Context.WIFI_SERVICE);
            wifi.setWifiEnabled(true);
        } else {
            tvWifi.setText("WiFi is OFF");
            WifiManager wifi = (WifiManager) getSystemService(Context.WIFI_SERVICE);
            wifi.setWifiEnabled(false);
        }
    }
}
