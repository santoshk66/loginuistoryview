package com.groupsale.Lootlo.ui.Services;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;

import androidx.annotation.NonNull;
import androidx.core.app.NotificationCompat;

import com.google.firebase.messaging.FirebaseMessagingService;
import com.google.firebase.messaging.RemoteMessage;
import com.groupsale.Lootlo.Notification;
import com.groupsale.Lootlo.R;

public class MyFcmMessagingService extends FirebaseMessagingService {

    public MyFcmMessagingService() {

    }

    @Override
    public void onMessageReceived(@NonNull RemoteMessage remoteMessage) {
        String key = remoteMessage.getData().get("key");
        Intent intent = new Intent(this, Notification.class);
        intent.setData(Uri.parse(key));
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        PendingIntent pi = PendingIntent.
                getActivity(this, 0, intent, PendingIntent.FLAG_ONE_SHOT);
        String Channel_Id = "Default";
        NotificationCompat.Builder builder = new NotificationCompat.Builder(this, Channel_Id);
        builder.setSmallIcon(R.drawable.ic_launcher_background)
                .setContentTitle(remoteMessage.getNotification().getTitle())
                .setContentText(remoteMessage.getNotification().getBody())
                .setAutoCancel(true)
                .setContentIntent(pi);
        NotificationManager manager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            NotificationChannel channel = new NotificationChannel(Channel_Id, "Default channel", NotificationManager.IMPORTANCE_DEFAULT);
            manager.createNotificationChannel(channel);
        }
        manager.notify(0, builder.build());
    }
}

