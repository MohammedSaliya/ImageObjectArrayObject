package com.example.star.exampleloginotp.Bean;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
/**
 * Awesome Pojo Generator
 * */
public class CheckOtp{
  @SerializedName("success")
  @Expose
  private String success;
  @SerializedName("message")
  @Expose
  private String message;
  @SerializedName("status")
  @Expose
  private Integer status;

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

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }
}