package com.example.cst438_proj1;

public class User {
    private int Id;
    private String userName;
    private String password;

    public User(int id, String userName, String password) {
        Id = id;
        this.userName = userName;
        this.password = password;
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
