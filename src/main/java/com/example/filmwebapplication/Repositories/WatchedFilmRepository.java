package com.example.filmwebapplication.Repositories;


import com.example.filmwebapplication.Models.Film;
import com.example.filmwebapplication.Models.WatchedFilm;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.ArrayList;
import java.util.Optional;

public interface WatchedFilmRepository extends JpaRepository<WatchedFilm, Integer> {
    Optional<WatchedFilm> findByUserUsernameAndFilmID(String username, Integer filmId);

    ArrayList<WatchedFilm> findByUserUsername(String username);
}