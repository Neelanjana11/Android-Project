package com.neelanjana.benchmarkalgo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class SMS_Activity extends AppCompatActivity {

    private EditText mobileNo,msg;
    private Button sendSms;

    protected void sendSMSMessage() {
        Log.i("Send SMS", "");
        String phoneNo = mobileNo.getText().toString();
        String message = msg.getText().toString();

        try {
            SmsManager smsManager = SmsManager.getDefault();
            smsManager.sendTextMessage(phoneNo, null, message, null, null);
            Toast.makeText(getApplicationContext(), "SMS sent.", Toast.LENGTH_LONG).show();
        }

        catch (Exception e) {
            Toast.makeText(getApplicationContext(), "SMS failed, please try again.", Toast.LENGTH_LONG).show();
            e.printStackTrace();
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sms_layout);

        mobileNo = (EditText)findViewById(R.id.etNumber);
        msg = (EditText)findViewById(R.id.etText);
        sendSms = (Button) findViewById(R.id.btnSms);

        sendSms.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                sendSMSMessage();
            }
        });
    }
}
