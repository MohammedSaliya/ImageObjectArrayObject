package com.spider.saliya.getimageurl.APIClass;

import com.spider.saliya.getimageurl.Bean.Responce;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface APInterface {

    @GET("marvel/")
    Call<List<Responce>> getresponce();

}
