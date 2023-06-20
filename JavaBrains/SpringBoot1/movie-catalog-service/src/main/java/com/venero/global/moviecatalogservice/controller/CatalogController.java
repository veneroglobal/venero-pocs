package com.venero.global.moviecatalogservice.controller;


import com.venero.global.moviecatalogservice.model.CatalogItem;
import com.venero.global.moviecatalogservice.model.Movie;
import com.venero.global.moviecatalogservice.model.Rating;
import com.venero.global.moviecatalogservice.model.UserRating;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;


import java.util.Arrays;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/catalog")
public class CatalogController {


    @RequestMapping("/{userId}")
    public List<CatalogItem> getcatalog(@PathVariable("userId") String userId ) {

        RestTemplate restTemplate = new RestTemplate();

        UserRating ratings = restTemplate.getForObject("http://localhost:8087/api/v1/ratings" + userId , UserRating.class);

        return ratings.getUserRating().stream().map(rating -> {
                    Movie movie = restTemplate.getForObject("http://localhost:8086/movie" + rating.getMovieId(), Movie.class);

                    return new CatalogItem(movie.getName(), movie.getDescription(), rating.getRating());
                })

                .collect(Collectors.toList());

}
}
