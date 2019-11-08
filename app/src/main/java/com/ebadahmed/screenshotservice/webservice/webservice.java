package com.ebadahmed.screenshotservice.webservice;

import com.google.gson.JsonObject;

import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.Part;

public interface webservice {


    @Multipart
    @POST("upload")
    Call<ResponseBody> uploadPhoto(
            @Part("description")RequestBody description,
            @Part MultipartBody.Part photo
            );


}
//&userId=542112&albumId=81015"