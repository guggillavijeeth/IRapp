package com.example.ir;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.support.v4.app.NotificationCompat;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.widget.CompoundButton;
import android.widget.ToggleButton;
import android.widget.Toast;
import android.app.AlarmManager;


public class MainPage extends AppCompatActivity {

    private static int notificationID = 0;
    private static final String PRIMARY_CHANNEL_ID =
            "primary_notification_channel";
    private NotificationManager notificationManager;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_page);

        // Create notification
        notificationManager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);

        // Set up the Notification Broadcast Intent.
        Intent alarmIntent = new Intent(this, NotificationReceiver.class);

        // Set ToggleButton for turning the alarm on/off
        ToggleButton alarmToggle = findViewById(R.id.alarmToggle);

        boolean alarmUp = (PendingIntent.getBroadcast(this, notificationID,
                alarmIntent, PendingIntent.FLAG_NO_CREATE) != null);

        alarmToggle.setChecked(alarmUp);
/*
        final PendingIntent notifyPendingIntent = PendingIntent.getBroadcast
                (this, notificationID, alarmIntent,
                        PendingIntent.FLAG_UPDATE_CURRENT);

*/

        alarmToggle.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                String message;
                if (isChecked){
                    message = getString(R.string.ToggleOn);
                }else {
                    message = getString(R.string.toggleOff);
                }

                Toast.makeText(MainPage.this, message,Toast.LENGTH_SHORT)
                        .show();
            }
        });

        createNotificationChannel();

    }

    /**
     * Create Notification Channel for Android 8.0 or higher
     * */
    public void createNotificationChannel (){
        notificationManager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);

        // Check the version of Android
        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.O) {
            NotificationChannel notificationChannel = new NotificationChannel
                    (PRIMARY_CHANNEL_ID, "notification", NotificationManager.IMPORTANCE_DEFAULT);

            notificationManager.createNotificationChannel(notificationChannel);
        }
    }



}


