package com.spider.saliya.retrofittwo.ApiClass;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitClient {

        private static final String BASE_URL = "https://jsonplaceholder.typicode.com/";
    private static RetrofitClient retrofitClient;
    private Retrofit retrofit;


    private RetrofitClient() {
        Gson gson = new GsonBuilder().setLenient()
                .create();


        retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create()).build();

    }


    public static synchronized RetrofitClient getRetrofitClient() {
        if (retrofitClient == null) {
            retrofitClient = new RetrofitClient();

        }


        return retrofitClient;
    }

    public ApiInterface apiInterface() {
        return retrofit.create(ApiInterface.class);
    }
}
