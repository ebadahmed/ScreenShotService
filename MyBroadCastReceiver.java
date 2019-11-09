package com.ebadahmed.screenshotservice.receiver;

/* Created by Ebad Ahmed on 11/9/2019.*/

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.util.Log;
import android.widget.Toast;

import com.ebadahmed.screenshotservice.service.ScreenShotsService;

public class MyBroadCastReceiver extends BroadcastReceiver {

    Context context;

    public MyBroadCastReceiver() {
    }

    @Override
    public void onReceive(Context context, Intent intent) {
        Log.e("Testing", "  Broadcast received");
        intent = new Intent(context, ScreenShotsService.class);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            context.startForegroundService(intent);
        } else {
            context.startService(intent);
        }

    }

}