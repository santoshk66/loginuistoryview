package com.groupsale.Lootlo.ui.Services;

import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.media.RingtoneManager;
import android.net.Uri;

import androidx.core.app.NotificationCompat;

import com.groupsale.Lootlo.Notification;
import com.groupsale.Lootlo.R;
import com.google.firebase.messaging.FirebaseMessagingService;
import com.google.firebase.messaging.RemoteMessage;

import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

public class MyFcmMessagingService extends FirebaseMessagingService {

    private static final String TAG = "FirebaseMessageService";
    Bitmap bitmap;

    @Override
    public void onMessageReceived(RemoteMessage remoteMessage) {
        //The message will contain the Push Message
        String message = remoteMessage.getData().get("message");
        //imageUri will contain URL of the image to be displayed with Notification
        String imageUri = remoteMessage.getData().get("image");
        //title for the notification.
        String title = remoteMessage.getData().get("title");
        //action string to perform the action e.g. open activity
        String action = remoteMessage.getData().get("click_action");
        //To get a Bitmap image from the URL received
        bitmap = getBitmapfromUrl(imageUri);
        //method for functioning the notification --->
        sendNotification(message, title, bitmap, action);
    }

    private void sendNotification(String messageBody, String title, Bitmap image, String action) {
        Intent intent = new Intent(this, Notification.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        intent.putExtra("title", title);
        ByteArrayOutputStream _bs = new ByteArrayOutputStream();
        image.compress(Bitmap.CompressFormat.PNG, 50, _bs);
        intent.putExtra("img", image);
        intent.putExtra("msg", messageBody);
        intent.putExtra("click_action", action);
        PendingIntent pendingIntent = PendingIntent.getActivity(this, 0 /* Request code */, intent,
                PendingIntent.FLAG_ONE_SHOT);

        Uri defaultSoundUri = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION);
        NotificationCompat.Builder notificationBuilder = new
                NotificationCompat.Builder(this, "Default")
                .setLargeIcon(image)/*Notification icon image*/
                .setSmallIcon(R.id.main_notification_icon)
                .setStyle(new NotificationCompat.BigPictureStyle().bigPicture(image))/*Notification with Image*/
                .setAutoCancel(true)
                .setSound(defaultSoundUri)
                .setChannelId("Default")
                .setVibrate(new long[]{1000, 1000})
                .setContentIntent(pendingIntent);

        notificationBuilder.setContentTitle(title);
        notificationBuilder.setContentText(messageBody);
        notificationBuilder.setAutoCancel(true);
        NotificationManager notificationManager =
                (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);

        notificationManager.notify(0 /* ID of notification */, notificationBuilder.build());

    }

    public Bitmap getBitmapfromUrl(String imageUrl) {
        try {
            URL url = new URL(imageUrl);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setDoInput(true);
            connection.connect();
            InputStream input = connection.getInputStream();
            Bitmap bitmap = BitmapFactory.decodeStream(input);
            return bitmap;

        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            return null;

        }
    }


}

