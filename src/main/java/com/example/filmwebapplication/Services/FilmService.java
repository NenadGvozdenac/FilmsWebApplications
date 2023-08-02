package com.example.filmwebapplication.Services;

import com.example.filmwebapplication.DTOs.BasicMovieDTO;
import com.example.filmwebapplication.JsonResponses.BestMoviesListResponse;
import com.example.filmwebapplication.DTOs.GenreDTO;
import com.example.filmwebapplication.JsonResponses.MovieResponse;
import com.example.filmwebapplication.Models.Film;
import com.example.filmwebapplication.Repositories.FilmRepository;
import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static com.example.filmwebapplication.JsonParsers.JsonParser.parseMovieJsonResponse;
import static com.example.filmwebapplication.JsonParsers.JsonParser.parseGenresJsonResponse;
import static com.example.filmwebapplication.JsonParsers.JsonParser.parsePopularMoviesJsonResponse;

@Service
public class FilmService {

    @Autowired
    public FilmRepository filmRepository;

    private final static Integer MAXIMUM_FILMS = 500;
    private final static Integer MAXIMUM_FILMS_PER_PAGE = 50;
    private final static Integer MAXIMUM_ITERATIONS_FOR_FETCHING_DATA = MAXIMUM_FILMS / MAXIMUM_FILMS_PER_PAGE;

    public List<Film> fetchFilmData(Optional<Integer> numberOfFilms) throws UnirestException {
        ArrayList<BasicMovieDTO> movies = new ArrayList<>();

        Integer numberOfFilmsToWatch = numberOfFilms.orElse(MAXIMUM_FILMS);

        Integer maximumIterationToWatch = numberOfFilmsToWatch != 500 ? numberOfFilmsToWatch / MAXIMUM_FILMS_PER_PAGE : MAXIMUM_ITERATIONS_FOR_FETCHING_DATA;

        System.out.println(maximumIterationToWatch);

        for(int i = 1; i < maximumIterationToWatch + 1; i++) {
            HttpResponse<String> jsonResponse = Unirest.get("https://moviesminidatabase.p.rapidapi.com/movie/order/byRating/?page=" + i)
                    .header("X-RapidAPI-Key", "14c6fcdb9cmsh63a5a66619bfec7p113cd4jsn30848b9c1579")
                    .header("X-RapidAPI-Host", "moviesminidatabase.p.rapidapi.com")
                    .asString();

            BestMoviesListResponse mostPopularMoviesJsonResponse = parsePopularMoviesJsonResponse(jsonResponse.getBody());

            movies.addAll(mostPopularMoviesJsonResponse.getResults());
        }

        ArrayList<MovieResponse> listOfFilms = new ArrayList<>();

        for(BasicMovieDTO movie : movies) {
            String currentImdbID = movie.getImdb_id();

            HttpResponse<String> jsonResponse = Unirest.get("https://moviesminidatabase.p.rapidapi.com/movie/id/" + currentImdbID)
                    .header("X-RapidAPI-Key", "14c6fcdb9cmsh63a5a66619bfec7p113cd4jsn30848b9c1579")
                    .header("X-RapidAPI-Host", "moviesminidatabase.p.rapidapi.com")
                    .asString();

            listOfFilms.add(parseMovieJsonResponse(jsonResponse.getBody()));
        }

        List<Film> films = listOfFilms.stream().map(movieResponse -> new Film(movieResponse.getResults().getTitle(),
                movieResponse.getResults().getGen().get(0).getGenre(),
                movieResponse.getResults().getImdbId(),
                movieResponse.getResults().getYear(),
                movieResponse.getResults().getDescription().length() > 255
                        ? movieResponse.getResults().getDescription().substring(0, 251) + "..."
                        : movieResponse.getResults().getDescription())).toList();

        filmRepository.deleteAllInBatch();
        filmRepository.saveAll(films);

        return films;
    }

    public BestMoviesListResponse getMostPopularMoviesJsonResponse() throws UnirestException {
        HttpResponse<String> jsonResponse = Unirest.get("https://moviesminidatabase.p.rapidapi.com/movie/order/byRating/")
                .header("X-RapidAPI-Key", "14c6fcdb9cmsh63a5a66619bfec7p113cd4jsn30848b9c1579")
                .header("X-RapidAPI-Host", "moviesminidatabase.p.rapidapi.com")
                .asString();

        return parsePopularMoviesJsonResponse(jsonResponse.getBody());
    }

    public ArrayList<BasicMovieDTO> getMostPopularMovies() throws UnirestException {
        return getMostPopularMoviesJsonResponse().getResults();
    }

    public ArrayList<GenreDTO> getAllGenres() throws UnirestException {
        HttpResponse<String> jsonResponse = Unirest.get("https://moviesminidatabase.p.rapidapi.com/genres/")
                .header("X-RapidAPI-Key", "14c6fcdb9cmsh63a5a66619bfec7p113cd4jsn30848b9c1579")
                .header("X-RapidAPI-Host", "moviesminidatabase.p.rapidapi.com")
                .asString();

        return parseGenresJsonResponse(jsonResponse.getBody()).getResults();
    }
}
