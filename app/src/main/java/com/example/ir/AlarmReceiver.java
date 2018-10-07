package com.example.ir;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.support.v4.app.NotificationCompat;
import android.widget.Toast;


/**
 * Receiver for the application
 * This class sends the notification when it receives the intent
 * */
public class AlarmReceiver extends BroadcastReceiver {

    private NotificationManager notificationManager;
    private static final int NOTIFICATION_ID = 0;

    @Override
    public void onReceive(Context context, Intent intent) {
        Toast.makeText(context, "Alarm has been received test", Toast.LENGTH_LONG).show();

        notificationManager =
                (NotificationManager)context.getSystemService(context.NOTIFICATION_SERVICE);

        //TODO: check if it received in right time
        //https://stackoverflow.com/questions/34583280/set-notification-for-specific-date-and-time
        //
        // sendNotification(context);

        Intent contentIntent = new Intent(context, MainPage.class);
        PendingIntent contentPendingIntent = PendingIntent.getActivity
                (context, NOTIFICATION_ID, contentIntent, PendingIntent.FLAG_UPDATE_CURRENT);
/*
        NotificationCompat.Builder builder =  new NotificationCompat.Builder(context, "notification")
                .setSmallIcon(R.drawable.alert)
                .setContentTitle("title")
                .setContentText("content")
                .setContentIntent(contentPendingIntent)
                .setPriority(NotificationCompat.PRIORITY_DEFAULT)
                .setAutoCancel(true)
                .setDefaults(NotificationCompat.DEFAULT_ALL);
                */
        NotificationCompat.Builder mBuilder = new NotificationCompat.Builder(context, "notification")
                .setSmallIcon(R.drawable.alert)
                .setContentTitle("My notification")
                .setContentText("Much longer text that cannot fit one line...")
                .setStyle(new NotificationCompat.BigTextStyle()
                        .bigText("Much longer text that cannot fit one line..."))
                .setPriority(NotificationCompat.PRIORITY_DEFAULT);

        //notificationManager.notify(NOTIFICATION_ID, builder.build());
        createNotificationChannel(context);
        Toast.makeText(context, "Notification sent", Toast.LENGTH_LONG).show();
    }

    private void createNotificationChannel(Context context) {
        // Create the NotificationChannel, but only on API 26+ because
        // the NotificationChannel class is new and not in the support library
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            CharSequence name = ("name");
            String description = ("description");
            int importance = NotificationManager.IMPORTANCE_DEFAULT;
            NotificationChannel channel = new NotificationChannel("channel", name, importance);
            channel.setDescription(description);
            // Register the channel with the system; you can't change the importance
            // or other notification behaviors after this
            NotificationManager notificationManager = context.getSystemService(NotificationManager.class);
            notificationManager.createNotificationChannel(channel);
        }
    }

    /**
     *
     * Creates new notification
     * @param context
     *
     */
    private void sendNotification (Context context){

        Intent contentIntent = new Intent(context, MainPage.class);
        PendingIntent contentPendingIntent = PendingIntent.getActivity
                (context, NOTIFICATION_ID, contentIntent, PendingIntent.FLAG_UPDATE_CURRENT);

        //TODO: change the content title and text
        NotificationCompat.Builder builder =  new NotificationCompat.Builder(context, "notification")
                .setSmallIcon(R.drawable.alert)
                .setContentTitle("title")
                .setContentText("content")
                .setContentIntent(contentPendingIntent)
                .setPriority(NotificationCompat.PRIORITY_DEFAULT)
                .setAutoCancel(true)
                .setDefaults(NotificationCompat.DEFAULT_ALL);



        notificationManager.notify(NOTIFICATION_ID, builder.build());
    }
}
