package com.example.filmwebapplication.DTOs;

public class UserLoginDTO {

    private String username;
    private String password;

    public UserLoginDTO() {
        this.username = null;
        this.password = null;
    }

    public UserLoginDTO(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
