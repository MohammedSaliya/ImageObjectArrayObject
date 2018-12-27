
package com.spider.saliya.highwaypractice.Bean.RoadKeyId.BridgeKeyId;

import com.google.gson.annotations.SerializedName;

@SuppressWarnings("unused")
public class BridgeResponce {

    @SerializedName("result")
    private Result mResult;

    public Result getResult() {
        return mResult;
    }

    public void setResult(Result result) {
        mResult = result;
    }

}
