package com.neelanjana.imageapplication;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.ColorMatrix;
import android.graphics.ColorMatrixColorFilter;
import android.graphics.Paint;
import android.net.Uri;
import android.os.Build;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import java.io.File;

public class ImageEditingActivity extends AppCompatActivity {

    private ImageView ivTemp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.image_editing_layout);

        ivTemp = (ImageView) findViewById(R.id.ivTemp);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        Intent intent;

        switch (item.getItemId()) {
            case R.id.menuGallery:
                intent = new Intent(Intent.ACTION_PICK, android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
                startActivityForResult(intent, 0);
                return true;
            case R.id.menuCamera:
                Toast.makeText(getApplicationContext(), "Camera mode Selected", Toast.LENGTH_SHORT).show();
                intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                File f = new File(android.os.Environment.getExternalStorageDirectory(), "temp.jpg");
                intent.putExtra(MediaStore.EXTRA_OUTPUT, Uri.fromFile(f));
                startActivityForResult(intent, 1);
                return true;
            default:
                return super.onOptionsItemSelected(item);

        }
    }


    public static Bitmap loadBitmapFromView(View v) {
        Bitmap b = Bitmap.createBitmap( v.getLayoutParams().width, v.getLayoutParams().height, Bitmap.Config.ARGB_8888);
        Canvas c = new Canvas(b);
        v.layout(0, 0, v.getLayoutParams().width, v.getLayoutParams().height);
        v.draw(c);
        return b;
    }

    private Bitmap toGrayScale(Bitmap originalImage) {
        int width, height;
        height = originalImage.getHeight();
        width = originalImage.getWidth();

        Bitmap bmpGrayscale = Bitmap.createBitmap(width, height, Bitmap.Config.RGB_565);
        Canvas c = new Canvas(bmpGrayscale);
        Paint paint = new Paint();
        ColorMatrix cm = new ColorMatrix();
        cm.setSaturation(0);
        ColorMatrixColorFilter f = new ColorMatrixColorFilter(cm);
        paint.setColorFilter(f);
        c.drawBitmap(originalImage, 0, 0, paint);
        return bmpGrayscale;
    }

    public void doImageProcessing(View view){
        switch (view.getId()){
            case R.id.button:

                //Bitmap bmp = loadBitmapFromView(ivResult);
                // Bitmap res = toGrayScale(bmp);

                Intent intent = new Intent(Intent.ACTION_PICK, android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
                startActivityForResult(intent, 0);


                if(Build.VERSION.SDK_INT <= Build.VERSION_CODES.KITKAT){
                    ivTemp.setDrawingCacheEnabled(true);
                    ivTemp.measure(
                            View.MeasureSpec.makeMeasureSpec(0, View.MeasureSpec.UNSPECIFIED),
                            View.MeasureSpec.makeMeasureSpec(0, View.MeasureSpec.UNSPECIFIED));
                    ivTemp.layout(0, 0, ivTemp.getMeasuredWidth(), ivTemp.getMeasuredHeight());

                    ivTemp.buildDrawingCache(true);


                    Bitmap originalImage = Bitmap.createBitmap(ivTemp.getDrawingCache());
                    ivTemp.setDrawingCacheEnabled(false);

                    Bitmap grayImage = toGrayScale(originalImage);
                    ivTemp.setImageBitmap(grayImage);
                }




                break;


        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode==0 && resultCode==RESULT_OK){
            Uri uri = data.getData();
            ivTemp.setImageURI(uri);
        }
    }
}
