package com.example.filmwebapplication.Repositories;

import com.example.filmwebapplication.Models.Film;
import com.example.filmwebapplication.Models.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.ArrayList;

public interface FilmRepository extends JpaRepository<Film, Integer> {
    ArrayList<Film> findAllByGenre(String genre);
}