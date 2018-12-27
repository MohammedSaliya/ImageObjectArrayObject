package com.example.star.serviceidandcategories.Bean;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Awesome Pojo Generator
 */
public class Data {
    @SerializedName("service_name")
    @Expose
    private String service_name;
    @SerializedName("image_path")
    @Expose
    private String image_path;
    @SerializedName("service_image")
    @Expose
    private String service_image;
    @SerializedName("created_at")
    @Expose
    private String created_at;
    @SerializedName("id")
    @Expose
    private String id;
    @SerializedName("created_by")
    @Expose
    private String created_by;
    @SerializedName("status")
    @Expose
    private String status;


    public String getService_name() {
        return service_name;
    }

    public void setService_name(String service_name) {
        this.service_name = service_name;
    }

    public String getImage_path() {
        return image_path;
    }

    public void setImage_path(String image_path) {
        this.image_path = image_path;
    }

    public String getService_image() {
        return service_image;
    }

    public void setService_image(String service_image) {
        this.service_image = service_image;
    }

    public String getCreated_at() {
        return created_at;
    }

    public void setCreated_at(String created_at) {
        this.created_at = created_at;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCreated_by() {
        return created_by;
    }

    public void setCreated_by(String created_by) {
        this.created_by = created_by;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}


