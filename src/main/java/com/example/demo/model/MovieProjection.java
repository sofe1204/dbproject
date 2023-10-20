package com.example.demo.model;

import javax.persistence.*;
import java.util.Optional;

@Entity
@Table(name="movieprojection")
public class MovieProjection {
    @Id
    //@GeneratedValue
    Integer projection_id;
    String projection_movie_start;
    String projection_movie_end;
    String projection_screening_date;
    String projection_type;
    Float projection_price;

    @ManyToOne
    @JoinColumn(name="movie_id")
    private Movie movie;

    public MovieProjection(Integer projection_id, String projection_movie_start, String projection_movie_end, String projection_screening_date, String projection_type, Float projection_price, Movie movie) {
        this.projection_id=projection_id;
        this.projection_movie_start = projection_movie_start;
        this.projection_movie_end = projection_movie_end;
        this.projection_screening_date = projection_screening_date;
        this.projection_type = projection_type;
        this.projection_price = projection_price;
        this.movie = movie;
    }

    public MovieProjection() {

    }

    public Integer getProjection_id() {
        return projection_id;
    }

    public void setProjection_id(Integer projection_id) {
        this.projection_id = projection_id;
    }

    public String getProjection_movie_start() {
        return projection_movie_start;
    }

    public void setProjection_movie_start(String projection_movie_start) {
        this.projection_movie_start = projection_movie_start;
    }

    public String getProjection_movie_end() {
        return projection_movie_end;
    }

    public void setProjection_movie_end(String projection_movie_end) {
        this.projection_movie_end = projection_movie_end;
    }

    public String getProjection_screening_date() {
        return projection_screening_date;
    }

    public void setProjection_screening_date(String projection_screening_date) {
        this.projection_screening_date = projection_screening_date;
    }

    public String getProjection_type() {
        return projection_type;
    }

    public void setProjection_type(String projection_type) {
        this.projection_type = projection_type;
    }

    public Float getProjection_price() {
        return projection_price;
    }

    public void setProjection_price(Float projection_price) {
        this.projection_price = projection_price;
    }

    public Movie getMovie() {
        return movie;
    }

    public String getMovie_name(){
        return movie.getMovie_name();
    }
    public void setMovie(Movie movie) {
        this.movie = movie;
    }
}

