package com.example.cst438_proj1.data;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "USER_TABLE")
public class User {
    @PrimaryKey
    private int Id;

    private String userName;
    private String password;
    private String location;

    public User(String userName, String password) {
        this.userName = userName;
        this.password = password;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
