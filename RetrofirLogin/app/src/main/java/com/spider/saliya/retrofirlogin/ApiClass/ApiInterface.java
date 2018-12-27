package com.spider.saliya.retrofirlogin.ApiClass;

import com.spider.saliya.retrofirlogin.Bean.GetMobileNumber;
import com.spider.saliya.retrofirlogin.Bean.GetResponce;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Headers;
import retrofit2.http.POST;

public interface ApiInterface {


    @Headers("Content-Type: application/json")
    @POST("sendOtp")
    Call<GetMobileNumber> getotp(@Body String post);



    @Headers("Content-Type: application/json")
    @POST("otpCheck")
    Call<GetResponce> checkotp(@Body String post);
}
