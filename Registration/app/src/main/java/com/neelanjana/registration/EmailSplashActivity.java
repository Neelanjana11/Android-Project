package com.neelanjana.registration;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

public class EmailSplashActivity extends AppCompatActivity {
    private ImageView ivEmail;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_email_splash_layout);

        ivEmail = (ImageView) findViewById(R.id.ivEmail);

        new Handler().postDelayed(new Runnable() {
            public void run() {
                Animation animation = AnimationUtils.loadAnimation(getBaseContext(), R.anim.shake);
                ivEmail.startAnimation(animation);
                startActivity(new Intent(getBaseContext(), LoginActivity.class));
                finish();
            }
        }, 5000);
    }
}
