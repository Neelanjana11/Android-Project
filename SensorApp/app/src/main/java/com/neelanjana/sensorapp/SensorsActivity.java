package com.neelanjana.sensorapp;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import java.util.List;

public class SensorsActivity extends AppCompatActivity {

    private SensorManager mSensorManager;
    private TextView tvSensor;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sensors_layout);
        tvSensor = (TextView) findViewById(R.id.tvSensor);
        mSensorManager = (SensorManager) getSystemService(Context.SENSOR_SERVICE);
        List<Sensor> deviceSensors = mSensorManager.getSensorList(Sensor.TYPE_ALL);
        StringBuilder sensorInfo = new StringBuilder();
        for(Sensor sensor : deviceSensors){
            sensorInfo.append("\n" + sensor.getName() + " " + sensor.getType() + " " + sensor.getVendor());
        }
        tvSensor.setText(sensorInfo.toString());
    }
}
