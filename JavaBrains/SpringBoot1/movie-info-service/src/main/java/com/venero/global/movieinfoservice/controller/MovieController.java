package com.venero.global.movieinfoservice.controller;

import com.venero.global.movieinfoservice.model.Movie;
import com.venero.global.movieinfoservice.repository.MovieRepository;
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
@RequestMapping("/api/v1")
public class MovieController {


    @Autowired
    private MovieRepository movieRepository;

    private final DataSource dataSource;

    public MovieController(DataSource dataSource) {
        this.dataSource = dataSource;
    }


    @PostMapping("/movies")
    public void createMovie(@RequestBody Movie movie) {
        try (Connection connection = dataSource.getConnection();
             PreparedStatement statement = connection.prepareStatement(
                     "INSERT INTO movie (movie_id, name, description) VALUES (?, ?,?)")) {
            statement.setString(1, movie.getMovieId());
            statement.setString(2, movie.getName());
            statement.setString(3,movie.getDescription());
            statement.executeUpdate();
        } catch (SQLException e) {

        }
    }

    @GetMapping("/movies")
    public List<Movie> getAllMovie() {
        List<Movie> movies = new ArrayList<>();
        try (Connection connection = dataSource.getConnection();
             PreparedStatement statement = connection.prepareStatement("SELECT * FROM movie");
             ResultSet resultSet = statement.executeQuery()) {
            while (resultSet.next()) {
                Movie movie = new Movie();
                movie.setMovieId(resultSet.getString("movie_id"));
                movie.setName(resultSet.getString("name"));
                movie.setDescription(resultSet.getString("description"));
                movies.add(movie);
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return movies;

    }


}










//@RequestMapping("/movie")
//    public Movie getmovie(@PathVariable("movieId") String movieId) {
//
//      return   new MOvie("1", "carry on jatta", " comedy");
//
//
//    }