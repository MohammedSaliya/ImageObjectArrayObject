package com.spider.saliya.spinnerretrofit.ApiClass;

import com.spider.saliya.spinnerretrofit.Bean.Example;
import com.spider.saliya.spinnerretrofit.Bean.PostResponse;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.POST;

public interface ApiInterface {


    @GET("get_product_type")
    Call<Example> getdata();

    @Headers("Content-Type: application/json")
    @POST("ticket_create")
    Call<PostResponse> getResponceDetail(@Body String post);

}
