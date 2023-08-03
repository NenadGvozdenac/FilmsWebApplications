package com.example.filmwebapplication.Controllers;

import com.example.filmwebapplication.Configurations.JWTTokenValidator;
import com.example.filmwebapplication.Exceptions.AlreadyWatchedFilmException;
import com.example.filmwebapplication.Exceptions.DidntWatchFilmException;
import com.example.filmwebapplication.Exceptions.FilmDoesntExistException;
import com.example.filmwebapplication.Models.WatchedFilm;
import com.example.filmwebapplication.Services.WatchedFilmsService;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("/api")
public class WatchFilmsController {

    @Autowired
    public WatchedFilmsService watchedFilmsService;

    @Autowired
    public JWTTokenValidator jwtTokenValidator;

    @PostMapping("/film/{id}/watched")
    public ResponseEntity<?> addFilmToWatched(@NotNull @PathVariable(name = "id") Integer filmID, @NotNull @RequestHeader("token") String jwtToken) {
        String username = jwtTokenValidator.extractUsername(jwtToken);

        try {
            WatchedFilm film = watchedFilmsService.addFilmToWatched(username, filmID);
            return new ResponseEntity<>(film, HttpStatus.OK);
        } catch (AlreadyWatchedFilmException e) {
            return new ResponseEntity<>("Already watched this film!", HttpStatus.BAD_REQUEST);
        } catch (FilmDoesntExistException e) {
            return new ResponseEntity<>("Film doesnt exist!", HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping("/film/{id}/delete_watched")
    public ResponseEntity<?> removeFilmFromWatched(@NotNull @PathVariable(name = "id") Integer filmID, @NotNull @RequestHeader("token") String jwtToken) {
        String username = jwtTokenValidator.extractUsername(jwtToken);
        try {
            WatchedFilm film = watchedFilmsService.removeFilmFromWatched(username, filmID);
            return new ResponseEntity<>(film, HttpStatus.OK);
        } catch (FilmDoesntExistException e) {
            return new ResponseEntity<>("Film doesnt exist!", HttpStatus.BAD_REQUEST);
        } catch (DidntWatchFilmException e) {
            return new ResponseEntity<>("Didn't watch this film previously!", HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/user/get_watched")
    public ResponseEntity<ArrayList<WatchedFilm>> getWatchedFilms(@NotNull @RequestHeader("token") String jwtToken) {
        String username = jwtTokenValidator.extractUsername(jwtToken);
        ArrayList<WatchedFilm> watchedFilms = watchedFilmsService.getFilmsFromWatched(username);
        return new ResponseEntity<>(watchedFilms, HttpStatus.OK);
    }
}
