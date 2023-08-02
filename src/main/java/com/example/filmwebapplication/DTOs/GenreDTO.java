package com.example.filmwebapplication.DTOs;

public class GenreDTO {

    private String genre;
    public GenreDTO(String genre) {
        this.genre = genre;
    }

    public GenreDTO() {
        this.genre = null;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }


}
