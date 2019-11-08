package com.ebadahmed.screenshotservice;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.content.Intent;
import android.media.projection.MediaProjectionManager;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.ebadahmed.screenshotservice.command.UserClick;
import com.ebadahmed.screenshotservice.databinding.ActivityMainBinding;
import com.ebadahmed.screenshotservice.service.ScreenShotsService;
import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdLoader;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.MobileAds;
import com.google.android.gms.ads.NativeExpressAdView;
import com.google.android.gms.ads.VideoController;
import com.google.android.gms.ads.VideoOptions;
import com.google.android.gms.ads.formats.NativeAdOptions;
import com.google.android.gms.ads.formats.UnifiedNativeAd;
import com.google.android.gms.ads.initialization.InitializationStatus;
import com.google.android.gms.ads.initialization.OnInitializationCompleteListener;

public class MainActivity extends AppCompatActivity {


    private ActivityMainBinding activityMainBinding;
    private static String LOG_TAG = "EXAMPLE";
    VideoController mVideoController;
    private AdLoader adLoader;
    private AdRequest request;
    private static final int REQUEST_SCREENSHOT=59706;
    private MediaProjectionManager mgr;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        activityMainBinding= DataBindingUtil.setContentView(this,R.layout.activity_main);


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


        mgr=(MediaProjectionManager)getSystemService(MEDIA_PROJECTION_SERVICE);


        activityMainBinding.setUserclick(new UserClick() {
            @Override
            public void onClickButton() {
                startActivityForResult(mgr.createScreenCaptureIntent(),
                        REQUEST_SCREENSHOT);
            }
        });








    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode==REQUEST_SCREENSHOT) {
            if (resultCode==RESULT_OK) {
                Intent i=
                        new Intent(this, ScreenShotsService.class)
                                .putExtra("resultCode", resultCode)
                                .putExtra("resultIntent", data);

                startService(i);
            }
        }

        finish();
    }
}
