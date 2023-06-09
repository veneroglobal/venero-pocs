package com.movie.ratinginfoservice.controller;

import com.movie.ratinginfoservice.entity.Movie;
import com.movie.ratinginfoservice.entity.Rating;
import com.movie.ratinginfoservice.repository.RatingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.Optional;

@RestController
@RequestMapping("/api/v1")
public class RatingController {
    @Autowired
    RatingRepository ratingRepository;

    @RequestMapping(value = "/ratings", method = RequestMethod.POST)
    public Rating createRatings(@RequestBody Movie movie){


        Rating rating = new Rating();
        rating.setName(movie.getName());
        rating.setMovieId(movie.getId());
        return this.ratingRepository.save(rating);

    }
    @RequestMapping(value = "/ratings", method = RequestMethod.PUT)
    public Rating updateRatings(@RequestBody Rating rating){
        Rating currentRating = this.ratingRepository.findById(rating.getId()).get();
        currentRating.setNumberofpeople(rating.getNumberofpeople());
        currentRating.setRatings(rating.getRatings());
        return this.ratingRepository.save(currentRating);
    }

    @GetMapping("/ratings/{id}")
public Rating getRatings(@PathVariable Integer id) throws Exception {
        Optional<Rating> isRatingsExist = ratingRepository.findById(id);
        if (isRatingsExist.isPresent()) {
            return isRatingsExist.get();
        }

        // adding new comments for github
        throw new Exception("rating is not present for this movie");
    }


    @DeleteMapping("/ratings/{id}")
    public void deleeterating(@PathVariable Integer id)throws Exception{
        try{
            Rating existRating = getRatings(id);
            this.ratingRepository.delete(existRating);
        }catch (Exception e){
            throw e;
        }
    }

    // write one api that will take movie id as path param
    // and return the rating object to movie microservice

    @GetMapping("/rating/{movieId}")
    public Movie fetchRatings(@PathVariable Integer movieId){

        Rating movieRating = this.ratingRepository.findByMovieId(movieId);
        Movie movie = new Movie();
        movie.setRatings(movieRating.getRatings());
        return movie;
    }
}
