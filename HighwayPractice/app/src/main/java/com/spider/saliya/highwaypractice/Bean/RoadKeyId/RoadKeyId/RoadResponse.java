package com.spider.saliya.highwaypractice.Bean.RoadKeyId.RoadKeyId;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class RoadResponse {

    @SerializedName("result")
    @Expose
    private Result result;

    /**
     * No args constructor for use in serialization
     *
     */
    public RoadResponse() {
    }

    /**
     *
     * @param result
     */
    public RoadResponse(Result result) {
        super();
        this.result = result;
    }

    public Result getResult() {
        return result;
    }

    public void setResult(Result result) {
        this.result = result;
    }
}
