package com.neelanjana.benchmarkalgo;

import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;

public class ViewImageActivity extends AppCompatActivity {
    private static ImageView ivImage;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_image_layout);
        ivImage = new ImageView(this);
   //     ivImage = (ImageView) findViewById(R.id.ivImage);
    }

    public static void startActivity(String image, Uri uri){
        ivImage.setImageURI(uri);

    }
}
