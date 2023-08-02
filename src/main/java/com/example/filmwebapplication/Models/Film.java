package com.example.filmwebapplication.Models;

import jakarta.persistence.*;
import org.springframework.stereotype.Repository;

@Entity
@Table(name = "films")
public class Film {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer ID;

    private String title;

    private String genre;

    private String imdb_id;

    private Integer year;

    private String description;

    public Film() {
        this.ID             = null;
        this.title          = null;
        this.genre          = null;
        this.imdb_id        = null;
        this.year           = null;
        this.description    = null;
    }

    public Film(String title, String genre, String imdb_id, Integer year, String description) {
        this.ID = null;
        this.title = title;
        this.genre = genre;
        this.imdb_id = imdb_id;
        this.year = year;
        this.description = description;
    }

    public Integer getID() {
        return ID;
    }

    public void setID(Integer ID) {
        this.ID = ID;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getImdb_id() {
        return imdb_id;
    }

    public void setImdb_id(String imdb_id) {
        this.imdb_id = imdb_id;
    }

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
