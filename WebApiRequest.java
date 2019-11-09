package com.ebadahmed.screenshotservice.webservice;

import com.ebadahmed.screenshotservice.model.Api_Response;

public class WebApiRequest {
    private static webservice apiService;
    private static WebApiRequest ourInstance = new WebApiRequest();

    private WebApiRequest() {
    }

    public static WebApiRequest getInstance() {
        apiService = WebServiceFactory.getInstance();

//        if (isShow) {
//
//            if(mDialog != null && !mDialog.isShowing()){
//                mDialog = new ProgressDialog(currentActivity);
//                mDialog.setMessage(activity.getString(R.string.loading));
//                mDialog.setTitle(activity.getString(R.string.please_wait));
//                mDialog.setCancelable(false);
//            }
//
//            if (!currentActivity.isFinishing()) {
//                if(mDialog != null && !mDialog.isShowing())
//                    mDialog.show();
//
//            }
//        }

        return ourInstance;
    }


    public interface APIRequestDataCallBack {
        void onSuccess(Api_Response response);

        void onError();

        void onNoNetwork();
    }

    public interface APIArrayRequestDataCallBack {
        void onSuccess(Api_Response response);

        void onError();

        void onNoNetwork();
    }


}
