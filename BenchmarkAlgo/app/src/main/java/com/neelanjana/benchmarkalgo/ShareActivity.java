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


        Bitmap bm = null;
        Intent sharingIntent = new Intent(Intent.ACTION_CHOOSER);

        sharingIntent.setType("image/*");
        startActivity(Intent.createChooser(sharingIntent, "Share images to.."));
        Uri uri = sharingIntent.getData();

        sharingIntent.putExtra(Intent.EXTRA_STREAM, uri);
    //    image = sharingIntent.getStringExtra("image");
        startActivity(new Intent(this,ViewImageActivity.class));
        //   ivImage.setVisibility(View.VISIBLE);
            Uri imgUri = sharingIntent.getParcelableExtra(Intent.EXTRA_STREAM);
        //    ivImage.setImageURI(imgUri);
   //     ViewImageActivity.startActivity(image,imgUri);
    }


}


