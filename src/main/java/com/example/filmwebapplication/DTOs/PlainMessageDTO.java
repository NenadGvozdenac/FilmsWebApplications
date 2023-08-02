package com.example.filmwebapplication.DTOs;

public class PlainMessageDTO {

    private String message;

    public PlainMessageDTO(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public PlainMessageDTO() {
        this.message = null;
    }
}
