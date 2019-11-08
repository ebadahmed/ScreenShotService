package com.ebadahmed.screenshotservice.helper;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

public class NetworkUtils {

    public static boolean isNetworkAvailable(Context context) {

        ConnectivityManager cm = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo activeNetwork = cm.getActiveNetworkInfo();
        if (activeNetwork != null) {
            // connected to the internet
            if (activeNetwork.getType() == ConnectivityManager.TYPE_WIFI) {
                // connected to wifi
                return true;
            } else if (activeNetwork.getType() == ConnectivityManager.TYPE_MOBILE) {
                // connected to mobile data
                return true;
            }
        } else {
            return false;
            // not connected to the internet
        }
        return false;
//
//        ConnectivityManager manager = (ConnectivityManager) context
//                .getSystemService(Context.CONNECTIVITY_SERVICE);
//
//        if (manager == null)
//            return false;
//
//        // 3g-4g available
//        boolean is3g = manager.getNetworkInfo(ConnectivityManager.TYPE_MOBILE)
//                .isConnectedOrConnecting();
//        // wifi available
//        boolean isWifi = manager.getNetworkInfo(ConnectivityManager.TYPE_WIFI)
//                .isConnectedOrConnecting();
//
//        // System.out.println(is3g + " net " + isWifi);
//
////        if (netInfo != null && netInfo.isConnectedOrConnecting()) {
////            return true;
////        } else {
////            return false;
////        }
//
//        if (!is3g && !isWifi ) {
//            return false;
//        } else
//            return true;
//


    }
}
