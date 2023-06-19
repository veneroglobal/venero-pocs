package com.venero.global.movieinfoservice.controller;

import com.venero.global.movieinfoservice.model.Movie;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collections;
import java.util.List;

@RestController
@RequestMapping("/movie")
public class MovieController {

    @RequestMapping("/{movieId}")
    public List<Movie> getmovie(@PathVariable("movieId") String movieId){
        return Collections.singletonList(
                new Movie(movieId, "pk")
        );
    }
}
