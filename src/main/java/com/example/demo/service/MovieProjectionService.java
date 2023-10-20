package com.example.demo.service;

import com.example.demo.model.Movie;
import com.example.demo.model.MovieProjection;
import com.example.demo.model.dto.MovieProjectionDto;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

public interface MovieProjectionService {




    public List<MovieProjection> findAll() ;


    public Optional<MovieProjection> findById(Integer projection_id);
    public void deleteById(Integer projection_id);

    //public Optional<MovieProjection> findByName(String name);


    public Optional<MovieProjection> save(Integer projection_id,
                                          String projection_movie_start,
                                          String projection_movie_end,
                                          String projection_screening_date,
                                          String projection_type,
                                          Float projection_price,Integer movie_id);

    //public Optional<MovieProjection> save(MovieProjectionDto projectionDto);

    List<MovieProjection> findByMovieID(Integer movie_id);
}
