package com.movie.movieinfoservice.controller;

import com.movie.movieinfoservice.dto.RatingDto;
import com.movie.movieinfoservice.entity.Movie;
import com.movie.movieinfoservice.repository.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.Optional;

@RestController
@RequestMapping(path = "/api/v1")
@FeignClient(value = "movie", url= " \"http://localhost:8082/api/v1/ratings")
public class MovieController {

    @Autowired
    MovieRepository movieRepository;

    @Autowired
    private RestTemplate restTemplate;

    private static final String RATING_SERVICE = "http://localhost:8082/api/v1/ratings";


    @PostMapping("/movies")
    public Movie createMovie(@RequestBody Movie movie) {

        // call rating service to persist movies in rating table
        Movie savedMovie = movieRepository.save(movie);
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<Movie> request =
                new HttpEntity<Movie>(savedMovie, headers);

        ResponseEntity<RatingDto> ratingDto = restTemplate.postForEntity(RATING_SERVICE, request, RatingDto.class);
        return savedMovie;
    }


    @PutMapping("/movies")
    public Movie updateMovie(@RequestBody Movie movie) {
        return movieRepository.save(movie);
    }

//    @DeleteMapping("/movies/{id}")
//    public void deletemovie(@PathVariable Integer id) throws Exception {
//        try {
//            Movie existMovie = getMovie(id);
//            this.movieRepository.delete(existMovie);
//        } catch (Exception e) {
//            throw e;
//        }
//    }


//    @GetMapping("/movies/{id}")
//    public Movie getMovie(@PathVariable Integer id) throws Exception {
//        Optional<Movie> isMovieExist = movieRepository.findById(id);
//
//
//        if (isMovieExist.isPresent()) {
//            return isMovieExist.get();
//        }
//        throw new Exception("Movie is not Valid");
//    }



    //1 path variable
    //2 dont understand the function concept
    //3 you still dont understand the concepts of repositories
    //4


    @GetMapping("/movies/{movieId}")
    public Movie fetchtrating(@PathVariable Integer movieId) {

        Movie movieratings = this.movieRepository.findById(movieId).get();
        String url = "http://localhost:8082/api/v1/rating/" + movieId;
        Movie fetchedMpvie = restTemplate.getForObject(url, Movie.class);
        movieratings.setRatings(fetchedMpvie.getRatings());
        return movieratings;
    }




}




