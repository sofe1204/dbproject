package com.example.demo.model.dto;

import lombok.Data;

@Data
public class MovieDto {
    public Integer movie_id;
    public String movie_name;
    public String movie_age_category;
    public String movie_production;
    public String movie_film_director;
    public String movie_cast;
    public String movie_time_duration;

    public MovieDto(Integer movie_id,String movie_name, String movie_age_category, String movie_production, String movie_film_director, String movie_cast, String movie_time_duration) {
        this.movie_id = movie_id;
        this.movie_name = movie_name;
        this.movie_age_category = movie_age_category;
        this.movie_production = movie_production;
        this.movie_film_director = movie_film_director;
        this.movie_cast = movie_cast;
        this.movie_time_duration = movie_time_duration;
    }
}
