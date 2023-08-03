package com.example.filmwebapplication.JsonParsers;

import com.example.filmwebapplication.DTOs.BasicMovieDTO;
import com.example.filmwebapplication.JsonResponses.BestMoviesListResponse;
import com.example.filmwebapplication.JsonResponses.GenreListResponse;
import com.example.filmwebapplication.JsonResponses.MovieResponse;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Component;

import java.util.ArrayList;

@Component
public final class JsonParser {

    public static BestMoviesListResponse parsePopularMoviesJsonResponse(String json) {
        ArrayList<BasicMovieDTO> movies = new ArrayList<>();
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            return objectMapper.readValue(json, BestMoviesListResponse.class);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static GenreListResponse parseGenresJsonResponse(String json) {
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            return objectMapper.readValue(json, GenreListResponse.class);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static MovieResponse parseMovieJsonResponse(String json) {
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            return objectMapper.readValue(json, MovieResponse.class);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return null;
    }
}
