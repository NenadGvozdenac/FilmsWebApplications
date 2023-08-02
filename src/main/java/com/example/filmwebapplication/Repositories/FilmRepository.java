package com.example.filmwebapplication.Repositories;

import com.example.filmwebapplication.Models.Film;
import com.example.filmwebapplication.Models.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FilmRepository extends JpaRepository<Film, Integer> {

}