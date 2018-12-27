package com.spider.saliya.retrofitone.ApiClasses;

import com.spider.saliya.retrofitone.Bean.BeanItem;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface Api {

    @GET("demos/marvel/ ")
    Call <List<BeanItem>> getItems();
}
