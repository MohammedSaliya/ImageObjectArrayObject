package com.example.star.serviceidandcategories.APICLass;

import com.example.star.serviceidandcategories.Bean.ServiceId;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.converter.scalars.ScalarsConverterFactory;
import retrofit2.http.Body;
import retrofit2.http.Headers;
import retrofit2.http.POST;

public class APIClient {

    private static final String BASE_URL = "http://csnathan.com/quickeze/webservice/Api/";

    private static APIClient apiClient;
    private Retrofit retrofit;


    private APIClient() {
        Gson gson = new GsonBuilder()
                .setLenient()
                .create();

        retrofit = new Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create(gson))
                .addConverterFactory(ScalarsConverterFactory.create())
                .baseUrl(BASE_URL)
                .build();

    }

    public static synchronized APIClient getApiClient() {
        if (apiClient == null) {
            apiClient = new APIClient();
        }

        return apiClient;
    }


    public APIInterface getapiInterface() {
        return retrofit.create(APIInterface.class);
    }


}
