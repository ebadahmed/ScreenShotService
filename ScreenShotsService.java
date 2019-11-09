package com.ebadahmed.screenshotservice.service;

import android.app.Activity;
import android.app.AlarmManager;
import android.app.IntentService;
import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.hardware.display.DisplayManager;
import android.hardware.display.VirtualDisplay;
import android.media.AudioManager;
import android.media.MediaScannerConnection;
import android.media.ToneGenerator;
import android.media.projection.MediaProjection;
import android.media.projection.MediaProjectionManager;
import android.os.Build;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.IBinder;
import android.util.Log;
import android.view.WindowManager;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.core.app.NotificationCompat;

import com.ebadahmed.screenshotservice.BuildConfig;
import com.ebadahmed.screenshotservice.MainActivity;
import com.ebadahmed.screenshotservice.R;
import com.ebadahmed.screenshotservice.SplashActivity;
import com.ebadahmed.screenshotservice.receiver.MyBroadCastReceiver;

import java.io.File;
import java.io.FileOutputStream;

public class ScreenShotsService extends Service {
    private static final int NOTIFICATION_ID = 101;
    private final String CHANNEL_ID = "channel_01";// The id of the channel.
    private static Notification notification;

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {

        YourTask();

        return Service.START_STICKY;
    }

    private void YourTask(){
        // call api in background

        // send push notification

        Log.e("Testing","  OnStart");

        stopSelf();
        //etc...
    }

    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.
        throw new UnsupportedOperationException("Not yet implemented");
    }

    @Override
    public void onCreate() {
        super.onCreate();
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {

            // ClickListener of Intro-Notification
            Intent previousIntent = new Intent(this, SplashActivity.class);
            PendingIntent ppreviousIntent = PendingIntent.getService(this, 0,
                    previousIntent, 0);


            //String CHANNEL_ID = "my_channel_01";// The id of the channel.
            CharSequence cs_name = getString(R.string.app_name);// The user-visible name of the channel.
            int importance = NotificationManager.IMPORTANCE_DEFAULT;
            NotificationChannel mChannel;
            mChannel = new NotificationChannel(CHANNEL_ID, cs_name, importance);
            mChannel.setImportance(importance);
            notification = new Notification.Builder(getApplicationContext(), CHANNEL_ID)
                    .setChannelId(CHANNEL_ID)
                    .setSmallIcon(R.mipmap.ic_launcher)
                    .setContentTitle("Welcome to ScreenShot")
                    .setContentText("Hello...!!")
                    .setContentIntent(ppreviousIntent)
                    .build();
            final NotificationManager mNotificationManager =
                    (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
            mNotificationManager.createNotificationChannel(mChannel);  // resolve 3.1
            // Issue the notification.
            // mNotificationManager.notify(1 , notification);

            startForeground(NOTIFICATION_ID, notification);

        }

    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            stopForeground(true); //true will remove notification
        }
    }
}