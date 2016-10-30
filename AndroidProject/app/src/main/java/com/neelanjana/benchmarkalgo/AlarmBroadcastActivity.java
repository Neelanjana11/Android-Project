package com.neelanjana.benchmarkalgo;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

public class AlarmBroadcastActivity extends BroadcastReceiver {

    MediaPlayer mp;
    @Override
    public void onReceive(Context context, Intent intent) {
        mp=MediaPlayer.create(context, R.raw.ring);
        mp.start();
        Toast.makeText(context, "Alarm....", Toast.LENGTH_LONG).show();
    }
}
