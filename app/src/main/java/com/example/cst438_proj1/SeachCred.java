package com.example.cst438_proj1;

public class SeachCred {
    private String title;
    private String location;

    public String getJobName() {
        return title;
    }

    public String getLocation() {
        return location;
    }

    public SeachCred(String title, String location) {
        this.title = title;
        this.location = location;
    }
}
