package com.neelanjana.benchmarkalgo;


import android.app.Activity;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.TaskStackBuilder;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Icon;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.app.NotificationCompat;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.gms.appindexing.Action;
import com.google.android.gms.appindexing.AppIndex;
import com.google.android.gms.appindexing.Thing;
import com.google.android.gms.common.api.GoogleApiClient;

import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

public class NotificationActivity extends Activity {

    private Button btnNotification;

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notification_layout);
        btnNotification = (Button) findViewById(R.id.btnNotification);
    }

    public class CreateNotificationActivity extends Activity {
        /**
         * ATTENTION: This was auto-generated to implement the App Indexing API.
         * See https://g.co/AppIndexing/AndroidStudio for more information.
         */
        private GoogleApiClient client;

        @Override
        public void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_notification_layout);
            // ATTENTION: This was auto-generated to implement
            // the App Indexing API.
            // See https://g.co/AppIndexing/AndroidStudio for more information.
            client = new GoogleApiClient.Builder(this).addApi(AppIndex.API).build();
        }

        public void createNotification() {
            // Prepare intent which is triggered if the
            // notification is selected
            Intent intent = new Intent(this, Navigation.class);
            PendingIntent pIntent = PendingIntent.getActivity(this, (int) System.currentTimeMillis(), intent, 0);

            // Build notification
            // Actions are just fake
            Notification.Builder noti = new Notification.Builder(this)
                    .setContentTitle("New mail from " + "test@gmail.com")
                    .setContentText("Subject")
                    .setSmallIcon(R.drawable.durga);
            NotificationManager notificationManager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
            // hide the notification after its selected
            //   noti.flags |= Notification.FLAG_AUTO_CANCEL;
            //     notificationManager.notify(0, noti.build());

        }
    }
}