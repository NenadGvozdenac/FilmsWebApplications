package com.example.filmwebapplication.DTOs;

public class MessageWithJWTToken {
    private String message;
    private String JWTToken;

    public MessageWithJWTToken(String message, String JWTToken) {
        this.message = message;
        this.JWTToken = JWTToken;
    }

    public MessageWithJWTToken() {
        this.message = null;
        this.JWTToken = null;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getJWTToken() {
        return JWTToken;
    }

    public void setJWTToken(String JWTToken) {
        this.JWTToken = JWTToken;
    }
}
