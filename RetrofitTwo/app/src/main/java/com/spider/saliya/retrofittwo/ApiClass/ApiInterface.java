package com.spider.saliya.retrofittwo.ApiClass;

import com.spider.saliya.retrofittwo.Bean.BeanResponce;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiInterface {

    @GET("users")
    Call <List<BeanResponce>> getDetails();


    @GET("users")
    Call <List<BeanResponce>> getDatas();
}
