package com.neelanjana.registration;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {

 //   private static final String PREFER_NAME = "Reg";
    private Button btnLogin;
    private Button btnForgot;
    private EditText etMail;
    private EditText etPswd;
    private RelativeLayout rlLogin;
    String email;
    String password;
    SharedPreferences sharedPreferences;
    String uEmail = null;
    String uPassword = null;
    public static final String IEmail = "EMAIL";
    public static final String IPswd = "PSWD";
    SessionManager session;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_layout);

        sharedPreferences = getSharedPreferences("Reg",MODE_PRIVATE);
        session = new SessionManager(getApplicationContext());

        etMail = (EditText) findViewById(R.id.etMail);
        etPswd = (EditText) findViewById(R.id.etPswd);
        rlLogin = (RelativeLayout) findViewById(R.id.rlLogin);
        rlLogin.setBackgroundResource(R.drawable.background);

        btnLogin = (Button) findViewById(R.id.btnLogin);
        btnForgot = (Button) findViewById(R.id.btnForgot);
        uEmail = sharedPreferences.getString(RegistrationActivity.Email, null);
        uPassword = sharedPreferences.getString(RegistrationActivity.Password, null);

            btnLogin.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    email = etMail.getText().toString();
                    password = etPswd.getText().toString();

                    SharedPreferences.Editor editor = sharedPreferences.edit();
                    editor.putString(IEmail, email);
                    editor.putString(IPswd, password);
                    editor.commit();

                    if (email.trim().length() > 0 && password.trim().length() > 0) {
                        if (email.equals(uEmail) && password.equals(uPassword)) {
                            session.createLoginSession(uEmail,uPassword);
                            Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                            startActivity(intent);
                            finish();
                        } else
                            Toast.makeText(getApplicationContext(), "Please enter correct username and password", Toast.LENGTH_LONG).show();
                    } else {
                        // user didn't entered username or password
                        Toast.makeText(getApplicationContext(), "Please enter username and password", Toast.LENGTH_LONG).show();
                    }
                }
            });

        btnForgot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(), ForgotPassword.class);
                startActivity(i);
            }
        });
    }
}
