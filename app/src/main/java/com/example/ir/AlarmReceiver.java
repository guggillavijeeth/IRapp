package com.example.ir;

/**
 * Receiver for the application
 * This class sends the notification when it receives the intent
 * */
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.support.v4.app.NotificationCompat;

/**
 * Broadcast receiver for the alarm, which delivers the notification.
 */
public class AlarmReceiver extends BroadcastReceiver {

    private NotificationManager notificationManager;
    // Notification ID.
    private static final int NOTIFICATION_ID = 0;
    // Notification channel ID.
    private static final String CHANNELL_ID =
            "notification_channel";


    @Override
    public void onReceive(Context context, Intent intent) {
        notificationManager = (NotificationManager) context.getSystemService(Context.NOTIFICATION_SERVICE);
        // send notification
        sendNotification(context);
    }

    /**
     * Builds and delivers the notification.
     *
     * @param context, activity context.
     */
    private void sendNotification(Context context) {
        Intent contentIntent = new Intent(context, MainPage.class);

        PendingIntent contentPendingIntent = PendingIntent.getActivity
                (context, NOTIFICATION_ID, contentIntent, PendingIntent
                        .FLAG_UPDATE_CURRENT);
        // Build the notification
        NotificationCompat.Builder builder = new NotificationCompat.Builder
                (context, CHANNELL_ID)
                .setSmallIcon(R.drawable.ic_priority_high_black_24dp)
                .setContentTitle("title")
                .setContentText("text")
                .setContentIntent(contentPendingIntent)
                .setPriority(NotificationCompat.PRIORITY_DEFAULT)
                .setAutoCancel(true)
                .setDefaults(NotificationCompat.DEFAULT_ALL);

        // Notify the notification
        notificationManager.notify(NOTIFICATION_ID, builder.build());
    }
}