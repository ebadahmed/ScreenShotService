package com.ebadahmed.screenshotservice;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.media.projection.MediaProjectionManager;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.ebadahmed.screenshotservice.command.UserClick;
import com.ebadahmed.screenshotservice.databinding.ActivityMainBinding;
import com.ebadahmed.screenshotservice.receiver.MyBroadCastReceiver;
import com.ebadahmed.screenshotservice.service.ScreenShotsService;
import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdLoader;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.MobileAds;
import com.google.android.gms.ads.VideoController;
import com.google.android.gms.ads.formats.NativeAdOptions;
import com.google.android.gms.ads.formats.UnifiedNativeAd;
import com.google.android.gms.ads.initialization.InitializationStatus;
import com.google.android.gms.ads.initialization.OnInitializationCompleteListener;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity {


    private ActivityMainBinding activityMainBinding;
    private static String LOG_TAG = "EXAMPLE";
    VideoController mVideoController;
    private AdLoader adLoader;
    private AdRequest request;
    private static final int REQUEST_SCREENSHOT = 59706;
    private MediaProjectionManager mgr;
    private static MainActivity mainActivity;
    PendingIntent pendingIntent;
    AlarmManager alarmManager;
    Intent alarmIntent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mainActivity=this;

        activityMainBinding = DataBindingUtil.setContentView(this, R.layout.activity_main);


        alarmManager = (AlarmManager) getSystemService(Context.ALARM_SERVICE);

        Intent alarmIntent = new Intent(this, MyBroadCastReceiver.class);
        pendingIntent = PendingIntent.getBroadcast(this, 0, alarmIntent, 0);

        MobileAds.initialize(this, new OnInitializationCompleteListener() {
            @Override
            public void onInitializationComplete(InitializationStatus initializationStatus) {
            }
        });


        request = new AdRequest.Builder()
                .build();



        adLoader = new AdLoader.Builder(this, "ca-app-pub-3940256099942544/2247696110")
                .forUnifiedNativeAd(new UnifiedNativeAd.OnUnifiedNativeAdLoadedListener() {
                    @Override
                    public void onUnifiedNativeAdLoaded(UnifiedNativeAd unifiedNativeAd) {
                        // Show the ad.
                    }
                })
                .withAdListener(new AdListener() {
                    @Override
                    public void onAdFailedToLoad(int errorCode) {
                        // Handle the failure by logging, altering the UI, and so on.
                    }

                    @Override
                    public void onAdOpened() {
                        super.onAdOpened();
                    }

                    @Override
                    public void onAdLoaded() {
                        super.onAdLoaded();
                    }

                    @Override
                    public void onAdClicked() {
                        super.onAdClicked();
                    }
                })
                .withNativeAdOptions(new NativeAdOptions.Builder()
                        // Methods in the NativeAdOptions.Builder class can be
                        // used here to specify individual options settings.
                        .build())
                .build();


        adLoader.loadAd(new AdRequest.Builder().build());

        activityMainBinding.adView.loadAd(request);


        mgr = (MediaProjectionManager) getSystemService(MEDIA_PROJECTION_SERVICE);


        activityMainBinding.setUserclick(new UserClick() {
            @Override
            public void onClickButton() {

                AutoUpdateDataInBackground();
               /* Calendar cur_cal = Calendar.getInstance();
                cur_cal.setTimeInMillis(System.currentTimeMillis());
                cur_cal.add(Calendar.SECOND, 50);
                Log.e("Testing", "Calender Set time:"+cur_cal.getTime());
                Intent intent = new Intent(getApplicationContext(), ScreenShotsService.class);
                Log.e("Testing", "Intent created");
                PendingIntent pintent = PendingIntent.getService(getApplicationContext(), 0, intent, 0);
                AlarmManager alarm = (AlarmManager)getSystemService(Context.ALARM_SERVICE);
                alarm.setRepeating(AlarmManager.RTC_WAKEUP, cur_cal.getTimeInMillis(), 30*1000, pintent);
                Log.e("Testing", "alarm manager set");*/

            }
        });


    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == REQUEST_SCREENSHOT) {
            if (resultCode == RESULT_OK) {



               /* Intent i=
                        new Intent(this, ScreenShotsService.class)
                                .putExtra("resultCode", resultCode)
                                .putExtra("resultIntent", data);

                startService(i);*/
            }
        }


    }



    public void setOnetimeTimer(Context context) {
        AlarmManager am=(AlarmManager)context.getSystemService(Context.ALARM_SERVICE);
        Intent intent = new Intent(context, ScreenShotsService.class);
        PendingIntent pi = PendingIntent.getBroadcast(context, 0, intent, 0);
        am.set(AlarmManager.RTC_WAKEUP, System.currentTimeMillis() + (1000 * 60 * 2), pi);
    }

    public static void closeactivity(){
        if (mainActivity.isFinishing()){
            mainActivity.finish();
        }
    }



    private void AutoUpdateDataInBackground() {
        // Retrieve a PendingIntent that will perform a broadcast

        alarmIntent = new Intent(MainActivity.this, MyBroadCastReceiver.class);
        pendingIntent = PendingIntent.getBroadcast(MainActivity.this, 0, alarmIntent, 0);
        alarmManager = (AlarmManager) getSystemService(Context.ALARM_SERVICE);
        Log.e("Testing", "Intent created");
        long interval =  60 * 1000;

        // Repeating on every 15 minutes interval

        Calendar calendar = Calendar.getInstance();
        alarmManager.setRepeating(AlarmManager.RTC_WAKEUP, calendar.getTimeInMillis(),interval, pendingIntent);
        Log.e("Testing", "Alarm created");
    }

}
