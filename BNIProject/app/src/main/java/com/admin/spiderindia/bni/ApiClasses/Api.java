package com.admin.spiderindia.bni.ApiClasses;

import com.admin.spiderindia.bni.ModelClasses.RegisterResponse;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Headers;
import retrofit2.http.POST;

public interface Api {



    @Headers("Content-Type: application/json")
    @POST("webservice/register")
    Call<RegisterResponse> updateDetails(
            @Body String RoadId
    );


}
