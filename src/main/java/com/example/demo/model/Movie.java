package com.example.demo.model;

import com.example.demo.model.IS_.MovieGenreCombination;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name="movie")
public class Movie{
    @Id
    //@GeneratedValue(strategy = GenerationType.AUTO)
    Integer movie_id;

    String movie_name;
    String movie_age_category;
    String movie_production;
    String movie_film_director;
    String movie_cast;
    String movie_time_duration;


    public Movie(Integer movie_id, String movie_name, String movie_age_category, String movie_production, String movie_film_director, String movie_cast, String movie_time_duration) {
        this.movie_id=movie_id;
        this.movie_name = movie_name;
        this.movie_age_category = movie_age_category;
        this.movie_production = movie_production;
        this.movie_film_director = movie_film_director;
        this.movie_cast = movie_cast;
        this.movie_time_duration = movie_time_duration;
    }

    public Movie() {

    }

    public Integer getMovie_id() {
        return movie_id;
    }

    public void setMovie_id(Integer movie_id) {
        this.movie_id = movie_id;
    }

    public String getMovie_name() {
        return movie_name;
    }

    public void setMovie_name(String movie_name) {
        this.movie_name = movie_name;
    }

    public String getMovie_age_category() {
        return movie_age_category;
    }

    public void setMovie_age_category(String movie_age_category) {
        this.movie_age_category = movie_age_category;
    }

    public String getMovie_production() {
        return movie_production;
    }

    public void setMovie_production(String movie_production) {
        this.movie_production = movie_production;
    }

    public String getMovie_film_director() {
        return movie_film_director;
    }

    public void setMovie_film_director(String movie_film_director) {
        this.movie_film_director = movie_film_director;
    }

    public String getMovie_cast() {
        return movie_cast;
    }

    public void setMovie_cast(String movie_cast) {
        this.movie_cast = movie_cast;
    }

    public String getMovie_time_duration() {
        return movie_time_duration;
    }

    public void setMovie_time_duration(String movie_time_duration) {
        this.movie_time_duration = movie_time_duration;
    }
}
