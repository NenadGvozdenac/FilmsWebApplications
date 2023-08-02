package com.example.filmwebapplication.JsonResponses;

import com.example.filmwebapplication.DTOs.BasicMovieDTO;
import com.example.filmwebapplication.DTOs.Links;

import java.util.ArrayList;

public class BestMoviesListResponse {

    private Links links;

    private int count;

    private ArrayList<BasicMovieDTO> results;

    public BestMoviesListResponse() {
    }

    public BestMoviesListResponse(Links links, int count, ArrayList<BasicMovieDTO> results) {
        this.links = links;
        this.count = count;
        this.results = results;
    }

    public Links getLinks() {
        return links;
    }

    public void setLinks(Links links) {
        this.links = links;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public ArrayList<BasicMovieDTO> getResults() {
        return results;
    }

    public void setResults(ArrayList<BasicMovieDTO> results) {
        this.results = results;
    }
}
