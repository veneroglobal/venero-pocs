package com.venero.global.ratinginfoservice.controller;


import com.venero.global.ratinginfoservice.model.Rating;

import com.venero.global.ratinginfoservice.repository.RatingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import java.util.List;


@RestController
@RequestMapping("api/v1")
public class RatingController {

    @Autowired
    private RatingRepository ratingRepository;

    private final DataSource dataSource;

    public RatingController(DataSource dataSource) {
        this.dataSource = dataSource;
    }


    @PostMapping("/ratings")
   public void createRating(@RequestBody Rating rating) {
        try (Connection connection = dataSource.getConnection();
             PreparedStatement statement = connection.prepareStatement(
                     "INSERT INTO rating (rating, movie_id) VALUES (?, ?)")) {
            statement.setFloat(1, rating.getRating());
            statement.setString(2, rating.getMovieId());
            statement.executeUpdate();
        } catch (SQLException e) {

        }
    }

    @GetMapping("/ratings")
    public List<Rating> getAllRating() {
        List<Rating> ratings = new ArrayList<>();
        try (Connection connection = dataSource.getConnection();
             PreparedStatement statement = connection.prepareStatement("SELECT * FROM rating");
             ResultSet resultSet = statement.executeQuery()) {
            while (resultSet.next()) {
                Rating rating = new Rating();
                rating.setRating(resultSet.getFloat("rating"));
                rating.setMovieId(resultSet.getString("movie_id"));
                ratings.add(rating);
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return ratings;

    }
}









//@RequestMapping("/{movieId}")
//    public Rating getRatings(@PathVariable("movieId") String movieId) {
//        return new Rating(movieId, 4.5f);
//
//    }
//
//    @RequestMapping("user/{userId}")
//    public UserRating getUserRating(@PathVariable("userId") String userId) {
//
//        List<Rating> ratings = Arrays.asList(
//                new Rating("1", 4.1f),
//                new Rating("2", 4.2f)
//
//        );
//
//        UserRating userRating = new UserRating();
//        userRating.setUserRating(ratings);
//        return userRating;
//
//
//    }