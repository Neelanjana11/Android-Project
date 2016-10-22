package com.neelanjana.benchmarkalgo;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.GridLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

/**
 * Created by Neelanjana on 18-Oct-16.
 */

public class Navigation extends Activity {

    private Button btnBenchmark;
    private Button btnToggle;
    private Button btnSMS;

    public void LaunchActivity(View view){
        switch (view.getId()){
            case R.id.btnBenchmark :
                startActivity(new Intent(Navigation.this,Benchmark_activity.class));
                break;
            case R.id.btnToggle:
                startActivity(new Intent(this,Toggle_activity.class));
                break;
            case R.id.btnSms:
                startActivity(new Intent(this,SMS_Activity.class));
                break;
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.navigation);
        btnBenchmark = (Button)findViewById(R.id.btnBenchmark);
        btnToggle = (Button)findViewById(R.id.btnToggle);
        btnSMS = (Button)findViewById(R.id.btnSms);
    }
}


