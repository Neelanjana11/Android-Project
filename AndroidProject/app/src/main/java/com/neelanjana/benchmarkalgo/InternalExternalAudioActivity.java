package com.neelanjana.benchmarkalgo;

import android.media.MediaPlayer;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;

public class InternalExternalAudioActivity extends AppCompatActivity {

    private Button btnStart;
    private Button btnStop;
    private Button btnPause;

    final String MEDIA_PATH = Environment.getExternalStorageDirectory().getPath() + "/";
    private ArrayList<HashMap<String, String>> songsList = new ArrayList<HashMap<String, String>>();
    private String mp3Pattern = ".mp3";
    // Constructor
    public InternalExternalAudioActivity(){

    }

    /**
     * Function to read all mp3 files from sdcard
     * and store the details in ArrayList
     * */
    public ArrayList<HashMap<String, String>> getPlayList(View view){
        System.out.println(MEDIA_PATH);
        if (MEDIA_PATH != null) {
            File home = new File(MEDIA_PATH);
            File[] listFiles = home.listFiles();
            if (listFiles != null && listFiles.length > 0) {
                for (File file : listFiles) {
                    System.out.println(file.getAbsolutePath());
                    if (file.isDirectory()) {
                        scanDirectory(file);
                    } else {
                        addSongToList(file);
                    }
                }
            }
        }
        // return songs list array
        return songsList;
    }

    private void scanDirectory(File directory) {
        if (directory != null) {
            File[] listFiles = directory.listFiles();
            if (listFiles != null && listFiles.length > 0) {
                for (File file : listFiles) {
                    if (file.isDirectory()) {
                        scanDirectory(file);
                    } else {
                        addSongToList(file);
                    }

                }
            }
        }
    }

    private void addSongToList(File song) {
        if (song.getName().endsWith(mp3Pattern)) {
            HashMap<String, String> songMap = new HashMap<String,String>();
            songMap.put("songTitle",
                    song.getName().substring(0, (song.getName().length() - 4)));
            songMap.put("songPath", song.getPath());

            // Adding each song to SongList
            songsList.add(songMap);
        }
    }

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

            mp.prepare();
        }catch(Exception e){e.printStackTrace();}


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
