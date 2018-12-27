package com.example.star.exampleloginotp.ApiClass;

import com.example.star.exampleloginotp.Bean.CheckOtp;
import com.example.star.exampleloginotp.Bean.OtpSend;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Headers;
import retrofit2.http.POST;

public interface ApiInterface {

    @POST("sendOtp")
    Call<OtpSend> getotp(@Body String post);

    @POST("otpCheck")
    Call<CheckOtp> getcheckOtp(@Body String post);
}
