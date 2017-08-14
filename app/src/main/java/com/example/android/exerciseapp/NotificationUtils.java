package com.example.android.exerciseapp;


import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.v4.app.NotificationBuilderWithBuilderAccessor;
import android.support.v4.app.NotificationCompat;
import android.support.v4.content.ContextCompat;

public class NotificationUtils {

    private static final int PENDING_INTENT_ID = 39999;
    private static final int NOTIFICATION_ID = 88122677;

    public static PendingIntent contentIntent(Context context) {

        Intent intent = new Intent(context, MainActivity.class);

        PendingIntent pendingIntent = PendingIntent.getActivity(context,
                PENDING_INTENT_ID,
                intent,
                PendingIntent.FLAG_UPDATE_CURRENT
        );

        return pendingIntent;
    }


    private static Bitmap largeIcon(Context context) {

        Resources res = context.getResources();

        Bitmap bitmap = BitmapFactory.decodeResource(res, R.drawable.ic_local_drink_black_24px);

        return bitmap;

    }

    public static void remindUser(Context context){
        NotificationCompat.Builder builder = new NotificationCompat.Builder(context)
                .setColor(ContextCompat.getColor(context, R.color.colorPrimary))
                .setSmallIcon(R.drawable.ic_drink_notification)
                .setLargeIcon(largeIcon(context))
                .setContentTitle("Notification Test")
                .setContentText("Consistent!!Juechen!!!")
                .setStyle(new NotificationCompat.BigTextStyle().bigText("Consistent!!Juechen!!!"))
                .setDefaults(Notification.DEFAULT_VIBRATE)
                .setContentIntent(contentIntent(context))
                .setAutoCancel(true);

        builder.setPriority(Notification.PRIORITY_HIGH);

        NotificationManager notificationManager = (NotificationManager) context.getSystemService(Context.NOTIFICATION_SERVICE);

        notificationManager.notify(NOTIFICATION_ID, builder.build());

    }


}
