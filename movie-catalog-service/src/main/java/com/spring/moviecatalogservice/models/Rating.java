package com.spring.moviedataservice.models;

import lombok.Data;

@Data
public class Rating {
    private int rating;
    private String movieId;

    public Rating(int rating, String movieId) {
        this.rating = rating;
        this.movieId = movieId;
    }
}
