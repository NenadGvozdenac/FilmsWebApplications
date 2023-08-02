package com.example.filmwebapplication.DTOs;

public class BasicMovieDTO {
    private String imdb_id;
    private String title;
    private Double rating;

    public BasicMovieDTO() {
    }

    public BasicMovieDTO(String imdb_id, String title, Double rating) {
        this.imdb_id = imdb_id;
        this.title = title;
        this.rating = rating;
    }

    public String getImdb_id() {
        return imdb_id;
    }

    public void setImdb_id(String imdb_id) {
        this.imdb_id = imdb_id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Double getRating() {
        return rating;
    }

    public void setRating(Double rating) {
        this.rating = rating;
    }

    @Override
    public String toString() {
        return "BasicMovieDTO{" +
                "imdb_id='" + imdb_id + '\'' +
                ", title='" + title + '\'' +
                ", rating=" + rating +
                '}';
    }
}
