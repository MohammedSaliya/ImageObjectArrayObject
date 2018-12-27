package com.spider.saliya.retrofitthree.ApiClass;

import com.spider.saliya.retrofitthree.Bean.Example;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface Api {

    @GET("users")
    Call<List<Example>> getlist();


}
