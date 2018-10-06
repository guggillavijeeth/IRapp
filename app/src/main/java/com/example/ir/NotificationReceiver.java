package com.example.ir;

import android.content.BroadcastReceiver;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.support.v4.app.NotificationCompat;



/**
 * Created by seoyeon on 10/6/18.
 */

public class NotificationReceiver extends BroadcastReceiver{

    private NotificationManager notificationManager;
    private static int notificationID = 0;
    private static final String PRIMARY_CHANNEL_ID =
            "primary_notification_channel";
    @Override
    public void onReceive(Context context, Intent intent) {
        notificationManager = (NotificationManager)
                context.getSystemService(Context.NOTIFICATION_SERVICE);

        // Deliver the notification.
        deliverNotification(context);
    }

    private void deliverNotification(Context context) {
        Intent contentIntent = new Intent(context, MainPage.class);
        PendingIntent contentPendingIntent = PendingIntent.getActivity
                (context, notificationID, contentIntent, PendingIntent.FLAG_UPDATE_CURRENT);

        NotificationCompat.Builder builder =  new NotificationCompat.Builder(context, PRIMARY_CHANNEL_ID)
                .setSmallIcon(R.drawable.alert)
                .setContentTitle("title")
                .setContentText("content")
                .setContentIntent(contentPendingIntent)
                .setPriority(NotificationCompat.PRIORITY_DEFAULT)
                .setAutoCancel(true)
                .setDefaults(NotificationCompat.DEFAULT_ALL);
    }


    // Deliver the notification
    //((NotificationManager)notificationManager).notify(notificationID, builder.build());
}
