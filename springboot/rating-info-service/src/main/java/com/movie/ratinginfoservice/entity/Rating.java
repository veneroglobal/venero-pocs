package com.movie.ratinginfoservice.entity;

import jakarta.persistence.*;

@Entity
@Table (name = "ratings")
public class Rating {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;

    private float ratings;
    @Column(name = "noofpeople")
    private double numberofpeople;

    @Column(name = "movie_id")
    private Integer movieId;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getRatings() {
        return ratings;
    }

    public void setRatings(float ratings) {
        this.ratings = ratings;
    }

    public double getNumberofpeople() {
        return numberofpeople;
    }

    public void setNumberofpeople(double numberofpeople) {
        this.numberofpeople = numberofpeople;
    }

    public Integer getMovieId() {
        return movieId;
    }

    public void setMovieId(Integer movieId) {
        this.movieId = movieId;
    }
}
