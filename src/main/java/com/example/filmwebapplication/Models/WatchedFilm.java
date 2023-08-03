package com.example.filmwebapplication.Models;

import jakarta.persistence.*;

@Entity
@Table(name = "watched_films")
public class WatchedFilm {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer ID;

    @Column(name = "user_username")
    private String userUsername;

    @Column(name = "film_id")
    private Integer filmID;

    @Column(name = "film_name")
    private String filmName;

    public WatchedFilm() {

    }

    public WatchedFilm(String userUsername, Integer filmID, String filmName) {
        this.userUsername = userUsername;
        this.filmID = filmID;
        this.filmName = filmName;
    }

    public Integer getID() {
        return ID;
    }

    public void setID(Integer ID) {
        this.ID = ID;
    }

    public String getUserUsername() {
        return userUsername;
    }

    public void setUserUsername(String userUsername) {
        this.userUsername = userUsername;
    }

    public Integer getFilmID() {
        return filmID;
    }

    public void setFilmID(Integer filmID) {
        this.filmID = filmID;
    }

    public String getFilmName() {
        return filmName;
    }

    public void setFilmName(String filmName) {
        this.filmName = filmName;
    }
}
