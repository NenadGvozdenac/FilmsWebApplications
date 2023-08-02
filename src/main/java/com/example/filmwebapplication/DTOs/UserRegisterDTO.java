package com.example.filmwebapplication.DTOs;

public class UserRegisterDTO {

    private Integer ID;

    private String username;

    private String password;

    private String email;

    private String phoneNumber;

    public UserRegisterDTO(String username, String password, String email, String phoneNumber) {
        this.ID = 0;
        this.username = username;
        this.password = password;
        this.email = email;
        this.phoneNumber = phoneNumber;
    }

    public UserRegisterDTO() {
        this.ID = 0;
        this.username = null;
        this.password = null;
        this.email = null;
        this.phoneNumber = null;
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

    public Integer getID() {
        return ID;
    }

    public void setID(Integer ID) {
        this.ID = ID;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
}
