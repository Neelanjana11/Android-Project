package com.neelanjana.benchmarkalgo;

import android.media.AudioManager;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.io.IOException;

public class OnlineAudioActivity extends AppCompatActivity {

    MediaPlayer mPlayer;
    Button btnPlay;
    Button btnStop;
    String url = "http://sound30.mp3slash.net/indian/msdhoni/01%20-%20Besabriyaan%20(MS%20Dhoni)%20[Songspk.GURU].mp3";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_online_audio_layout);

        btnPlay = (Button) findViewById(R.id.btnPlay);
        btnStop = (Button) findViewById(R.id.btnStop);
        btnPlay.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                mPlayer = new MediaPlayer();
                mPlayer.setAudioStreamType(AudioManager.STREAM_MUSIC);
                try {
                    mPlayer.setDataSource(url);
                } catch (IllegalArgumentException e) {
                    Toast.makeText(getApplicationContext(), "You might not set the URI correctly!", Toast.LENGTH_LONG).show();
                } catch (SecurityException e) {
                    Toast.makeText(getApplicationContext(), "You might not set the URI correctly!", Toast.LENGTH_LONG).show();
                } catch (IllegalStateException e) {
                    Toast.makeText(getApplicationContext(), "You might not set the URI correctly!", Toast.LENGTH_LONG).show();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                try {
                    mPlayer.prepare();
                } catch (IllegalStateException e) {
                    Toast.makeText(getApplicationContext(), "You might not set the URI correctly!", Toast.LENGTH_LONG).show();
                } catch (IOException e) {
                    Toast.makeText(getApplicationContext(), "You might not set the URI correctly!", Toast.LENGTH_LONG).show();
                }
                mPlayer.start();
            }
        });
        btnStop.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                // TODO Auto-generated method stub
                if(mPlayer!=null && mPlayer.isPlaying()){
                    mPlayer.stop();
                }
            }
        });
    }

}
