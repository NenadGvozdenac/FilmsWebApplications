package com.example.filmwebapplication.JsonResponses;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class MovieResponse {
    private Results results;

    public MovieResponse() {
    }

    public Results getResults() {
        return results;
    }

    public static class Results {
        @JsonProperty("imdb_id")
        private String imdb_id;
        private String title;
        private int year;
        private int popularity;
        private String description;

        @JsonProperty("content_rating")
        private String content_rating;

        @JsonProperty("movie_length")
        private int movie_length;
        private double rating;

        @JsonProperty("created_at")
        private String created_at;
        private String trailer;

        @JsonProperty("image_url")
        private String image_url;
        private String release;
        private String plot;
        private String banner;
        private String type;

        @JsonProperty("more_like_this")
        private MoreLikeThis more_like_this;
        private List<Genre> gen;
        private List<Keyword> keywords;

        public String getImdbId() {
            return imdb_id;
        }

        public void setImdbId(String imdbId) {
            this.imdb_id = imdbId;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public int getYear() {
            return year;
        }

        public void setYear(int year) {
            this.year = year;
        }

        public int getPopularity() {
            return popularity;
        }

        public void setPopularity(int popularity) {
            this.popularity = popularity;
        }

        public String getDescription() {
            return description;
        }

        public void setDescription(String description) {
            this.description = description;
        }

        public String getContentRating() {
            return content_rating;
        }

        public void setContentRating(String contentRating) {
            this.content_rating = contentRating;
        }

        public int getMovieLength() {
            return movie_length;
        }

        public void setMovieLength(int movieLength) {
            this.movie_length = movieLength;
        }

        public double getRating() {
            return rating;
        }

        public void setRating(double rating) {
            this.rating = rating;
        }

        public String getCreatedAt() {
            return created_at;
        }

        public void setCreatedAt(String createdAt) {
            this.created_at = createdAt;
        }

        public String getTrailer() {
            return trailer;
        }

        public void setTrailer(String trailer) {
            this.trailer = trailer;
        }

        public String getImageUrl() {
            return image_url;
        }

        public void setImageUrl(String imageUrl) {
            this.image_url = imageUrl;
        }

        public String getRelease() {
            return release;
        }

        public void setRelease(String release) {
            this.release = release;
        }

        public String getPlot() {
            return plot;
        }

        public void setPlot(String plot) {
            this.plot = plot;
        }

        public String getBanner() {
            return banner;
        }

        public void setBanner(String banner) {
            this.banner = banner;
        }

        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }

        public MoreLikeThis getMoreLikeThis() {
            return more_like_this;
        }

        public void setMoreLikeThis(MoreLikeThis moreLikeThis) {
            this.more_like_this = moreLikeThis;
        }

        public List<Genre> getGen() {
            return gen;
        }

        public void setGen(List<Genre> gen) {
            this.gen = gen;
        }

        public List<Keyword> getKeywords() {
            return keywords;
        }

        public void setKeywords(List<Keyword> keywords) {
            this.keywords = keywords;
        }

        public Results() {
        }

        public static class MoreLikeThis {
            public MoreLikeThis() {
            }
        }

        public static class Genre {
            private int id;
            private String genre;

            public int getId() {
                return id;
            }

            public void setId(int id) {
                this.id = id;
            }

            public String getGenre() {
                return genre;
            }

            public void setGenre(String genre) {
                this.genre = genre;
            }

            public Genre() {
            }
        }

        public static class Keyword {
            @JsonProperty("id")
            private int keywordId; // Renamed to avoid conflicts with existing "id" fields

            @JsonProperty("keyword")
            private String keyword;

            public Keyword() {
            }
        }
    }
}
