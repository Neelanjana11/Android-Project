package com.neelanjana.registration;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Html;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.HashMap;

public class MainActivity extends AppCompatActivity {

    //   SharedPreferences sharedPreferences;
    private TextView tvName;
    private TextView tvEmail;
    private Button btnEdit;
    private RelativeLayout rlMain;
    private Button btnPswd;
    SessionManager session;
    SharedPreferences sharedPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_layout);

        rlMain = (RelativeLayout) findViewById(R.id.rlMain);
        rlMain.setBackgroundResource(R.drawable.background1);

        sharedPreferences = getSharedPreferences("Reg", MODE_PRIVATE);
        String name = sharedPreferences.getString(RegistrationActivity.FName, null);
        session = new SessionManager(getApplicationContext());

        tvName = (TextView) findViewById(R.id.tvName);

        if (session.isLoggedIn() == false) {
            HashMap<String, String> user = session.getUserDetails();
            // email
            String email = user.get(SessionManager.KEY_EMAIL);
            Intent intent = new Intent(this, RegistrationActivity.class);
            startActivity(intent);
            finish();
        } else {
            tvName.setText(name);
        }

        btnEdit = (Button) findViewById(R.id.btnEdit);
        btnEdit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getBaseContext(), RegistrationActivity.class);
                startActivity(intent);
                finish();
            }
        });

        btnPswd = (Button) findViewById(R.id.btnPswd);
        btnPswd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getBaseContext(), ChangePswdActivity.class);
                startActivity(intent);
                finish();
            }
        });
    }
}


