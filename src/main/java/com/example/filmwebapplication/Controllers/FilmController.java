package com.example.filmwebapplication.Controllers;

import com.example.filmwebapplication.DTOs.BasicMovieDTO;
import com.example.filmwebapplication.DTOs.GenreDTO;
import com.example.filmwebapplication.DTOs.UserRegisterDTO;
import com.example.filmwebapplication.Models.Film;
import com.example.filmwebapplication.Services.FilmService;
import com.mashape.unirest.http.exceptions.UnirestException;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/film")
public class FilmController {

    @Autowired
    public FilmService filmService;

    @PostMapping("/fetch")
    public ResponseEntity<List<Film>> fetchFilmsFromApi() {
        try {
            List<Film> films = filmService.fetchFilmData(Optional.empty());
            return new ResponseEntity<>(films, HttpStatus.OK);
        } catch (UnirestException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/fetch/{number}")
    public ResponseEntity<List<Film>> fetchFilmsFromApiByNumber(@PathVariable Integer number) {
        try {
            List<Film> films = filmService.fetchFilmData(Optional.of(number));
            return new ResponseEntity<>(films, HttpStatus.OK);
        } catch (UnirestException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/most_popular")
    public ResponseEntity<ArrayList<BasicMovieDTO>> getMostPopularFilms() {
        try {
            ArrayList<BasicMovieDTO> movies = filmService.getMostPopularMovies();
            return new ResponseEntity<>(movies, HttpStatus.OK);
        } catch (UnirestException e) {
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/genres")
    public ResponseEntity<ArrayList<GenreDTO>> fetchGenres() {
        try {
            ArrayList<GenreDTO> genres = filmService.getAllGenres();
            return new ResponseEntity<>(genres, HttpStatus.OK);
        } catch (UnirestException e) {
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
    }
}
