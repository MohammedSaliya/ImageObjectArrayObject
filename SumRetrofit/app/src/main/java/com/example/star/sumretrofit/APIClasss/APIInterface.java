package com.example.star.sumretrofit.APIClasss;

import com.example.star.sumretrofit.Bean.DataModule;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface APIInterface {


    @GET("demos/marvel/")
    Call<List<DataModule>> getresponce();

}
