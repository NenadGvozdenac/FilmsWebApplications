package com.example.filmwebapplication.Services;

import com.example.filmwebapplication.Exceptions.AlreadyWatchedFilmException;
import com.example.filmwebapplication.Exceptions.DidntWatchFilmException;
import com.example.filmwebapplication.Exceptions.FilmDoesntExistException;
import com.example.filmwebapplication.Models.Film;
import com.example.filmwebapplication.Models.WatchedFilm;
import com.example.filmwebapplication.Repositories.FilmRepository;
import com.example.filmwebapplication.Repositories.WatchedFilmRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Optional;

@Service
public class WatchedFilmsService {

    @Autowired
    FilmRepository filmRepository;

    @Autowired
    WatchedFilmRepository watchedFilmRepository;

    public WatchedFilm addFilmToWatched(String username, Integer filmID) throws AlreadyWatchedFilmException, FilmDoesntExistException {
        Optional<Film> film = filmRepository.findById(filmID);
        if(film.isPresent()) {
            if(watchedFilmRepository.findByUserUsernameAndFilmID(username, filmID).isPresent())
                throw new AlreadyWatchedFilmException();

            WatchedFilm watchedFilm = new WatchedFilm(username, film.get().getID(), film.get().getTitle());
            watchedFilmRepository.save(watchedFilm);

            return watchedFilm;
        } else throw new FilmDoesntExistException();
    }

    public WatchedFilm removeFilmFromWatched(String username, Integer filmID) throws FilmDoesntExistException, DidntWatchFilmException {
        Optional<Film> film = filmRepository.findById(filmID);
        if(film.isPresent()) {
            Optional<WatchedFilm> watchedFilm = watchedFilmRepository.findByUserUsernameAndFilmID(username, filmID);
            if(watchedFilm.isEmpty())
                throw new DidntWatchFilmException();

            watchedFilmRepository.delete(watchedFilm.get());
            return watchedFilm.get();
        } else throw new FilmDoesntExistException();
    }


    public ArrayList<WatchedFilm> getFilmsFromWatched(String username) {
        return watchedFilmRepository.findByUserUsername(username);
    }
}
