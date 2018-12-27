package com.spider.saliya.retrofirlogin.Bean;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
/**
 * Awesome Pojo Generator
 * */
public class GetMobileNumber{
  @SerializedName("success")
  @Expose
  private Boolean success;
  @SerializedName("message")
  @Expose
  private String message;
  @SerializedName("status")
  @Expose
  private Integer status;
  public void setSuccess(Boolean success){
   this.success=success;
  }
  public Boolean getSuccess(){
   return success;
  }
  public void setMessage(String message){
   this.message=message;
  }
  public String getMessage(){
   return message;
  }
  public void setStatus(Integer status){
   this.status=status;
  }
  public Integer getStatus(){
   return status;
  }
}