package com.venero.global.moviecatalogservice.model;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class Movie {
    private String movieId;
    private String name;
    private String description;

}
