package com.movie.movieinfoservice.feignservice;


import com.movie.movieinfoservice.entity.Movie;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "Movies")
public interface MovieService {

    @GetMapping("/movie/{movieId}")
    default Movie getmovie(@PathVariable(Integer movieId)) {
        return Movie;
    }


}
