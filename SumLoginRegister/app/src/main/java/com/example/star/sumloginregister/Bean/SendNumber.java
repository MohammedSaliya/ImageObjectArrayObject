package com.example.star.sumloginregister.Bean;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class SendNumber {


    @SerializedName("status")
    @Expose
    private Integer status;
    @SerializedName("success")
    @Expose
    private String success;
    @SerializedName("message")
    @Expose
    private String message;

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getSuccess() {
        return success;
    }

    public void setSuccess(String success) {
        this.success = success;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

}
