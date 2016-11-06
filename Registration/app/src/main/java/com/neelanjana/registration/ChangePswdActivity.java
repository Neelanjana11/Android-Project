package com.neelanjana.registration;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

public class ChangePswdActivity extends AppCompatActivity {

    private EditText etPswd;
    private EditText etChngPswd;
    private RelativeLayout rlChngPswd;
    private Button btnPswd;
    String pswd;
    String chngPswd;
    public SharedPreferences sharedPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_change_pswd_layout);

        rlChngPswd = (RelativeLayout) findViewById(R.id.rlChngPswd);
        rlChngPswd.setBackgroundResource(R.drawable.background);

        etPswd = (EditText) findViewById(R.id.etPswd);
        etChngPswd = (EditText) findViewById(R.id.etChngPswd);

        sharedPreferences = getSharedPreferences("Reg",MODE_PRIVATE);

        btnPswd = (Button) findViewById(R.id.btnPswd);
        btnPswd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                pswd = etPswd.getText().toString();
                chngPswd = etChngPswd.getText().toString();
                try {
                    if (pswd.length() == 0) {
                        etPswd.setError("Enter the password");
                    } else if (chngPswd.length() == 0) {
                        etChngPswd.setError("Re-enter the Password");
                    } else if (pswd.length() < 6) {
                        etPswd.setError("Enter a password of at least 6 characters");
                    } else if (pswd.equals(chngPswd) == false) {
                        etChngPswd.setError("Enter the correct password");
                    } else {
                        SharedPreferences.Editor editor = sharedPreferences.edit();
                        editor.putString(RegistrationActivity.Password, pswd);
                        editor.commit();

                        Intent intent = new Intent(getBaseContext(), LoginActivity.class);
                        startActivity(intent);
                        finish();
                    }
                }catch (Exception e){
                    Toast.makeText(getBaseContext(),"Enter the password coreectly",Toast.LENGTH_SHORT);
                }
            }
        });

    }
}
