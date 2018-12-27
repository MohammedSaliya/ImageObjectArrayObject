package com.spider.saliya.spinnerretrofit.ApiClass;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.converter.scalars.ScalarsConverterFactory;

public class ApiClient {


    private static final String BASE_URL = "http://www.csnathan.com/nexbase/api/";
    private static ApiClient apiClient;
    private Retrofit retrofit;


    private ApiClient() {
        Gson gson = new GsonBuilder()
                .setLenient()
                .create();

        retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(ScalarsConverterFactory.create())
                .addConverterFactory(GsonConverterFactory.create(gson))
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
