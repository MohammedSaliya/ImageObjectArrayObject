package com.spider.saliya.retrofitthree.Bean;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
/**
 * Awesome Pojo Generator
 * */
public class Example{
  @SerializedName("website")
  @Expose
  private String website;
  @SerializedName("address")
  @Expose
  private Address address;
  @SerializedName("phone")
  @Expose
  private String phone;
  @SerializedName("name")
  @Expose
  private String name;
  @SerializedName("company")
  @Expose
  private Company company;
  @SerializedName("id")
  @Expose
  private Integer id;
  @SerializedName("email")
  @Expose
  private String email;
  @SerializedName("username")
  @Expose
  private String username;
  public void setWebsite(String website){
   this.website=website;
  }
  public String getWebsite(){
   return website;
  }
  public void setAddress(Address address){
   this.address=address;
  }
  public Address getAddress(){
   return address;
  }
  public void setPhone(String phone){
   this.phone=phone;
  }
  public String getPhone(){
   return phone;
  }
  public void setName(String name){
   this.name=name;
  }
  public String getName(){
   return name;
  }
  public void setCompany(Company company){
   this.company=company;
  }
  public Company getCompany(){
   return company;
  }
  public void setId(Integer id){
   this.id=id;
  }
  public Integer getId(){
   return id;
  }
  public void setEmail(String email){
   this.email=email;
  }
  public String getEmail(){
   return email;
  }
  public void setUsername(String username){
   this.username=username;
  }
  public String getUsername(){
   return username;
  }
}