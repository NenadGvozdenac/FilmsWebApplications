package com.example.filmwebapplication.JsonResponses;

import com.example.filmwebapplication.DTOs.GenreDTO;

import java.util.ArrayList;

public class GenreListResponse {
    private ArrayList<GenreDTO> results;

    public ArrayList<GenreDTO> getResults() {
        return results;
    }

    public void setResults(ArrayList<GenreDTO> results) {
        this.results = results;
    }
}