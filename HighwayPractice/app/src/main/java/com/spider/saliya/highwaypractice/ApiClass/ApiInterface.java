package com.spider.saliya.highwaypractice.ApiClass;

import com.spider.saliya.highwaypractice.Bean.RoadKeyId.BridgeKeyId.BridgeResponce;
import com.spider.saliya.highwaypractice.Bean.RoadKeyId.Linkid.Example;
import com.spider.saliya.highwaypractice.Bean.RoadKeyId.RoadKeyId.RoadResponse;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Headers;
import retrofit2.http.POST;

public interface ApiInterface {

    @Headers("Content-Type: application/json")
    @POST("getRoadsDetails")
    Call<RoadResponse> getroadkeyid(@Body String post);

    @Headers("Content-Type: application/json")
    @POST("getLinksDetails")
    Call<Example> getlinkid(@Body String post);

    @Headers("Content-Type: application/json")
    @POST("getBridgeDetails")
    Call<BridgeResponce> getbridgeid(@Body String post);


}
