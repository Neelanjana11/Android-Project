package com.neelanjana.benchmarkalgo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

public class A1 extends AppCompatActivity {

    private TextView tvText;

    public void getUsername(View view){
        Intent intent = new Intent(getBaseContext(),A2.class);
        startActivityForResult(intent,100);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent intent) {
        if(requestCode == 100 && resultCode == RESULT_OK){
            String name = intent.getStringExtra("username");
            tvText.setText(name);
            Log.i(" "," " +requestCode + " " + resultCode + " " + intent.getStringExtra("username"));
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_a1_layout);

        tvText = (TextView) findViewById(R.id.tvText);
    }
}
