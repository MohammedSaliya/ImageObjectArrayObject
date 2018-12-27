package com.spider.saliya.retrofirlogin.Bean;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
/**
 * Awesome Pojo Generator
 * */
public class GetResponce{
  @SerializedName("success")
  @Expose
  private Boolean success;
  @SerializedName("login")
  @Expose
  private String login;
  @SerializedName("status")
  @Expose
  private Integer status;
  public void setSuccess(Boolean success){
   this.success=success;
  }
  public Boolean getSuccess(){
   return success;
  }
  public void setLogin(String login){
   this.login=login;
  }
  public String getLogin(){
   return login;
  }
  public void setStatus(Integer status){
   this.status=status;
  }
  public Integer getStatus(){
   return status;
  }
}