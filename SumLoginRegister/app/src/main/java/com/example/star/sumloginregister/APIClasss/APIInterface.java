package com.example.star.sumloginregister.APIClasss;

import com.example.star.sumloginregister.Bean.SendNumber;
import com.example.star.sumloginregister.Bean.SendOtp;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Headers;
import retrofit2.http.POST;

public interface APIInterface {


    @Headers("Content-Type: application/json")
    @POST("sendOtp")
    Call<SendNumber> getotp(@Body String post);


    @Headers("Content-Type: application/json")
    @POST("otpCheck")
    Call<SendOtp> getverfied(@Body String post);

}
