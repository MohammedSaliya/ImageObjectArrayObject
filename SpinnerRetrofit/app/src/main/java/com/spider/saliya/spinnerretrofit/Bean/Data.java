package com.spider.saliya.spinnerretrofit.Bean;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
/**
 * Awesome Pojo Generator
 * */
public class Data{
  @SerializedName("createdAt")
  @Expose
  private String createdAt;
  @SerializedName("createdBy")
  @Expose
  private Integer createdBy;
  @SerializedName("name")
  @Expose
  private String name;
  @SerializedName("id")
  @Expose
  private Integer id;
  @SerializedName("status")
  @Expose
  private String status;
  public void setCreatedAt(String createdAt){
   this.createdAt=createdAt;
  }
  public String getCreatedAt(){
   return createdAt;
  }
  public void setCreatedBy(Integer createdBy){
   this.createdBy=createdBy;
  }
  public Integer getCreatedBy(){
   return createdBy;
  }
  public void setName(String name){
   this.name=name;
  }
  public String getName(){
   return name;
  }
  public void setId(Integer id){
   this.id=id;
  }
  public Integer getId(){
   return id;
  }
  public void setStatus(String status){
   this.status=status;
  }
  public String getStatus(){
   return status;
  }
}