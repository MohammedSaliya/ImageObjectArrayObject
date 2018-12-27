package com.example.star.sumloginregister.APIClasss;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.converter.scalars.ScalarsConverterFactory;

public class APIClient {

    private static final String BASE_URL = "http://csnathan.com/nexbase/api/";
    private static APIClient apiClient;
    private Retrofit retrofit;

    private APIClient() {

        Gson gson = new GsonBuilder()
                .setLenient()
                .create();

        retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(ScalarsConverterFactory.create())
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();

    }

    public static synchronized APIClient getApiClient() {
        if (apiClient == null) {
            apiClient = new APIClient();
        }

        return apiClient;
    }

    public APIInterface apiInterface() {
        return retrofit.create(APIInterface.class);
    }

}
