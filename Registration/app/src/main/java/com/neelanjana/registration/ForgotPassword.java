package com.neelanjana.registration;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.Toast;

import java.util.Random;

import static com.neelanjana.registration.RegistrationActivity.Password;

public class ForgotPassword extends AppCompatActivity {

    Button btnSubmit;
    EditText etEmail;
    String email;
    String fEmail;
    private RelativeLayout rlForgot;
    public SharedPreferences sharedPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forgot_password);

        rlForgot = (RelativeLayout) findViewById(R.id.rlForgot);
        rlForgot.setBackgroundResource(R.drawable.background);

        sharedPreferences = getSharedPreferences("Reg",MODE_PRIVATE);

        etEmail = (EditText)findViewById(R.id.etEmail);
        btnSubmit = (Button) findViewById(R.id.btnSubmit);

        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {
                email = etEmail.getText().toString();
                fEmail = sharedPreferences.getString(RegistrationActivity.Email,null);
                // Validate if username, password is filled
                if(email.length()>0 && email.equals(fEmail)){
                        Toast.makeText(getApplicationContext(), "Logged in", Toast.LENGTH_LONG).show();
                        Intent i = new  Intent(getApplicationContext(),LoginActivity.class);
                        startActivity(i);
                            mailSend();
                }else{
                    // user didn't entered username or password
                    Toast.makeText(getApplicationContext(),"Please enter Email id",Toast.LENGTH_LONG).show();
                }

            }
        });

    }

    public void mailSend(){
        Random generator = new Random();
        String randomString = new String();
        char tempChar;
        for (int i = 0; i < 7; i++){
            tempChar = (char) (generator.nextInt(96) + 32);
            randomString = randomString + "" + tempChar;
        }

        try {
            String to = etEmail.getText().toString();
            String subject = "Password";
            String message = "Your password is : " + randomString;
            SendMailActivity sm1 = new SendMailActivity(this, to, subject, message);
            sm1.execute();

            SharedPreferences.Editor editor = sharedPreferences.edit();
            editor.putString(RegistrationActivity.Password,randomString);
            editor.commit();

        } catch (Exception e) {
            Toast.makeText(getBaseContext(), "Email sending failed", Toast.LENGTH_SHORT).show();
        }
    }
}
