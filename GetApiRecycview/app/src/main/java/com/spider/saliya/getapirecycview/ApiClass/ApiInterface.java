package com.spider.saliya.getapirecycview.ApiClass;

import com.spider.saliya.getapirecycview.Bean.Employee;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiInterface {


    @GET("employees")
    Call<List<Employee>> getemployee();
}
