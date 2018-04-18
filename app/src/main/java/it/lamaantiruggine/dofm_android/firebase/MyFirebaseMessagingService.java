package it.lamaantiruggine.dofm_android.firebase;

import android.app.NotificationManager;
import android.content.Context;
import android.media.RingtoneManager;
import android.net.Uri;
import android.support.v4.app.NotificationCompat;

import com.google.firebase.messaging.FirebaseMessagingService;
import com.google.firebase.messaging.RemoteMessage;

import java.util.Random;

import it.lamaantiruggine.dofm_android.R;

public class MyFirebaseMessagingService extends FirebaseMessagingService {
    @Override public void onMessageReceived(RemoteMessage remoteMessage) {
        NotificationManager notificationManager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
        int notificationId = new Random().nextInt(60000);

        Uri defaultSoundUri = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION);
        NotificationCompat.Builder notificationBuilder = new NotificationCompat.Builder(this, "DOFM");
        notificationBuilder.setSmallIcon(R.drawable.logo);
        notificationBuilder.setContentTitle(remoteMessage.getData().get("title"));
        notificationBuilder.setContentText(remoteMessage.getData().get("message"));
        notificationBuilder.setAutoCancel(true);
        notificationBuilder.setSound(defaultSoundUri);

        notificationManager.notify(notificationId, notificationBuilder.build());
    }
}
