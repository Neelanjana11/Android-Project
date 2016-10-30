package com.neelanjana.benchmarkalgo;

import android.app.Activity;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.app.NotificationCompat;
import android.view.Menu;
import android.view.View;
import android.widget.Button;

public class NotificationMainActivity extends Activity {

    NotificationManager notificationManager;
    static int notificationID = 100;

    private Button btnClick;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notification_main_layout);

        btnClick = (Button) findViewById(R.id.btnClick);
        btnClick.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                displayMyNotification();
            }
        });

    }

    // This method shows notification
    public void displayMyNotification() {
        NotificationCompat.Builder builder = new NotificationCompat.Builder(
                getApplicationContext());

        // set main title
        builder.setContentTitle("Demo Test");

        // set notification text
        builder.setContentText("You have received a message");

        // set Sticker for alert message
        builder.setTicker("New Message Alert!");

        // set icon
        builder.setSmallIcon(R.drawable.icon);
        // Use default sound for notification
        builder.setDefaults(Notification.DEFAULT_SOUND);

        notificationManager = (NotificationManager) getSystemService(getApplicationContext().NOTIFICATION_SERVICE);

        // A PendingIntent specifies an action to take in the
        // future
        PendingIntent myIntent = PendingIntent.getActivity(this, 0, new Intent(  this, NotificationActivity.class), 0);

        // on notification click open myIntent
        builder.setContentIntent(myIntent);

     /* Update the existing notification using same notification ID */
        notificationManager.notify(notificationID, builder.build());

    }
}
