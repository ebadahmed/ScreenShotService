package com.ebadahmed.screenshotservice.constant;

import android.os.Handler;

public class AppConstants {


    public static final String ENDPOINT = "https://api.koyal.pk/musicapp/?request=";


    public static String BASE_URL = "https://api.koyal.pk/musicapp/";

    // EVENTS


    public class ServerAPICalls {
        //    public static final String GET_HOME= "http://www.koyal.pk/musicapp/?request=set-lang-ramadan-nd";
        public static final String GET_HOME = ENDPOINT+"get-home-data-nd";
        public static final String SET_LANG = ENDPOINT+"set-lang-ramadan-nd";
        public static final String APP_INFO_API = ENDPOINT+ "app-info-nd";
        public static final String GET_SEARCH = "test";
        public static final String SEARCH = ENDPOINT + "search";
        public static final String SEARCH_RECOMMENDED = ENDPOINT + "search-content-nd-searchscreen";
        public static final String MY_MUSIC = ENDPOINT + "get-mymusic";
        public static final String MAC_ADDRESS = ENDPOINT + "create-user";
        public static final String SEE_ALL = "https://api.koyal.pk/musicapp/";
        public static final String DELETE_CHARGED_DOWNLOAD = ENDPOINT + "delete-charged-download";
        public static final String SEND_DMCA_REPORT = ENDPOINT + "send-dmca-report";
        public static final String RBT_1 = ENDPOINT + "set-rbt";
        public static final String RBT_SEND_CODE = ENDPOINT + "send-verify-rbt";
        public static final String DOWNLOAD_OTP = ENDPOINT + "set-download";
        public static final String DOWNLOAD_SEND_CODE = ENDPOINT + "send-verify-download";
        public static final String GET_ARTIST = ENDPOINT + "get-artist-profile";
        public static final String GET_PLAYLIST = "https://api.koyal.pk/app_files/";
        public static final String GET_PLAYLIST_BY_TRACK= ENDPOINT + "get-tracks-react";
        public static final String GET_RELATED_TRACK = ENDPOINT + "get-tracks-more";
        public static final String GET_HOME_GENERE = ENDPOINT + "get-tracks-sd";
        public static final String ALBUM_LIKE = ENDPOINT + "add-fav";
        public static final String TRACK_LIKE = ENDPOINT + "add-fav";
        public static final String LANGUAGE = ENDPOINT + "gen-lang-list";
        public static final String ARTIST_LIKE = ENDPOINT + "add-fav";
        public static final String DOWNLOAD = "http://35.156.24.14/koyaldownload/download.php";
        public static final String GET_NUMBER_API = "http://35.156.24.14/koyaldownload/getnumber.php";
        public static final String CHARGE_DOWNLOAD_API = "http://35.156.24.14/koyaldownload/charge-download.php";
        public static final String UPDATE_DOWNLOAD_COUNT= ENDPOINT+"update-download-counter-app";


//        public static final String SUGGESTED = ENDPOINT + "/app_files/appnew/suggested.json";

    }
}


