package com.spider.saliya.searchretrofitasds.ApiClass;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.converter.scalars.ScalarsConverterFactory;

public class ApiClient {


    private final static String BASE_URL = "https://dog.ceo/api/breeds/";
    private static ApiClient apiClient;
    private Retrofit retrofit;


    private ApiClient() {
        Gson gson = new GsonBuilder().setLenient().create();


        retrofit = new Retrofit.Builder()
                .addConverterFactory(ScalarsConverterFactory.create())
                .addConverterFactory(GsonConverterFactory.create(gson))
                .baseUrl(BASE_URL)
                .build();
    }

    public static synchronized ApiClient getApiClient() {
        if (apiClient == null) {
            apiClient = new ApiClient();
        }
        return apiClient;
    }

    public ApiInterface apiInterface() {


        return retrofit.create(ApiInterface.class);
    }
}
