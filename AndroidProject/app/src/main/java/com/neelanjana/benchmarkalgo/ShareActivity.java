package com.neelanjana.benchmarkalgo;

import android.content.Context;
import android.content.Intent;
import android.annotation.TargetApi;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Build;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.style.URLSpan;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import java.io.IOException;


public class ShareActivity extends AppCompatActivity {
    private ImageView image;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_share_layout);

        image = (ImageView)findViewById(R.id.ivImage);

        Intent sharingIntent = getIntent();

        String action = sharingIntent.getAction();
        String type = sharingIntent.getType();

        if(Intent.ACTION_SEND.equals(action) && (type!=null)){
            if(type.startsWith("image/*")){
                Uri imgUri = sharingIntent.getParcelableExtra(Intent.EXTRA_STREAM);
                if(imgUri!=null) {
                    image.setImageURI(imgUri);
                }
            }
        }
    }


}


