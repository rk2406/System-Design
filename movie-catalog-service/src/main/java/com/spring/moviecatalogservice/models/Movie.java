package com.spring.movieinfoservice.models;

import lombok.Data;

@Data
public class Movie {
    private String movieId;
    private String name;

    public Movie(String movieId, String name) {
        this.movieId = movieId;
        this.name = name;
    }
}
