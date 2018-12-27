
package com.spider.saliya.searchretrofitasds.Bean;

import com.google.gson.annotations.SerializedName;


public class DogsBreeds {

    @SerializedName("message")
    private Message mMessage;
    @SerializedName("status")
    private String mStatus;

    public Message getMessage() {
        return mMessage;
    }

    public void setMessage(Message message) {
        mMessage = message;
    }

    public String getStatus() {
        return mStatus;
    }

    public void setStatus(String status) {
        mStatus = status;
    }

}
