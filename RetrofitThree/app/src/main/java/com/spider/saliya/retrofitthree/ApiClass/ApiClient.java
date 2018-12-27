package com.spider.saliya.retrofitthree.ApiClass;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApiClient {

    private static final String BASE_URL = "https://jsonplaceholder.typicode.com/";

    private static ApiClient apiClient;
    private Retrofit retrofit;


    private ApiClient() {
        Gson gson = new GsonBuilder()
                .setLenient()
                .create();

        retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }

    public static synchronized ApiClient getApiClient() {
        if (apiClient == null) {
            apiClient = new ApiClient();
        }

        return apiClient;
    }


    public Api api() {
        return retrofit.create(Api.class);
    }

}
