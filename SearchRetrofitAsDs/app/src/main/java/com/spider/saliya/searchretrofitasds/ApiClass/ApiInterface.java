package com.spider.saliya.searchretrofitasds.ApiClass;

import com.spider.saliya.searchretrofitasds.Bean.DogsBreeds;
import com.spider.saliya.searchretrofitasds.Bean.Message;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiInterface {

    @GET("list/all")
    Call<DogsBreeds> getmessage();
}
