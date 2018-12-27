package com.spider.saliya.getimageurl.APIClass;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class APIClient {

    private static final String BASE_URL = "https://simplifiedcoding.net/demos/";
    private static APIClient apiClient;
    private Retrofit retrofit;

    private APIClient() {
        Gson gson = new GsonBuilder()
                .setLenient()
                .create();


        retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();


    }

    public static synchronized APIClient getapiClient() {
        if (apiClient == null) {
            apiClient = new APIClient();
        }


        return apiClient;
    }

    public APInterface getapiInterface() {

        return retrofit.create(APInterface.class);
    }
}
