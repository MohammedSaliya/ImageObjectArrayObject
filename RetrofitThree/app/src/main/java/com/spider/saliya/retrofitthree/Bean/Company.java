package com.spider.saliya.retrofitthree.Bean;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
/**
 * Awesome Pojo Generator
 * */
public class Company{
  @SerializedName("bs")
  @Expose
  private String bs;
  @SerializedName("catchPhrase")
  @Expose
  private String catchPhrase;
  @SerializedName("name")
  @Expose
  private String name;
  public void setBs(String bs){
   this.bs=bs;
  }
  public String getBs(){
   return bs;
  }
  public void setCatchPhrase(String catchPhrase){
   this.catchPhrase=catchPhrase;
  }
  public String getCatchPhrase(){
   return catchPhrase;
  }
  public void setName(String name){
   this.name=name;
  }
  public String getName(){
   return name;
  }
}