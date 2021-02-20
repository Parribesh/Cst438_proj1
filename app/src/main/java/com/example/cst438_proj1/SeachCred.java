package com.example.cst438_proj1;

import com.google.gson.annotations.SerializedName;

public class SeachCred {
    @SerializedName("title")
    private String jobName;

    @SerializedName("location")
    private String location;

    @SerializedName("description")
    private String desc;

    public String getJobName() {
        return jobName;
    }

    public String getLocation() {
        return location;
    }

    public String getDesc(){ return desc; }
}
