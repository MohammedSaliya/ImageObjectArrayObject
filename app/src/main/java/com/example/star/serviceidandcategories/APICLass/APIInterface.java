package com.example.star.serviceidandcategories.APICLass;

import com.example.star.serviceidandcategories.Bean.ServiceId;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.POST;

public interface APIInterface {



    @Headers("Content-Type: application/json")
    @GET("services")
    Call<ServiceId> getService();
}
