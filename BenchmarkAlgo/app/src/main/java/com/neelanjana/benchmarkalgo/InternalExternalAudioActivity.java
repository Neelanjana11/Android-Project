package com.neelanjana.benchmarkalgo;

import android.media.MediaPlayer;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class InternalExternalAudioActivity extends AppCompatActivity {

    private Button btnStart;
    private Button btnStop;
    private Button btnPause;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_internal_external_audio_layout);
        btnStart=(Button)findViewById(R.id.btnStart);
        btnPause=(Button)findViewById(R.id.btnPause);
        btnStop=(Button)findViewById(R.id.btnStop);
        //creating media player
        final MediaPlayer mp=new MediaPlayer();
        try{
            mp.setDataSource("/Music/song.mp3");

            mp.prepare();
        }catch(Exception e){e.printStackTrace();}

        btnStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mp.start();
            }
        });
        btnPause.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mp.pause();
            }
        });
        btnStop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mp.stop();
            }
        });
    }



}
