package com.movie.ratinginfoservice.repository;

import com.movie.ratinginfoservice.entity.Rating;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface RatingRepository  extends CrudRepository<Rating, Integer> {


    public Rating findByMovieId(Integer movieId);

}


