package com.example.star.serviceidandcategories.Bean;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import java.util.List;
/**
 * Awesome Pojo Generator
 * */
public class ServiceId{
  @SerializedName("result")
  @Expose
  private Boolean result;
  @SerializedName("data")
  @Expose
  private List<Data> data;
  @SerializedName("message")
  @Expose
  private String message;
  public void setResult(Boolean result){
   this.result=result;
  }
  public Boolean getResult(){
   return result;
  }
  public void setData(List<Data> data){
   this.data=data;
  }
  public List<Data> getData(){
   return data;
  }
  public void setMessage(String message){
   this.message=message;
  }
  public String getMessage(){
   return message;
  }
}