package com.laurinware.gamebrain.Model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Platform {
    @SerializedName("id")
    @Expose
    public int id;

    @SerializedName("name")
    @Expose
    public String name;

    @SerializedName("logo")
    @Expose
    public String logo;
}
